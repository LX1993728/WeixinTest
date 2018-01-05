package com.example.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.UUID;

import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Ehcache;
import net.sf.ehcache.Element;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.core.utils.DateUtil;

@SuppressWarnings("all")
@Controller
@RequestMapping("/sms")
public class TestSmsController {
	
	
private static String APPKEY = "0848a30e797f331f75337af0bbc94b05";
	
	//模板发送接口的http地址
    private static String URI_TPL_SEND_SMS =
        "https://sms.yunpian.com/v2/sms/tpl_single_send.json";
    
    //接收信息接口的http地址
    private static String URI_REPLY_SMS =
        "https://sms.yunpian.com/v2/sms/pull_reply.json";
    
    //获得模板的http地址
    private static String URI_GETMODEL_SMS =
    		"https://sms.yunpian.com/v2/tpl/get.json";
    //获得模板的http地址
    private static String URI_STATUS_SMS =
    		"https://sms.yunpian.com/v2/sms/pull_status.json";
	
	@RequestMapping("/page")
	public String page(){
		return "/sendMessage.html";
	}
	
	
    
    //编码格式。发送编码格式统一用UTF-8
    private static String ENCODING = "UTF-8";
    
    
    private static CacheManager cacheManager = CacheManager.newInstance();
	
    /**
     * 
     * @param mobile 手机号
     * @param content 发送内容
     * @return
     */
	@RequestMapping(value = "/testSend")
	@ResponseBody
    public String send(String mobile,String content,String toCompany,String toPerson) {
		Map<String,String> params = new HashMap<String,String>();
		content = "负责防风防汛设施、重点工程除险加固计划和建设的协调安排、抢险救灾工程项目及特种装备立项。";
		String model = getModel();
		JSONArray array= JSONArray.parseArray(model);
		for (int i = 0; i < array.size(); i++) {
			JSONObject json = array.getJSONObject(i);
            String tplContent = json.getString("tpl_content"); 
			if(content.equals(tplContent.substring(5))){
				params.put("tpl_id", String.valueOf(json.getLong("tpl_id")));
				break;
			}
		}
		params.put("apikey", APPKEY);
		params.put("tpl_value",null);
		params.put("mobile", "15011283760");
		return post(URI_TPL_SEND_SMS, params);
	}
	
	/**
     * 发送短信
     * @param mobile 手机号
     * @param content 发送内容
     * @return
     */
	@RequestMapping(value = "/send")
	@ResponseBody
    public Map<String,String> send(String sendParams) {
		Map<String,String> params = new HashMap<String,String>();
		Map<String,String> result = new HashMap<String,String>();
		Map<String,Object> cacheMap = new HashMap<String,Object>();
		Map<String,Object> cacheHistoryMap = new HashMap<String,Object>();
		Set<String> set = new TreeSet<String>();
		String resultMsg = null;
		JSONArray sendParamsArray= JSONArray.parseArray(sendParams);
		JSONObject message = null;
		JSONObject historyMessage = new JSONObject();
		String uid = UUID.randomUUID().toString();
		for (int i = 0; i < sendParamsArray.size(); i++) {
			JSONObject jsonObject = sendParamsArray.getJSONObject(i);
			params.put("apikey", APPKEY);
			params.put("tpl_value",null);
			params.put("mobile", jsonObject.getString("mobile"));
			String model = getModel();
			JSONArray array= JSONArray.parseArray(model);
			for (int j = 0; j < array.size(); j++) {
				JSONObject json = array.getJSONObject(j);
	            String tplContent = json.getString("tpl_content"); 
				if(jsonObject.getString("content").equals(tplContent.substring(5))){
					params.put("tpl_id", String.valueOf(json.getLong("tpl_id")));
					break;
				}
			}
			resultMsg = post(URI_TPL_SEND_SMS, params);
			message = JSONObject.parseObject(resultMsg);
			message.put("toCompany", jsonObject.getString("toCompany"));
			
			message.put("toPerson", jsonObject.getString("toPerson"));
			message.put("mobile", jsonObject.getString("mobile"));
			message.put("status", "已接收");
			message.put("date", DateUtil.fomatDate(new Date(),"yyyy-MM-dd HH:mm:ss"));
			message.put("content", jsonObject.getString("content"));
			
			message.put("uid", uid);
			cacheMap.put(jsonObject.getString("mobile"), message);
			
			set.add(jsonObject.getString("toCompany"));
			historyMessage.put("leftContent", jsonObject.getString("leftContent"));
		}
		String allCompany = set.toString().replace("[", "").replace("]", "");
		historyMessage.put("allCompany", allCompany);
		historyMessage.put("date", DateUtil.fomatDate(new Date(),"yyyy-MM-dd HH:mm:ss"));
		historyMessage.put("uid", uid);
		cacheHistoryMap.put(uid, historyMessage);
		
		Ehcache cache = cacheManager.getEhcache("content");
		//发送详情
		cache.put(new Element("sendMessageHistory_"+uid,cacheMap));
		//历史详情
		cache.put(new Element("HistoryMessage_"+uid,cacheHistoryMap));
		cache.flush();
		result.put("uid",uid);
		result.put("msg","发送成功");
		return result;
	}
	
