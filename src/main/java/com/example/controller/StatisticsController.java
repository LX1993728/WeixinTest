package com.example.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Ehcache;
import net.sf.ehcache.Element;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.core.config.Global;
import com.example.core.utils.DateUtil;
import com.example.po.Task;

/**
 * 创建时间：2017年12月20日 上午11:12:13 项目名称：WeixinTest
 * 
 * @author wy
 * @version 1.0
 * @since JDK 1.6.0_21 文件名称：StatisticsController.java 类说明：
 */
@Controller
@RequestMapping("/statistic")
public class StatisticsController {

	private static Integer currInputPersonNum = 0;
	private static double[] averageScore = new double[16];
	Long tmp = Global.currentTaskNum;
	private static CacheManager cacheManager = CacheManager.newInstance();

	@RequestMapping("/statisticByScore")
	@ResponseBody
	public Map<String, List<Object>> statisticByScore(String params) {
		if (tmp != 0 && tmp != Global.currentTaskNum) {
			averageScore = new double[16];
			currInputPersonNum = 0;
			tmp = Global.currentTaskNum;
		}
		// 当前用户数加一
		currInputPersonNum++;
		JSONArray array = JSON.parseArray(params);
		JSONArray averageArray = new JSONArray();
		System.out.println("传过来的数组");
		System.out.println(array);
		BigDecimal[] total = new BigDecimal[16];
		double[] arrayScore = { 0.06, 0.04, 0.06, 0.04, 0.03, 0.02, 0.05, 0.1,
				0.05, 0.05, 0.2, 0.1, 0.1, 0.04, 0.04, 0.02 };
		double sumScore = 0L;
		// 处理累加值问题
		for (int i = 0; i < array.size(); i++) {
			double tmp = averageScore[i] * (currInputPersonNum - 1)
					+ array.getDoubleValue(i);
			averageArray.add(i, tmp / currInputPersonNum);
			averageScore[i] = averageArray.getDoubleValue(i);
			sumScore += averageScore[i] * 1.25;
		}
        
		List<Object> firstLevel = new ArrayList<Object>();
		List<Object> secendLevel = new ArrayList<Object>();
		List<Object> thirdLevel = new ArrayList<Object>();
		List<Object> sumScoreList = new ArrayList<Object>();
		JSONObject firstObject = new JSONObject();
		JSONObject secendObject = new JSONObject();
		JSONObject thirdObject = new JSONObject();
		Map<String, List<Object>> map = new HashMap<>();
		sumScoreList.add(sumScore);
		if (averageArray.size() > 0) {
			for (int i = 0; i < averageArray.size(); i++) {
				BigDecimal bigDecimal1 = new BigDecimal(
						Double.toString(averageArray.getDoubleValue(i)));
				BigDecimal bigDecimal2 = new BigDecimal(
						Double.toString(arrayScore[i]));
				total[i] = bigDecimal1.multiply(bigDecimal2);
			}

			// 一级指标
			BigDecimal value = total[0].add(total[1].add(total[2])
					.add(total[3]).add(total[4]).add(total[5]));
			firstObject.put("演练准备", count(value, 1.25));
			value = total[6].add(total[7].add(total[8]).add(total[9])
					.add(total[10]).add(total[11]).add(total[12]));
			firstObject.put("演练实施", count(value, 3.25));
			value = total[13].add(total[14].add(total[15]));
			firstObject.put("总结阶段", count(value, 0.5));
			firstLevel.add(firstObject);
			// 二级指标
			value = total[0].add(total[1]);
			secendObject.put("演练组织",
					value.divide(new BigDecimal(Double.toString(0.5)))
							.multiply(new BigDecimal(Double.toString(2))));
			value = total[2].add(total[3]);
			secendObject.put("演练方案", count(total[2].add(total[3]), 0.5));
			secendObject.put("演练保障", count(total[4].add(total[5]), 0.25));
			secendObject.put("信息沟通",
					count(total[6].add(total[7]).add(total[8]), 1));
			secendObject.put("应急响应",
					count(total[9].add(total[10]).add(total[11]), 1.75));
			secendObject.put("舆情应对", count(total[12], 0.5));
			secendObject.put("演练分析", count(total[13].add(total[14]), 0.4));
			secendObject.put("资料整理", count(total[15], 0.1));
			secendLevel.add(secendObject);
			// 三级指标
			thirdObject.put("组织指挥机构", countThirdLevel(total[0], 0.3));
			thirdObject.put("处置队伍", countThirdLevel(total[1], 0.2));
			thirdObject.put("演练计划", countThirdLevel(total[2], 0.3));
			thirdObject.put("情景构建", countThirdLevel(total[3], 0.2));
			thirdObject.put("场地保障", countThirdLevel(total[4], 0.15));
			thirdObject.put("经费保障", countThirdLevel(total[5], 0.1));
			thirdObject.put("演练解说", countThirdLevel(total[6], 0.25));
			thirdObject.put("信息报告", countThirdLevel(total[7], 0.5));
			thirdObject.put("信息披露", countThirdLevel(total[8], 0.25));
			thirdObject.put("分级响应", countThirdLevel(total[9], 0.25));
			thirdObject.put("处置措施", countThirdLevel(total[10], 1));
			thirdObject.put("指挥控制能力", countThirdLevel(total[11], 0.5));
			thirdObject.put("舆论引导", countThirdLevel(total[12], 0.5));
			thirdObject.put("点评分析", countThirdLevel(total[13], 0.2));
			thirdObject.put("总结提炼", countThirdLevel(total[14], 0.2));
			thirdObject.put("演练记录", countThirdLevel(total[15], 0.1));
			thirdLevel.add(thirdObject);

			map.put("一级指标", firstLevel);
			map.put("二级指标", secendLevel);
			map.put("三级指标", thirdLevel);
			map.put("sumScore", sumScoreList);

			Ehcache cache = cacheManager.getEhcache("content");
			cache.put(new Element("statistic" + Global.currentTaskNum, map));
			cache.flush();
			return map;
		}
		return null;
	}

