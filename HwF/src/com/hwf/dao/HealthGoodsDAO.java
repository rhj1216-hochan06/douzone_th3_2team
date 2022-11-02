//package com.hwf.dao;
//
//import java.util.List;
//
//import org.apache.ibatis.session.SqlSession;
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.springframework.stereotype.Component;
//
//import com.hwf.config.SqlSessionFactoryService;
//import com.hwf.model.HealthGoodsDTO;
//
//@Component
//public class HealthGoodsDAO {
//	
//	private SqlSession session = null; //DML쿼리문 다 갖는 SqlSession 인터페이스
//	
//	private SqlSessionFactory sqlSessionFactory;
//	private SqlSession sqlSession = null; //DML 처리함수 가짐
//	
//	public HealthGoodsDAO() {
//		sqlSessionFactory = SqlSessionFactoryService.getSqlSessionFactory(); //openSession() 가능
//	}
//	
//	
//	//DML 관련 - 메소드명을 member-mapper.xml와 맞춰주기
//	
//	//HealthGoodsSelect
//	public List<HealthGoodsDTO> HealthGoodsSelect() { //null처리도 해주기 위해서 위의 주석문장을 try~catch로 감싸줌
//		try {
//			sqlSession = sqlSessionFactory.openSession(); //어플리케이션과 DB 통로 역할
//			
//			return sqlSession.selectList("dao.HealthGoodsSelect"); //member-mapper.xml에서 namespace.id와 일치시켜주어야 함
//			
//		} catch (Exception e) {
//			return null;
//			
//		} finally { 
//			if (sqlSession!=null) {sqlSession.close();} 
//		}
//	}
//
//}
