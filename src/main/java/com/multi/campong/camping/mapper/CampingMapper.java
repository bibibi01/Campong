package com.multi.campong.camping.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.multi.campong.camping.vo.Camping;

@Mapper
public interface CampingMapper {
	List<Camping> selectByDONM(String donm);
	List<Camping> selectByDONM2(String idCheck);
}
