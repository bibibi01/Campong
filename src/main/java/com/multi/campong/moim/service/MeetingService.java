package com.multi.campong.moim.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multi.campong.member.mapper.MemberMapper;
import com.multi.campong.moim.mapper.MeetingMapper;
import com.multi.campong.moim.mapper.MoimMapper;
import com.multi.campong.moim.vo.MeetingMember;
import com.multi.campong.moim.vo.Moim;

@Service
public class MeetingService {
	
	@Autowired
	MemberMapper memberMapper;
	
	@Autowired
	MoimMapper moimMapper;
	
	@Autowired
	MeetingMapper meetingMapper;
	
	public List<MoimMapper> MoimListByUserNo(int mNo){
		// 참가한모임 목록 조회
		List<MeetingMember> meetingList = meetingMapper.getMeetingByNo(mNo);
		//참가한 모임의 정보 조회
		List<Moim> moim = new ArrayList<Moim>();
		// 찜한목록  확인
		if(Objects.isNull(meetingList)) {
		return null;	
		}
		meetingList.forEach( i-> {
			Moim moimVo = moimMapper.MoimContent(i.getUserNo())
		}
		);
	}

}
