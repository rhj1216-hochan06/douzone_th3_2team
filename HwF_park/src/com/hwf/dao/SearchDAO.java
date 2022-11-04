package com.hwf.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Component;

import com.hwf.config.SqlSessionFactoryService;
import com.hwf.model.SearchDTO;

@Component
public class SearchDAO {
	
	private SqlSessionFactory  sqlSessionFactory;
	private SqlSession sqlSession = null;    //  DML 처리 함수를 갖고 있다.
	
	public SearchDAO() {
		sqlSessionFactory = SqlSessionFactoryService.getSqlSessionFactory();
	}
	
	
	public List<SearchDTO>  searchpage() {
		try {
			sqlSession = sqlSessionFactory.openSession();   // app과 db를 연결(통로)
			return sqlSession.selectList("dao.searching");
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			if( sqlSession != null ) { sqlSession.close(); }
		}  // try end
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
	
	public List<SearchDTO> getSearchListSelect(Map<String, String> map ) { // 조건 검색

		try {
			sqlSession = sqlSessionFactory.openSession();
			return sqlSession.selectList("dao.searchpage", map);
			
		} catch (Exception e) {
			return null;
		} finally {
			if (sqlSession != null) {		sqlSession.close();		}
		}
	}


	public List<SearchDTO> searching(Map<String, String> map) {
		try{
			 sqlSession = sqlSessionFactory.openSession();
			 System.out.println("DTO : "+map);
			 return sqlSession.selectList("dao.searching" , map);
		}catch(Exception e){
			 return null;
		}finally{
			if(sqlSession != null){ sqlSession.close(); }
		}
	}

	




	
	

	}
