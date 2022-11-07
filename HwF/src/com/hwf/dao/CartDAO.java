package com.hwf.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Component;

import com.hwf.config.SqlSessionFactoryService;
import com.hwf.model.NutrientsDTO;

@Component
public class CartDAO {

	private SqlSessionFactory sqlSessionFactory;
	private SqlSession sqlSession = null;

	public CartDAO() {
		sqlSessionFactory = SqlSessionFactoryService.getSqlSessionFactory();
	}

	public List<NutrientsDTO> selectAll() {
		try {
			sqlSession = sqlSessionFactory.openSession();
			return sqlSession.selectList("nutrdao.selectAll");

		} catch (Exception e) {
			return null;
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
	}
	
}
