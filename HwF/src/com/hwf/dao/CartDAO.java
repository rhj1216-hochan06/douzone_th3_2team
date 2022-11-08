package com.hwf.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hwf.config.SqlSessionFactoryService;
import com.hwf.model.NutrientsDTO;

@Component
public class CartDAO {
	
	@Autowired
	private SqlSessionFactory sqlSessionFactory;
	private SqlSession sqlSession = null;

	public List<NutrientsDTO> selectusename(String s) {
		try {
			sqlSession = sqlSessionFactory.openSession();
			return sqlSession.selectList("nutrdao.selectusename", s);

		} catch (Exception e) {
			return null;
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
	}
	
}
