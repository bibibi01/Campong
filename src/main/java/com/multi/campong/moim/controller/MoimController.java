package com.multi.campong.moim.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.multi.campong.moim.mapper.MoimMapper;
import com.multi.campong.moim.service.MoimService;
import com.multi.campong.moim.vo.Moim;

@Controller
public class MoimController {
	
	
	@Autowired
	MoimMapper mapper;
	
	@GetMapping("/moim")
	public String moimMain() {
		
		return "moim/moim";
	}
	@GetMapping("/moim.create")
	public String moimCreate() {
		
		return "moim/moim-create";
	}
	@GetMapping("/moim.detail")
	public String moimDetail() {
		
		return "moim/moim-detail";
	}
	@GetMapping("/moim.my")
	public String moimMy() {
		return "moim/moim-my";
	}

	
	  @PostMapping("/moim.insert")
	  public String moimInsert(Moim m) {
	  mapper.moimInsert(m); 
	  return "redirect:/moim"; 
	  }
	 
}
