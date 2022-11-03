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

	// DML 관련 - 메소드명을 member-mapper.xml와 맞춰주기

	
	
	/*************** 상품 전체 조회 ***************/
	
//	// HealthGoodsSelect <- 기존에 되던거 (추후 주석)
//	public List<HealthGoodsDTO> HealthGoodsSelect() { // null처리도 해주기 위해서 위의 주석문장을 try~catch로 감싸줌
//		try {
//			sqlSession = sqlSessionFactory.openSession(); // 어플리케이션과 DB 통로 역할
//
//			return sqlSession.selectList("dao.HealthGoodsSelect"); // admin-mapper.xml에서 namespace.id와 일치시켜주어야 함
//
//		} catch (Exception e) {
//			return null;
//
//		} finally {
//			if (sqlSession != null) {
//				sqlSession.close();
//			}
//		}
//	}

	// HealthGoodsSelect (헬스용품 전체 조회)
	public List<GoodsDTO> HealthGoodsSelect() { // null처리도 해주기 위해서 위의 주석문장을 try~catch로 감싸줌
		try {
			sqlSession = sqlSessionFactory.openSession(); // 어플리케이션과 DB 통로 역할

			return sqlSession.selectList("adminMapper.HealthGoodsSelect"); // admin-mapper.xml에서 namespace.id와 일치시켜주어야 함

		} catch (Exception e) {
			return null;

		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
	}

	// HealthFoodSelect (헬스식품 전체 조회)
	public List<GoodsDTO> HealthFoodSelect() { // null처리도 해주기 위해서 위의 주석문장을 try~catch로 감싸줌
		try {
			sqlSession = sqlSessionFactory.openSession(); // 어플리케이션과 DB 통로 역할

			return sqlSession.selectList("adminMapper.HealthFoodSelect"); // admin-mapper.xml에서 namespace.id와 일치시켜주어야 함

		} catch (Exception e) {
			return null;

		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
	}

	// NutrientsSelect (영양제 전체 조회)
	public List<GoodsDTO> NutrientsSelect() { // null처리도 해주기 위해서 위의 주석문장을 try~catch로 감싸줌
		try {
			sqlSession = sqlSessionFactory.openSession(); // 어플리케이션과 DB 통로 역할

			return sqlSession.selectList("adminMapper.NutrientsSelect"); // admin-mapper.xml에서 namespace.id와 일치시켜주어야 함

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
