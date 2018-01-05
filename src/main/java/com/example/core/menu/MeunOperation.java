package com.example.core.menu;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 固定操作类
 * 
 * @author liuxun
 *
 */
public class MeunOperation {
	public static Menu getMenu() {
		ViewButton btn1 = new ViewButton();
		btn1.setName("事故情景");
		btn1.setUrl("http://www.qq.com");

		ViewButton btn21 = new ViewButton();
		btn21.setName("专家点评");
		btn21.setUrl("http://wputtiil.natapp1.cc/score/manoeuvre.html?professor=true");

		ViewButton btn22 = new ViewButton();
		btn22.setName("人为自评");
		btn22.setUrl("http://wputtiil.natapp1.cc/score/manoeuvre.html?professor=false");
		
		ViewButton btn3 = new ViewButton();
		btn3.setName("关于我们");
		btn3.setUrl("http://www.qq.com");


		// 一级菜单(有二级菜单)
		ComplexMenu mainBtn2 = new ComplexMenu();
		mainBtn2.setName("演练评估");
		mainBtn2.setSub_button(new BasicButton[] { btn21, btn22 });

		Menu menu = new Menu();
		menu.setButton(new BasicButton[] { btn1, mainBtn2,btn3 });
		return menu;
	}
	
	public static void main(String[] args) throws JsonProcessingException {
		 ObjectMapper mapper = new ObjectMapper();  
		 String valueAsString = mapper.writeValueAsString(MeunOperation.getMenu());
		 System.out.println(valueAsString);
	}
}
