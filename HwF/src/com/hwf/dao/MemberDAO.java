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
		sqlSessionFactory = SqlSessionFactoryService.getSqlSessionFactory();
	}

	public int insertUser(Map<String, String> map) {
		return sqlSession.insert("memberdao.insertUser", map);
	}

	public Map<String, Object> selectUser(String userid) {
		return sqlSession.selectOne("memberdao.selectUser", userid);
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
			System.out.println(dto.getMemberpwd() + " " + dto.getMemberid());
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
}
