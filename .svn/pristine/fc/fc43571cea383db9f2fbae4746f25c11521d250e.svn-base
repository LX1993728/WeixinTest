package com.example.core.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**  
* 创建时间：2017年12月19日 上午10:16:18  
* 项目名称：WeixinTest  
* @author wy
* @version 1.0   
* @since JDK 1.6.0_21  
* 文件名称：DataUtil.java  
* 类说明：  
*/ 
public class DateUtil {
	/** 日期转换为自定义格式输出 */
	public static String fomatDate(Date date, String format) {
		if (date == null) {
			return "";
		}
		if (format == null || "".equals(format)) {
			return "";
		}
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(format);
			return sdf.format(date);
		} catch (Exception e) {
			e.printStackTrace();
			return "";

		}
	}
	public static Map<String,Object> getDate(long time){
		Map<String,Object> map = new HashMap<String,Object>();
		long nd = 1000 * 24 * 60 * 60;// 一天的毫秒数  
        long nh = 1000 * 60 * 60;// 一小时的毫秒数  
        long nm = 1000 * 60;// 一分钟的毫秒数  
        long day = 0;  
        long hour = 0;  
        long min = 0;  
        day = time / nd;// 计算差多少天  
        hour = time % nd / nh + day * 24;// 计算差多少小时  
        min = time % nd % nh / nm + day * 24 * 60;// 计算差多少分钟  
//        System.out.println("时间相差：" + hour + "小时"  
//                + (min - day * 24 * 60) + "分钟"); 
        map.put("hour",hour);
        map.put("min", (min - day * 24 * 60));
        return map;
	}


}
