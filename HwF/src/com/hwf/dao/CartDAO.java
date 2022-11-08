package com.hwf.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Component;

import com.hwf.config.SqlSessionFactoryService;
import com.hwf.model.CartDTO;

@Component
public class CartDAO {

	private SqlSessionFactory sqlSessionFactory;
	private SqlSession sqlSession = null;

	public CartDAO() {
		sqlSessionFactory = SqlSessionFactoryService.getSqlSessionFactory();
	}

	public int insertData(CartDTO dto) {

		try {
			sqlSession = sqlSessionFactory.openSession();
			
			int result = sqlSession.insert("cartdao.insertnutr", dto);
			
			System.out.println("1");
			
			sqlSession.commit();
			return result;
		} catch (Exception e) {

			return 0;
		}
	}

}
