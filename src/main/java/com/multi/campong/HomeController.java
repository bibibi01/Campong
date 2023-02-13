package com.multi.campong;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.multi.campong.camping.service.CampingService;
import com.multi.campong.camping.vo.Camping;

import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {
	
	@Autowired
	private CampingService service;
	
//	@Autowired
//	private BoardService service;
	
//	@Autowired
//	private MemberService memberService;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	@GetMapping(value = "/")
	public String home(Locale locale, Model model, HttpSession session,String hi) {
		logger.info("Welcome home! The client locale is {}.", locale);
//		Member loginMember = memberService.login("admin", "1212");
//		session.setAttribute("loginMember", loginMember);
//		test();
		return "home";
	}
	
//	public void test() {
//		Map<String, String> map = new HashMap<>();
//		PageInfo info = new PageInfo(1, 10, service.getBoardCount(map), 10);
//		logger.info("board List : " + service.getBoardList(info, map));
//	}
	
}
