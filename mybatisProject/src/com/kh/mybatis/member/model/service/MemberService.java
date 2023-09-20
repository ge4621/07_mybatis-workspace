package com.kh.mybatis.member.model.service;

import com.kh.mybatis.member.model.vo.Member;

public interface MemberService {
	//인터페이스 : 상수필드(public static final) + 추상메소드(public abstract)
	
	/*public abstract*/ int insertMember(Member m);  //회원가입
	
	Member loginMember(Member m); //로그인
	
	int updateMember(Member m); //회원 정보 변경
	
	int deleteMember(String userId);  //회원 탈퇴
	
	
}
