package com.hwf.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Component;

import com.hwf.config.SqlSessionFactoryService;
import com.hwf.model.CartDTO;
import com.hwf.model.NutrientsDTO;

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

			sqlSession.commit();
			return result;
		} catch (Exception e) {

			return 0;
		}
	}

	public List<CartDTO> selectcartall(String id) {

		try {
			sqlSession = sqlSessionFactory.openSession();

			return sqlSession.selectList("cartdao.selectbyid", id);

		} catch (Exception e) {
			return null;
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}

	}

	public List<CartDTO> selectPrice(int id) {
		try {
			sqlSession = sqlSessionFactory.openSession();

			return sqlSession.selectList("cartdao.selectPrice", id);

		} catch (Exception e) {
			return null;
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
	}

	public int deleteData(int id) {
		try {
			sqlSession = sqlSessionFactory.openSession();

			int result = sqlSession.delete("cartdao.deleteid", id);

			sqlSession.commit();
			return result;
		} catch (Exception e) {

			return 0;
		}

	}

}
