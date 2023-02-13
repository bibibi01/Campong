package com.multi.campong.moim.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.multi.campong.moim.vo.Moim;


  @Mapper
  public interface MoimMapper{
	  public void moimInsert(Moim m);

	  public List<Moim> getMoim(); 
	  public Moim MoimContent(int meetNo);
	  }
 
