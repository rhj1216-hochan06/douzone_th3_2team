package com.hwf.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Component;

import com.hwf.config.SqlSessionFactoryService;
import com.hwf.model.HealthFoodDTO;
import com.hwf.model.HealthGoodsDTO;
import com.hwf.model.NutrientsDTO;
import com.hwf.model.SearchDTO;

@Component
public class SearchDAO {
	
	
	private SqlSessionFactory  sqlSessionFactory;
	private SqlSession sqlSession = null;    //  DML 처리 함수를 갖고 있다.
	
	public SearchDAO() {
		sqlSessionFactory = SqlSessionFactoryService.getSqlSessionFactory();
	}
	
	public List<SearchDTO>  serachAll() {
		try {
			sqlSession = sqlSessionFactory.openSession();   // app과 db를 연결(통로)
			return sqlSession.selectList("dao.serachAll");
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			if( sqlSession != null ) { sqlSession.close(); }
		}  // try end
	}

	
	public List<SearchDTO> searching(Map<String, String> map){
		try{
			 sqlSession = sqlSessionFactory.openSession();
			 System.out.println("DAO 오셨나요? " +  map);
			 return sqlSession.selectList("dao.searching",map); // mapping 이름과 같아야함			
		}catch(Exception e){
			 return null;
		}finally{
			if(sqlSession != null){ sqlSession.close(); }
		}
	}
	
	// ----------------------------------------------------------------

	// 용품
	public List<HealthGoodsDTO> SearchHealthGoodsSelect() { //null처리도 해주기 위해서 위의 주석문장을 try~catch로 감싸줌
		try {
			sqlSession = sqlSessionFactory.openSession(); //어플리케이션과 DB 통로 역할
			
			return sqlSession.selectList("dao.SearchHealthGoodsSelect"); //member-mapper.xml에서 namespace.id와 일치시켜주어야 함
			
		} catch (Exception e) {
			return null;
			
		} finally { 
			if (sqlSession!=null) {sqlSession.close();} 
		}
	}
	
	
	public List<HealthGoodsDTO> searchingHealthGoodsSelect(Map<String, String> map){
		try{
			 sqlSession = sqlSessionFactory.openSession();
			 System.out.println("DAO 오셨나요? " +  map);
			 return sqlSession.selectList("dao.searchingHealthGoodsSelect",map); // mapping 이름과 같아야함			
		}catch(Exception e){
			 return null;
		}finally{
			if(sqlSession != null){ sqlSession.close(); }
		}
	}
	
	// food
	public List<HealthFoodDTO> SearchHealthFoodSelect() { //null처리도 해주기 위해서 위의 주석문장을 try~catch로 감싸줌
		try {
			sqlSession = sqlSessionFactory.openSession(); //어플리케이션과 DB 통로 역할
			
			return sqlSession.selectList("dao.SearchHealthFoodSelect"); //member-mapper.xml에서 namespace.id와 일치시켜주어야 함
			
		} catch (Exception e) {
			return null;
			
		} finally { 
			if (sqlSession!=null) {sqlSession.close();} 
		}
	}
	
	public List<HealthFoodDTO> searchingHealthFoodSelect(Map<String, String> map){
		try{
			 sqlSession = sqlSessionFactory.openSession();
			 System.out.println("DAO 오셨나요? " +  map);
			 return sqlSession.selectList("dao.searchingHealthFoodSelect",map); // mapping 이름과 같아야함			
		}catch(Exception e){
			 return null;
		}finally{
			if(sqlSession != null){ sqlSession.close(); }
		}
	}

	// 영양제
	public List<NutrientsDTO> SearchNutrientsSelect() { //null처리도 해주기 위해서 위의 주석문장을 try~catch로 감싸줌
		try {
			sqlSession = sqlSessionFactory.openSession(); //어플리케이션과 DB 통로 역할
			
			return sqlSession.selectList("dao.SearchNutrientsSelect"); //member-mapper.xml에서 namespace.id와 일치시켜주어야 함
			
		} catch (Exception e) {
			return null;
			
		} finally { 
			if (sqlSession!=null) {sqlSession.close();} 
		}
	}
	
	public List<NutrientsDTO> searchingNutrientsSelect(Map<String, String> map){
		try{
			 sqlSession = sqlSessionFactory.openSession();
			 System.out.println("DAO 오셨나요? " +  map);
			 return sqlSession.selectList("dao.searchingNutrientsSelect",map); // mapping 이름과 같아야함			
		}catch(Exception e){
			 return null;
		}finally{
			if(sqlSession != null){ sqlSession.close(); }
		}
	}
	
	public List<NutrientsDTO> surveysearching(Map<String, String> map){
		try{
			 sqlSession = sqlSessionFactory.openSession();
			 System.out.println("DAO 오셨나요? " +  map);
			 return sqlSession.selectList("dao.surveysearching",map); // mapping 이름과 같아야함			
		}catch(Exception e){
			 return null;
		}finally{
			if(sqlSession != null){ sqlSession.close(); }
		}
	}
	
	public List<NutrientsDTO> inbodysearching(Map<String, String> map){
		try{
			 sqlSession = sqlSessionFactory.openSession();
			 System.out.println("DAO 오셨나요? " +  map);
			 return sqlSession.selectList("dao.inbodysearching",map); // mapping 이름과 같아야함			
		}catch(Exception e){
			 return null;
		}finally{
			if(sqlSession != null){ sqlSession.close(); }
		}
	}
	
	
	

	
	//
//	public List<SearchDTO> searching(Map<String, String> map){ // 전체검색
//		try{
//			 sqlSession = sqlSessionFactory.openSession();
//			 System.out.println("DTO : "+map);
//			 return sqlSession.selectList("dao.searching" , map);
//		}catch(Exception e){
//			 return null;
//		}finally{
//			if(sqlSession != null){ sqlSession.close(); }
//		}
//	}



	
	

	}