	/**
	 * 查看短信回复状态
	 * @param uid 短信批次
	 * @return
	 */
	
	@RequestMapping(value = "/reply")
	@ResponseBody
	public Map<String,Object> getReply(String uid){
		Map<String,String> params = new HashMap <String,String>();
		Ehcache cache = cacheManager.getEhcache("content");
		Element element = cache.get("sendMessageHistory_"+uid); 
		cache.flush();
		if(null != element){
			Map<String,Object> cacheMap = (Map<String, Object>) element.getObjectValue();//获取到的缓存数据
			
			params.put("apikey", APPKEY);
			params.put("page_size", "30");
			String reply = post(URI_REPLY_SMS, params);
			//回复的数组
			JSONArray replyArray= JSONArray.parseArray(reply);
		
			for (int i = 0; i < replyArray.size(); i++) {
				JSONObject object = replyArray.getJSONObject(i);
				String mobile = object.getString("mobile");
				JSONObject obj = (JSONObject) cacheMap.get(mobile);
				obj.put("status","已确认");
			}
			cache.put(new Element("sendMessageHistory_"+uid,cacheMap));
			cache.flush();
			return cacheMap;
		}
		return null;
		
	}
	
	@RequestMapping(value = "/queryList")
	@ResponseBody
	public List<Map<String,JSONObject>> queryList(){
		Ehcache cache = cacheManager.getEhcache("content");
		List<String> keys = cache.getKeys();
		cache.flush();
		List<Map<String,JSONObject>> list = new ArrayList<Map<String,JSONObject>>();
		Set<String> tmpSet = new HashSet();
		for (String key : keys) {
			if(key.startsWith("HistoryMessage_")){
				Map<String,JSONObject> map = (Map<String, JSONObject>) cache.get(key).getObjectValue();
				list.add(map);
			}
		}
		Collections.sort(list, new Comparator<Map<String,JSONObject>>(){
	            @Override
	            public int compare(Map<String,JSONObject> o1,
	            		Map<String,JSONObject>  o2) {
	            	 JSONObject json1 = (JSONObject) o1.values().toArray()[0];
	            	 JSONObject json2 = (JSONObject) o2.values().toArray()[0];
	                 return json2.getString("date").compareTo(json1.getString("date"));
	            }
	        });
		
		return list;
	}
	
	/**
	 * 根据uid查询当前消息的具体内容(详细信息)
	 * @return
	 */
	
	@RequestMapping(value = "/queryListByUid")
	@ResponseBody
	public Map<String,Object> queryListByUid(String uid){
		Ehcache cache = cacheManager.getEhcache("content");
		Element element = cache.get("sendMessageHistory_"+uid); 
		cache.flush();
		if(null != element){
			Map<String,Object> cacheMap = (Map<String, Object>) element.getObjectValue();//获取到的缓存数据
			return cacheMap;
		}
		return null;
	}
	
	
	
	
	
	
	
	@RequestMapping(value = "/testReply")
	@ResponseBody
	public String testReply(){
		Map<String,String> params = new HashMap <String,String>();
		params.put("apikey", APPKEY);
		params.put("page_size", "30");
		return post(URI_REPLY_SMS, params);
	}
	/*
	 * 获得所有模板
	 */
	public static String getModel() {
		 Map<String,String> params = new HashMap <String,String>();
		 params.put("apikey", APPKEY);
		 return post(URI_GETMODEL_SMS, params);
	}
	
	/**
     * 
     * @param mobile 手机号
     * @param content 发送内容
     * @return
     */
	@RequestMapping(value = "/status")
	@ResponseBody
    public String status() {
		 Map<String,String> params = new HashMap <String,String>();
		 params.put("apikey", APPKEY);
		 return post(URI_STATUS_SMS, params);
		
	}
	
	
	 public static String post(String url, Map < String, String > paramsMap) {
	        CloseableHttpClient client = HttpClients.createDefault();
	        String responseText = "";
	        CloseableHttpResponse response = null;
	        try {
	            HttpPost method = new HttpPost(url);
	            if (paramsMap != null) {
	                List < NameValuePair > paramList = new ArrayList <
	                    NameValuePair > ();
	                for (Map.Entry < String, String > param: paramsMap.entrySet()) {
	                    NameValuePair pair = new BasicNameValuePair(param.getKey(),
	                        param.getValue());
	                    paramList.add(pair);
	                }
	                method.setEntity(new UrlEncodedFormEntity(paramList,
	                    ENCODING));
	            }
	            response = client.execute(method);
	            HttpEntity entity = response.getEntity();
	            if (entity != null) {
	                responseText = EntityUtils.toString(entity, ENCODING);
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            try {
	                response.close();
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	        }
	        return responseText;
	    }
	

}
