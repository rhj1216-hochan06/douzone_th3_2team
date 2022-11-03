package com.hwf.dao;

import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

import com.hwf.model.MemberDTO;

@Repository
public class MemberDAOImpl implements MemberDAO {  


	@Inject
	SqlSession sqlSession;
	SqlSessionFactory sqlSessionFactory;
	
	@Override
	public int insertUser(Map<String, String> map) {
		return sqlSession.insert("memberdao.insertUser", map);
	}

	@Override
	public Map<String, Object> selectUser(String userid) {
		return sqlSession.selectOne("memberdao.selectUser", userid);
	}
	
	@Override
	public boolean checkMember(MemberDTO dto) {
		
		if (dto.getMemberpwd() == sqlSession.selectOne("memberdao.selectpwd", dto.getMemberid()))
			return true;
		else
			return false;
	}
}
