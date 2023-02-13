package com.multi.campong.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.multi.campong.member.mapper.MemberMapper;
import com.multi.campong.member.vo.Member;

@Service
public class MemberService {
	
	@Autowired
	private MemberMapper mapper;
	

	private BCryptPasswordEncoder pwEncoder = new BCryptPasswordEncoder();
	
	// @Transactional : DB 트랜잭션 관리를 위한 AOP 어노테이션. 만일 오류가 발생하면 롤백. 아니면 커밋
		// (rollbackFor = Exception.class) : 사용하지 않은 경우 트랜잭션 코드가 정상적으로 작동하지 않을수 있다.
		@Transactional(rollbackFor = Exception.class)
		public int save(Member member) {
			int result = 0;
			if(member.getMNo() == 0) { // 회원가입
				String encodePW = pwEncoder.encode(member.getPassword());
				member.setPassword(encodePW);
				result = mapper.insertMember(member);
			}else { // 회원 수정
				result = mapper.updateMember(member);
			}
			return result;
		}

}
