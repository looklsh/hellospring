package com.bitacademy.hellospring.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bitacademy.hellospring.vo.RequestVo;

@Controller
@RequestMapping("/welcome")
public class WelcomeController {
	//가장 기본적인 방식은 modelandview이다
	@RequestMapping("/")
	public ModelAndView home(@RequestParam(value="name", required=false, defaultValue="Anonymous")String name) {
		ModelAndView mav= new ModelAndView();
		mav.addObject("message", "Hello," + name);
		mav.setViewName("/WEB-INF/views/hello.jsp");
		
		return mav;
	}
	
	// /welcome/pathparam/이름/no
	//예)welcome/pathparam/lee/10
	//PathVariable
	@RequestMapping("/pathparam/{name}/{no}")
	public ModelAndView PathParam(@PathVariable("name")String name, @PathVariable("no")Long no) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("message", "Name:"+name+", NO:" + no);
		mav.setViewName("/WEB-INF/views/hello.jsp");
		return mav;
	}
	//요청 파라미터가 많거나 고정된 유형의 데이터일 경우
	//Value Object(VO, DTO) 객체를 활용하는 것이 바람직
	@RequestMapping("using-vo")
	public ModelAndView usingVo(@ModelAttribute RequestVo reqVo) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("message", "Name:" + reqVo.getName() + ", NO:" + reqVo.getNo());
		mav.setViewName("/WEB-INF/views/hello.jsp");
		return mav;
	}
	
	//메서드의 인자값으러 필요한 여러 객체들을 
	//front controller로부터 전달받아 사용할 수 있다
	//HttpSession, HttpRequest, HttpResponse등 
	@RequestMapping("/model")
	public String requireModel(ModelMap map, HttpSession session) {
		map.addAttribute("message", "모델 맵을 이용해 데이터를 전달했습니다.");
		return "/WEB-INF/views/hello.jsp";
	}
}
