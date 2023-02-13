package com.multi.campong.moim.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.multi.campong.moim.mapper.MeetingMapper;
import com.multi.campong.moim.service.MeetingService;
import com.multi.campong.moim.vo.MeetingMember;

@Controller
public class MeetingController {
	@Autowired
	MeetingService service;
	
	@Autowired
	MeetingMapper mapper;
	

	@GetMapping("/moim.my")
	public String moimMy(@RequestParam("mNo") int mNo,Model model) {
		System.out.println(mNo);
		List<Integer> myMoim = service.MoimListByUserNo(mNo);
		System.out.println(myMoim);
		model.addAttribute("myMoim", myMoim);
		return "moim/moim-my";
	}
	@PostMapping("/insertMeeting")
	public String insertMeeting(MeetingMember mt) {
		System.out.println(mt);
		mapper.insertMoim(mt);
		return "redirect:/moim";
	}
	
	@GetMapping("/moimRegisterCheck.do")
	public @ResponseBody int moimRegisterCheck(@RequestParam("mNo") int mNo,@RequestParam("meetNo") int meetNo) {
		
		return 1;
	}
	
}