	public BigDecimal count(BigDecimal value, double b) {
		return value.divide(new BigDecimal(Double.toString(b)),2).multiply(
				new BigDecimal(Double.toString(2)));
	}

	public BigDecimal countThirdLevel(BigDecimal value, double b) {
		return value.divide(new BigDecimal(Double.toString(b)),2).multiply(
				new BigDecimal(Double.toString(516)));
	}

	/**
	 * 获取统计结果
	 * 
	 * @return
	 */
	@RequestMapping("/getStatisticData")
	@ResponseBody
	public Map<String, List<Object>> getStatisticData() {
		Ehcache cache = cacheManager.getEhcache("content");
		Element element = cache.get("statistic" + Global.currentTaskNum);
		cache.flush();
		if (null != element) {
			Map<String, List<Object>> map = (Map<String, List<Object>>) element
					.getObjectValue();// 获取到的缓存数据
			return map;
		}
		return null;
	}

	@RequestMapping("/getPersonNum")
	@ResponseBody
	public Map<String, Object> getPersonNum(HttpSession session) {
		Ehcache cache = cacheManager.getEhcache("content");
		Map<String, Object> map = new HashMap<String, Object>();
		Task task = (Task) session.getAttribute("task");
		if (null != task) {
			String pre = "user_" + task.getTime();
			List<String> keys = cache.getKeys();
			cache.flush();
			int count = 0;
			for (String key : keys) {
				if (key.startsWith(pre)) {
					count++;
				}
			}
			map.put("count", count);
			return map;
		}
		return map;

	}

	/**
	 * 获取演练时间
	 * 
	 * @param session
	 * @return
	 */

	@RequestMapping("/getTaskTime")
	@ResponseBody
	public Map<String, Object> getTaskTime(HttpSession session) {
		Ehcache cache = cacheManager.getEhcache("content");
		Map<String, Object> map = new HashMap<String, Object>();
		Task task = (Task) session.getAttribute("task");
		if (null != task) {
			Long taskId = task.getTime();
			List<String> taskIds = new ArrayList<String>();
			List<String> keys = cache.getKeys();
			cache.flush();
			for (String key : keys) {
				if (key.startsWith("task_")) {
					taskIds.add(key);
				}
			}
			Collections.sort(taskIds);
			if (Global.currentTaskNum == taskId) {
				long time = new Date().getTime() - new Date(taskId).getTime();
				return DateUtil.getDate(time);
			} else {
				int index = taskIds.indexOf(taskId);
				if (index >= 0 && (index + 1) < taskIds.size()) {
					String nextTask = taskIds.get(index + 1);
					String[] nextTaskArray = nextTask.split("_");
					long nextTime = Long.parseLong(nextTaskArray[1]);
					long time = new Date(nextTime).getTime()
							- new Date(taskId).getTime();
					return DateUtil.getDate(time);
				}
			}
		}
		return map;
	}

	@RequestMapping("/getManouvreName")
	@ResponseBody
	public Map<String, String> getManouvreName() {
		Map<String, String> map = new HashMap<String, String>();
		long currentTaskNum = Global.currentTaskNum;
		if (currentTaskNum == 0) {
			return null;
		}
		Ehcache cache = cacheManager.getEhcache("content");
		Task task = (Task) cache.get("task_" + currentTaskNum).getObjectValue();
		cache.flush();
		System.out.println("名字" + task.getName());
		map.put("name",task.getName());
		return map;
	}

}
