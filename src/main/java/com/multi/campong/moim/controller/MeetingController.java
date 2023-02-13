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
	public String insertMeeting(MeetingMember mt,@RequestParam(value="mNo") int mNo,@RequestParam(value="meetNo") int meetNo,Model model) {
		System.out.println(mt);
		MeetingMember m = mapper.moimRegisterCheck(mNo, meetNo);
		if(m== null) {
		mapper.insertMoim(mt);
		model.addAttribute("message","가입이완료 되었습니다.");
		}else {
			model.addAttribute("message","이미 가입된 모임입니다.");
		}
		return "redirect:/moim";
	}
	
	/*
	 * @GetMapping("/moimRegisterCheck") public @ResponseBody int
	 * moimRegisterCheck(@RequestParam(value = "mNo") String mNo,@RequestParam(value
	 * = "meetNo") String meetNo) { System.out.println(mNo);
	 * System.out.println(meetNo); MeetingMember m =
	 * mapper.moimRegisterCheck(mNo,meetNo); if(m == null ) { return 0; }else {
	 * return 1; } }
	 */
	
}
