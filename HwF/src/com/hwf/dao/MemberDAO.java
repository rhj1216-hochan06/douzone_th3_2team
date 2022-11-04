package com.hwf.dao;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Component;

import com.hwf.config.SqlSessionFactoryService;
import com.hwf.model.MemberDTO;

@Component
public class MemberDAO {
	private SqlSessionFactory sqlSessionFactory;
	private SqlSession sqlSession = null;
	

	public MemberDAO() {
		System.out.println("MemberDAO 생성자 함수 실행");
		sqlSessionFactory = SqlSessionFactoryService.getSqlSessionFactory();
	}
	
	public boolean checkMemberb(MemberDTO dto) {
		System.out.println(dto.getMemberpwd() + " " + dto.getMemberid());
		System.out.println((String) sqlSession.selectOne("memberdao.selectpwd", dto.getMemberid()));

		if (dto.getMemberpwd() == sqlSession.selectOne("memberdao.selectpwd", dto.getMemberid()))
			return true;
		else
			return false;
	}
	public MemberDTO checkMember(MemberDTO dto) {
		try {
			System.out.println("체크 실행");
			System.out.println(dto.toString());
			
			sqlSession = sqlSessionFactory.openSession();
			
			return sqlSession.selectOne("memberdao.selectpwd", dto.getMemberid());

		} catch (Exception e) {

			return null;
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
	}
	// insert
	public int insert(MemberDTO dto) {
		
		System.out.println("회원가입 실행");
		System.out.println(dto.toString());
		
		
		try {
			
			System.out.println("1");
			sqlSession = sqlSessionFactory.openSession();
			System.out.println("2");
			int result = sqlSession.insert("memberdao.insert", dto);
			System.out.println("3");
			sqlSession.commit();
			System.out.println("4");
			return result;

		} catch (Exception e) {
			return 0;
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		} // try end
	} // write end

}
