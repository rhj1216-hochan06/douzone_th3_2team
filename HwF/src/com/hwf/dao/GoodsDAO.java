package com.hwf.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Component;

import com.hwf.config.SqlSessionFactoryService;
import com.hwf.model.GoodsDTO;
//import com.hwf.model.HealthGoodsDTO;

@Component
public class GoodsDAO {

	private SqlSession session = null; // DML쿼리문 다 갖는 SqlSession 인터페이스

	private SqlSessionFactory sqlSessionFactory;
	private SqlSession sqlSession = null; // DML 처리함수 가짐

	public GoodsDAO() {
		sqlSessionFactory = SqlSessionFactoryService.getSqlSessionFactory(); // openSession() 가능
	}

	// DML 관련 - 메소드명을 admin-mapper.xml와 맞춰주기

	
	
	/*************** 상품 전체 조회 ***************/

	// AdminHealthGoodsSelect (헬스용품 전체 조회)
	public List<GoodsDTO> AdminHealthGoodsSelect() { // null처리도 해주기 위해서 위의 주석문장을 try~catch로 감싸줌
		try {
			sqlSession = sqlSessionFactory.openSession(); // 어플리케이션과 DB 통로 역할

			return sqlSession.selectList("adminMapper.AdminHealthGoodsSelect"); // admin-mapper.xml에서 namespace.id와 일치시켜주어야 함

		} catch (Exception e) {
			return null;

		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
	}

	// AdminHealthFoodSelect (헬스식품 전체 조회)
	public List<GoodsDTO> AdminHealthFoodSelect() { // null처리도 해주기 위해서 위의 주석문장을 try~catch로 감싸줌
		try {
			sqlSession = sqlSessionFactory.openSession(); // 어플리케이션과 DB 통로 역할

			return sqlSession.selectList("adminMapper.AdminHealthFoodSelect"); // admin-mapper.xml에서 namespace.id와 일치시켜주어야 함

		} catch (Exception e) {
			return null;

		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
	}

	// NutrientsSelect (영양제 전체 조회)
	public List<GoodsDTO> AdminNutrientsSelect() { // null처리도 해주기 위해서 위의 주석문장을 try~catch로 감싸줌
		try {
			sqlSession = sqlSessionFactory.openSession(); // 어플리케이션과 DB 통로 역할

			return sqlSession.selectList("adminMapper.AdminNutrientsSelect"); // admin-mapper.xml에서 namespace.id와 일치시켜주어야 함

		} catch (Exception e) {
			return null;

		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
	}
	
	

	/*************** 상품 등록 ***************/
	
	// AdminHealthGoodsInsert (헬스용품 등록)
	public int AdminHealthGoodsInsert(GoodsDTO dto) {
		try {
			sqlSession = sqlSessionFactory.openSession(); // 어플리케이션과 DB 통로 역할

			int result = sqlSession.insert("adminMapper.AdminHealthGoodsInsert", dto); // admin-mapper.xml에서 namespace.id와 일치시켜주어야 함
			sqlSession.commit();
			return result;

		} catch (Exception e) {
			e.printStackTrace();
			sqlSession.rollback(); // 단일 쿼리 실행시 의미 없음
			return 0;

		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
	}
	
	// AdminHealthFoodInsert (헬스식품 등록)
	public int AdminHealthFoodInsert(GoodsDTO dto) {
		try {
			sqlSession = sqlSessionFactory.openSession(); // 어플리케이션과 DB 통로 역할

			int result = sqlSession.insert("adminMapper.AdminHealthFoodInsert", dto); // admin-mapper.xml에서 namespace.id와 일치시켜주어야 함
			sqlSession.commit();
			return result;

		} catch (Exception e) {
			e.printStackTrace();
			sqlSession.rollback(); // 단일 쿼리 실행시 의미 없음
			return 0;

		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
	}

}
