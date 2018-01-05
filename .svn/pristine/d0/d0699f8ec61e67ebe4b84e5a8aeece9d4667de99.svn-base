package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.core.config.Global;


/**
 *  消息管理的控制器
 * @author liuxun
 *
 */
@Controller
@RequestMapping("/message")
public class MsgManageController {
	
	@RequestMapping(value = "/manage", method = { RequestMethod.GET })
	public String toMsgManagePage(Model model) {
		if (Global.currentTaskNum == 0) {
			return "404";
		}
		
		model.addAttribute("taskId", Global.currentTaskNum);
		return "msgManage";
	}
}
