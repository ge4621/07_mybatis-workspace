package com.kh.mybatis.member.model.dao;

import org.apache.ibatis.session.SqlSession;

import com.kh.mybatis.member.model.vo.Member;

public class MemberDao {
	
	public int insertMember(SqlSession sqlSession,Member m) {
		
		/*
	       * int result = 0;
	       * PreparedStatement pstmt = null;
	       * String sql = prop.getProperty("insertMember");
	       * 
	       * try{
	       *       pstmt = conn.prepareStatement(sql);
	       *        pstmt.setString(1, m.getUserId());
	       *        pstmt.setString(2, m.getUserPwd());
	       *       .....
	       * 
	       *       result = pstmt.executeUpdate();
	       * 
	       * } catch(xxx){
	       * 
	       * } finally{
	       *     close(pstmt);
	       * }
	       * 
	       */
		
		/*
		 * sqlSession에서 제공하는 메소드를 통해서 sql문 찾아서 실행하고 바로 결과 받음
		 * 
		 * 결과 = sqlSession.sql문 종류에 맞는 메소드("매퍼의 별칭.해당 sql문의 고유한 id",[그 sql문을 완성시킬 객체])
		 */
		
		int result = sqlSession.insert("memberMapper.insertMember", m);  //"member-mapper에서 namespace의 id값.쿼리문의 id값"
		return result;
		
		//return sqlSession.insert("memberMapper.insertMember", m); //위 두줄을 한줄로 표현할 경우
		
		
	}
	
	public Member loginMember(SqlSession sqlSession,Member m) {
		
		//selectOne 메소드 : 조회결과가 만일 없다면 null 반환
		Member loginMember = sqlSession.selectOne("memberMapper.loginMember", m);
		
		return loginMember;
		
	}

}
