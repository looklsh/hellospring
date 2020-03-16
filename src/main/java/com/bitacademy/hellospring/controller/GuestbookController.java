package com.bitacademy.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

//타입 단독 매핑
@Controller
@RequestMapping("/guestbook/*")
public class GuestbookController {
	@RequestMapping
	@ResponseBody
	public String list() { // guestbook/list
		return "<h1>Guestbook:list</h1>";
	}
	
	@RequestMapping
	@ResponseBody
	public String add() { // guestbook/add
		return "<h1>Guestbook:add</h1>";
	}
}
