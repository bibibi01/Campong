package com.multi.campong.moim.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.multi.campong.moim.model.mapper.MeetingMapper;
import com.multi.campong.moim.model.mapper.MoimMapper;
import com.multi.campong.moim.model.vo.MeetingMember;
import com.multi.campong.moim.model.vo.Moim;


@Controller
public class MoimController {

	@Autowired
	MoimMapper mapper;
	
	@Autowired
	MeetingMapper meetMapper;
	
	@GetMapping("/moim")
	public String moimMain(Model model,@RequestParam("mNo") int mNo) {
		List<Moim> list = meetMapper.meetingCount();
		System.out.println(mNo);
		model.addAttribute("list", list);
		return "moim/moim";
	}

	@GetMapping("/moim.create")
	public String moimCreate() {

		return "moim/moim-create";
	}

	@GetMapping("/moim.detail")
	public String moimDetail(@RequestParam("meetNo") int meetNo,@RequestParam("mNo") int mNo,Model model) {
		Moim m = mapper.MoimContent(meetNo);
		Moim mvo = meetMapper.meetingCountByMeetNo(meetNo);
		System.out.println(m);
		System.out.println(mvo);
		model.addAttribute("vo", m);
		model.addAttribute("mvo", mvo);
		System.out.println("meetNo"+meetNo);
		System.out.println("mNo"+mNo);
		int result = meetMapper.moimCheck(meetNo, mNo);
		System.out.println("result:"+result);
		if(result==1) {
			model.addAttribute("viewPhone", 1);
		}else {
			model.addAttribute("viewPhone", 0);
		}
		return "/moim/moim-detail";
	}


	@PostMapping("/moim.insert")
	public String moimInsert(Moim m,@RequestParam("mNo") int mNo) {
		System.out.println(mNo);
		mapper.moimInsert(m);
		MeetingMember mvo = new MeetingMember();
		mvo.setMeetNo(m.getMeetNo());
		mvo.setMNo(mNo);
		meetMapper.insertMoim(mvo);
		return "redirect:/moim?mNo="+mNo;
	}

}