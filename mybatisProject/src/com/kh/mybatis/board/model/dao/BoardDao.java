package com.kh.mybatis.board.model.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.kh.mybatis.board.model.vo.Board;
import com.kh.mybatis.board.model.vo.Reply;
import com.kh.mybatis.common.model.vo.PageInfo;

public class BoardDao {

	public int selectListCount(SqlSession sqlSession) {
		return sqlSession.selectOne("boardMapper.selectListCount");
	} //페이징
	
	public ArrayList<Board> selectList(SqlSession sqlSession,PageInfo pi){
		
		//sqlSession.selectList("boardMapper.selectList");
		
		//마이바티스에서는 페이징 처리를 위해 RowBounds 라는 클래스 제공
		
		//*offset : 몇개의 게시글 건너뛰고 조회할 건지에 대한 값
		
		/*
		 * ex) boardLimit : 5
		 * 							offset(건너뛸 숫자)			limit(조회할 숫자)
		 * currentPage : 1	 1~5	 	   0					 5
		 * currentPate : 2	 6~10		   5					 5
		 * currentPate : 3 	 11~15		   10					 5			
		 * ...
		 */
		
		//int offset = (현재 페이지 -1 ) * 몇 개씩 보여줄껀지
		int offset = (pi.getCurrentPage()-1)*pi.getBoardLimit();
		int limit = pi.getBoardLimit();
		
		RowBounds rowBounds = new RowBounds(offset, limit);
		
		//sqlSession.selectList("boardMapper.selectList", 쿼리가 불완전 채워줄 무언가, rowBounds) 채워줄게 없으며 null로 한다.
		return (ArrayList)sqlSession.selectList("boardMapper.selectList", null , rowBounds);
		
	}//게시글
	
	public int increaseCount(SqlSession sqlSession,int boardNo) {
		
		return sqlSession.update("boardMapper.increaseCount", boardNo); //여기 변수 이름과 쿼리문의 변수 이름이 같아야 한다. => boardNo
		
	}//조회수 증가
	
	public Board selectBoard(SqlSession sqlSession,int boardNo) {
		return sqlSession.selectOne("boardMapper.selectBoard", boardNo);
	}//상세조회
	
	public ArrayList<Reply> selectReplyList(SqlSession sqlSession,int boardNo){
		return (ArrayList)sqlSession.selectList("boardMapper.selectReplyList", boardNo);
	}//댓글 조회
	
	public int selectSearchCount(SqlSession sqlSession,HashMap<String, String>map) {
		return sqlSession.selectOne("boardMapper.selectSearchCount", map);

	}//게시글 검색
	
	public ArrayList<Board> selectSearchList(SqlSession sqlSession,HashMap<String, String> map ,PageInfo pi){
		
		//int offset = (현재 페이지 -1) * 몇개씩 보여줄 껀지
		int offset = (pi.getCurrentPage() -1 ) * pi.getBoardLimit();
		int limit = pi.getBoardLimit();
		
		RowBounds rowBounds = new RowBounds(offset, limit);
		
		return (ArrayList)sqlSession.selectList("boardMapper.selectSearchList", map , rowBounds);
				
		
	}//검색 게식글 리스트
	
	public int deleteList(SqlSession sqlSession,int boardNo) {
		
		return sqlSession.update("boardMapper.deleteList", boardNo);
		
		
	}//게시글 삭제
 	
}
