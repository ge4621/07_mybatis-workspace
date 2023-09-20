package com.kh.mybatis.common.template;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Template {

	/*
	 * 기존 JDBC
	 * 
	 * public static Connection getConnection(){
	 * 		//driver.properties 파일 읽어들여서
	 * 		//해당 DB와 접속된 Connection 객체 생성해서 반환
	 * }	
	 * 
	 * public static void close(JDBC용 객체){
	 * 		//전달 받은 JDBC용 객체를 반납시키는 구문
	 * }
	 * 
	 * public static void commit|rollback(Conn){
	 * 		//트랜젝션 처리
	 * }
	 * 
	 */
	
	//마이바티스버전 JDBC
	public static SqlSession getSqlSession() {
		
		//mybatis-config.xml 파일을 읽어들여서
		//해당 DB와 접속된 SqlSession 객체 생성해서 반환
		SqlSession sqlSession = null;
		
		//SqlSession 생성하기 위해서 => SqlSessionFactory 필요
		//SqlSessionFactory 생성하기 위해서 => SqlSessionFactoryBuilder 필요
		
		String resource = "/mybatis-config.xml";  //resources를 소스 폴더로 만드는 이유 => 일반 파일로 생성시 경로가 잡히지 않을 수 있다.
		try {
			InputStream stream = Resources.getResourceAsStream(resource);
			sqlSession = new SqlSessionFactoryBuilder().build(stream).openSession(false);
							//openSession() : 기본값은 false
							//openSession(boolean flag) : 자동커밋 여부 (true면 하겠다. false면 안하겠다. => 개발자가 autoCommit 여부를 직접 설정한다.)
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sqlSession;
		
	}
	
	
	
}
