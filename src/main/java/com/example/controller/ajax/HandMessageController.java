package com.example.controller.ajax;

import com.example.core.config.Global;
import com.example.po.AcceptMessage;
import com.example.po.AcceptTextMessage;
import com.example.po.Task;
import com.example.po.User;
import com.example.po.template.OrgAndUsers;
import com.example.po.template.Template;
import com.example.service.HandlerService;
import com.fasterxml.jackson.core.JsonProcessingException;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Ehcache;
import net.sf.ehcache.Element;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 手动发送以及消息的处理
 */
@SuppressWarnings("all")
@Controller
@RequestMapping("/hand")
public class HandMessageController {

	@Autowired
	private CacheManager cacheManager;

	@Autowired
	private HandlerService handlerService;

	// 是否开启对微信消息的人工审核 check的 修改和状态的获取并持久化
	@RequestMapping(value = "/edit_check", method = { RequestMethod.GET })
	@ResponseBody
	public Object updateCheckStatus(Boolean check, HttpServletResponse response) { // 开启或关闭 WX消息的人工审核
		Map<String, Object> resultMap = new HashMap<>();
		if (check == null) {
			resultMap.put("isSuccess", Boolean.FALSE);
			resultMap.put("message", "参数有误");
			response.setStatus(400);
			return resultMap;
		}
		Ehcache cache = cacheManager.getEhcache("content");
		Global.check = check;
		cache.put(new Element("check", Global.check));
		cache.flush();
		resultMap.put("isSuccess", Boolean.TRUE);
		resultMap.put("message", "修改成功");
		return resultMap;
	}

	// 获取 审核标志check的值
	@RequestMapping(value = "/get_check", method = { RequestMethod.GET })
	@ResponseBody
	public Object getCheckStatus() { // 获取 WX消息的人工审核的状态
		Map<String, Object> resultMap = new HashMap<>();
		resultMap.put("check", Global.check);
		return resultMap;
	}

