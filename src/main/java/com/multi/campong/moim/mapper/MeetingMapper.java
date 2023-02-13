package com.multi.campong.moim.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.multi.campong.moim.vo.MeetingMember;
import com.multi.campong.moim.vo.Moim;

@Mapper
public interface MeetingMapper {/*
								 * //가입하기 public int insertMoim(MeetingMember vo);
								 */
	//가입된 모임불러오기
	public List<Integer> getMeetingByNo(int mNo);
	//아이디로 가입된 모임 불러오기
	public void insertMoim(MeetingMember mt);
	public List<Moim> getMeetingByMeetNo(int meetNo);
	public MeetingMember moimRegisterCheck(@Param("mNo") int mNo,@Param("meetNo") int meetNo);
			
}
