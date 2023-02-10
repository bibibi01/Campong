package com.multi.campong;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.multi.campong.camping.service.CampingService;
import com.multi.campong.camping.vo.Camping;

import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class CampingController {
	
	@Autowired
	private CampingService service;
	
	@GetMapping("/CampingList.do")
	public @ResponseBody List<Camping> campingDo() {
		List<Camping> list = service.selectCamping("서울");
		System.out.println(list);
		return list;
	}
	
	
	  @GetMapping("/CampingList.do2") 
	  public @ResponseBody List<Camping> campingDo2(@RequestParam(value="idCheck")String idCheck){ 
		  log.info("리스트 요청, param : " + idCheck);
		  System.out.println(idCheck);
		  List<Camping> list2  = service.selectCamping2(idCheck);
		  System.out.println(list2);
		  return list2; }
	 
}
