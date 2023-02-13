package com.multi.campong.camping.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multi.campong.camping.mapper.CampingMapper;
import com.multi.campong.camping.vo.Camping;

@Service
public class CampingService {

	@Autowired
	CampingMapper mapper;
	
	public List<Camping> selectCamping(String donm) {
		List<Camping> camps = mapper.selectByDONM(donm);
		return camps;
	}
	public List<Camping> selectCamping2(String idCheck) {
		List<Camping> camps = mapper.selectByDONM2(idCheck);
		return camps;
	}
}
