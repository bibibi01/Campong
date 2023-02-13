package com.multi.campong.moim.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.multi.campong.moim.mapper.MeetingMapper;
import com.multi.campong.moim.mapper.MoimMapper;
import com.multi.campong.moim.vo.MeetingMember;
import com.multi.campong.moim.vo.Moim;

@Controller
public class MoimController {

	@Autowired
	MoimMapper mapper;
	
	@Autowired
	MeetingMapper meetMapper;
	
	@GetMapping("/moim")
	public String moimMain(Model model) {
		List<Moim> list = mapper.getMoim();
		System.out.println(list);
		model.addAttribute("list", list);
		return "moim/moim";
	}

	@GetMapping("/moim.create")
	public String moimCreate() {

		return "moim/moim-create";
	}

	@GetMapping("/moim.detail")
	public String moimDetail(@RequestParam("meetNo") int meetNo,Model model) {
		Moim m = mapper.MoimContent(meetNo);
		model.addAttribute("vo", m);
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
		return "redirect:/moim";
	}

}
