package com.multi.campong.moim.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.multi.campong.moim.vo.Moim;


  @Mapper
  public interface MoimMapper{
	  public void moimInsert(Moim m); 
	  }
 