	/**
	 * 获取对应状态的消息 
	 * 
	 * @param taskId
	 *            注意：这里的taskId 即是currentTaskNum
	 * @param status
	 *            是指 待审核、上墙、下墙
	 * @param response
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/message", method = { RequestMethod.GET })
	@ResponseBody
	public Object getMessageByStatus(Long taskId, Integer status, HttpServletResponse response) { // 获取 对应你演练任务和对应状态的信息

		// 校验
		if (taskId == null || status == null || !(status != null && status.intValue() >= 0 && status.intValue() <= 2)) {
			response.setStatus(400);
			return "参数非法";
		}
		Ehcache cache = cacheManager.getEhcache("content");
		if(!cache.isKeyInCache("task_" + taskId)) {
			response.setStatus(404);
			return "访问的数据不存在";
		}
		// 验证下标是否合法
		Task task = (Task) cache.get("task_" + taskId).getObjectValue();
		Template template = (Template) cache.get("template_" + task.getTemplateId()).getObjectValue();

		List<AcceptMessage> messages = new ArrayList<>();
		List<String> keys = cache.getKeys();
		for (String key : keys) {
			if (key.startsWith("message_" + taskId + "_")) {
				Object value = cache.get(key).getObjectValue();
				if (value instanceof AcceptTextMessage) {
					AcceptTextMessage message = (AcceptTextMessage) value;
					if (message.getStatus().equals(status) && !message.getIndex().equals(0)
							&& !message.getIndex().equals(template.getStageScenes().size() - 1)) {
						messages.add(message);
					}
				}
				// 暂不返回图片消息
				// if (value instanceof AcceptImageMessage) {
				// AcceptImageMessage message = (AcceptImageMessage) value;
				// if (message.getStatus().equals(status) && message.getIndex().equals(index)) {
				// messages.add(message);
				// }
				// }
			}
		}
		Collections.sort(messages, new Comparator<AcceptMessage>() {
			@Override
			public int compare(AcceptMessage o1, AcceptMessage o2) {
				return o2.getCreateTime().compareTo(o1.getCreateTime());
			}
		});
		cache.flush();
		return messages;
	}

	/**
	 * 获取某次演练 指定场景的所有消息
	 * @param taskId
	 * @param index
	 * @param response
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/all_message", method = { RequestMethod.GET })
	@ResponseBody
	public Object getAllMessage(Long taskId, Integer index, HttpServletResponse response) { // 获取某次演练的所有消息
		if (taskId == null || index == null) {
			response.setStatus(400);
			return "参数非法";
		}
		Ehcache cache = cacheManager.getEhcache("content");
		List<AcceptMessage> messages = new ArrayList<>();
		List<String> keys = cache.getKeys();
		for (String key : keys) {
			if (key.startsWith("message_" + taskId + "_")) {
				Object value = cache.get(key).getObjectValue();
				if (value instanceof AcceptTextMessage) {
					AcceptTextMessage message = (AcceptTextMessage) value;
					if (message.getIndex().equals(index) && message.getStatus().equals(1)) {
						messages.add(message);
					}
				}
			}
		}

		Collections.sort(messages, new Comparator<AcceptMessage>() {

			@Override
			public int compare(AcceptMessage o1, AcceptMessage o2) {
				return o2.getCreateTime().compareTo(o1.getCreateTime());
			}
		});

		cache.flush();
		return messages;
	}

	/**
	 * 对手动发送的消息进行处理
	 * 
	 * @param label
	 *            组织单位名称-用户名
	 * @param content
	 *            发送内容
	 * @param response
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "send", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public Object sendMessage(String label, String content, HttpServletResponse response) {
		response.setCharacterEncoding("utf-8");
		Map<String, Object> resultMap = new HashMap<>();
		Boolean invalid = Boolean.TRUE;

		// 进行校验
		if (Global.currentTaskNum.longValue() == 0) {
			resultMap.put("isSuccess", Boolean.FALSE);
			resultMap.put("message", "演练已经关闭");
			response.setStatus(403);
			return resultMap;
		}

		if (label == null || content == null) { // 判断非空
			invalid = Boolean.FALSE;
		}

		Pattern p = Pattern.compile("(.+)(-)(.+)");
		Matcher m = p.matcher(label);
		String orgName = "";
		String userName = "";
		Ehcache cache = cacheManager.getEhcache("content");
		if (m.find()) {
			orgName = m.group(1).trim();
			userName = m.group(3).trim();
			List<String> orgNameList = (List<String>) cache.get("currentTaskOrgList").getObjectValue();
			if (orgName.length() == 0 || userName.length() == 0 || content.trim().length() == 0
					|| !orgNameList.contains(orgName)) {
				invalid = Boolean.FALSE;
			} else {
				invalid = Boolean.TRUE;
			}
		} else {
			invalid = false;
		}

		if (!invalid) {
			resultMap.put("isSuccess", Boolean.FALSE);
			resultMap.put("message", "输入不合法");
			response.setStatus(400);
			cache.flush();
			return resultMap;
		}

		// 输入合法 进行消息和用户的处理
		Boolean result = handlerService.sendMessage(userName, orgName, content);
		cache.flush();
		if (result) {
			resultMap.put("isSuccess", Boolean.TRUE);
			resultMap.put("message", "成功处理");
			return resultMap;
		} else {
			resultMap.put("isSuccess", Boolean.FALSE);
			resultMap.put("message", "服务器异常");
			response.setStatus(500);
			return resultMap;
		}
	}

	/**
	 * 根据消息的msgId修改指定消息的状态 例如：审核，上墙，下墙
	 * 
	 * @param msgId
	 * @param status
	 * @param response
	 * @return
	 */
	@SuppressWarnings("all")
	@RequestMapping(value = "/edit_status", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public Object eidtMessageStatus(String msgId, Integer status, HttpServletResponse response) {
		if (msgId == null) {
			response.setStatus(400);
			return "参数非法";
		}

		if (Global.currentTaskNum == 0) {
			response.setStatus(400);
			return "演练已经结束";
		}

		Ehcache cache = cacheManager.getEhcache("content");
		Object message = null;
		String msgKey = null;
		List<String> keys = cache.getKeys();
		for (String key : keys) {
			if (key.startsWith("message_") && key.endsWith(msgId.toString())) {
				message = cache.get(key).getObjectValue();
				msgKey = key;
			}
		}

		if (message == null || msgKey == null) {
			response.setStatus(404);
			cache.flush();
			return "没有此消息";
		}

		if (!msgKey.contains(Global.currentTaskNum.toString())) {
			cache.flush();
			response.setStatus(400);
			return "不可对历史消息进行修改";
		}

		if (message instanceof AcceptTextMessage) {
			AcceptTextMessage acceptTextMessage = (AcceptTextMessage) message;
			acceptTextMessage.setStatus(status);
			cache.put(new Element(msgKey, acceptTextMessage));
			cache.flush();
			return "修改消息状态成功";
		} else {
			response.setStatus(403);
			cache.flush();
			return "图片消息已被隐藏，不能展示";
		}
	}

	/**
	 * 删除消息
	 * 
	 * @param msgId
	 *            消息ID
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/delmessage", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public Object deleteMessage(String msgId, HttpServletResponse response) {
		// 校验
		if (msgId == null) {
			response.setStatus(400);
			return "参数为空";
		}
		if (Global.currentTaskNum == 0) {
			response.setStatus(403);
			return "演练已经结束，请开启新的演练";
		}
		// 验证msgId 是否合法
		Ehcache cache = cacheManager.getEhcache("content");
		List<String> keys = cache.getKeys();
		for (String key : keys) {
			if (key.startsWith("message_") && key.endsWith("_" + msgId)) {
				if (key.contains(Global.currentTaskNum.toString())) {
					cache.remove(key);
					cache.flush();
					return "删除成功";
				} else {
					cache.flush();
					response.setStatus(400);
					return "演练结束的历史消息不可被删除";
				}
			}
		}

		response.setStatus(404);
		return "Not Found";
	}

	/**
	 * 在演练过程中切换阶段
	 * 
	 * @param index
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/switch_stage", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public Object switchStageIndex(Integer index, HttpServletResponse response) {
		if (index == null) {
			response.setStatus(400);
			return "参数非法";
		}
		if (Global.currentTaskNum == 0) {
			response.setStatus(400);
			return "演练已结束，请开启新的演练";
		}

		Ehcache cache = cacheManager.getEhcache("content");
		if (!cache.isKeyInCache("task_" + Global.currentTaskNum)) {
			cache.flush();
			response.setStatus(404);
			return "找不到对应数据";
		}
		Task task = (Task) cache.get("task_" + Global.currentTaskNum).getObjectValue();
		Template template = (Template) cache.get("template_" + task.getTemplateId()).getObjectValue();
		if (index.intValue() >= 0 && index.intValue() <= template.getStageScenes().size() - 1) {
			Global.index = index;
			cache.put(new Element("index", index.intValue()));
			cache.flush();
			return "切换成功";
		} else {
			cache.flush();
			response.setStatus(400);
			return "参数错误";
		}
	}

	/**
	 * 获取某次演练中对应的单位以及该单位下的成员
	 * 
	 * @param taskId
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/org_users", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public Object getOrgAndUsers(Task taskParam, HttpServletResponse response) {
		Long taskId = taskParam.getTime();
		if (taskId == null) {
			response.setStatus(400);
			return "参数非法";
		}
		Ehcache cache = cacheManager.getEhcache("content");
		if (!cache.isKeyInCache("task_" + taskId)) {
			cache.flush();
			response.setStatus(404);
			return "找不到对应数据";
		}

		Task task = (Task) cache.get("task_" + taskId).getObjectValue();
		Template template = (Template) cache.get("template_" + task.getTemplateId()).getObjectValue();
		List<String> orgNames = template.getOrgList();
		Map<String, List<User>> usersMap = new HashMap<>();
		for (String orgName : orgNames) {
			usersMap.put(orgName, new ArrayList<User>());
		}

		List<String> keys = cache.getKeys();
		for (String key : keys) {
			if (key.startsWith("user_" + taskId)) {
				User user = (User) cache.get(key).getObjectValue();
				usersMap.get(user.getOrgName()).add(user);
			}
		}

		List<OrgAndUsers> orgAndUsers = new ArrayList<>();
		for (Entry<String, List<User>> entry : usersMap.entrySet()) {
			OrgAndUsers orgAndUser = new OrgAndUsers();
			orgAndUser.setOrgName(entry.getKey());
			orgAndUser.setUsers(entry.getValue());
			orgAndUsers.add(orgAndUser);
		}
		cache.flush();
		return orgAndUsers;
	}
	
	/**
	 * 获取已上墙的人数 和已上墙的消息条数
	 * @param taskId
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/num", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public Object getOnWalletUserNum(Long taskId,HttpServletResponse response) {
		if (taskId == null) {
			response.setStatus(400);
			return "参数非法";
		}
		
		Ehcache cache = cacheManager.getEhcache("content");
		// 首先获取所有的消息
		Task task = (Task) cache.get("task_" + taskId).getObjectValue();
		Template template = (Template) cache.get("template_" + task.getTemplateId()).getObjectValue();

		Set<String> userIds = new HashSet<String>();
		Long msgNum = 0L;
		List<AcceptMessage> messages = new ArrayList<>();
		List<String> keys = cache.getKeys();
		for (String key : keys) {
			if (key.startsWith("message_" + taskId + "_")) {
				Object value = cache.get(key).getObjectValue();
				if (value instanceof AcceptTextMessage) {
					AcceptTextMessage message = (AcceptTextMessage) value;
					if (message.getStatus().equals(1) && !message.getIndex().equals(0)
							&& !message.getIndex().equals(template.getStageScenes().size() - 1)) {
						msgNum++;
						userIds.add(message.getUser().getWxUserName());
					}
				}
			}
		}
		Map<String, Object> resultMap = new HashMap<>();
		resultMap.put("msgNum", msgNum);
		resultMap.put("userNum", userIds.size());
		cache.flush();
		return resultMap;
	}

}
