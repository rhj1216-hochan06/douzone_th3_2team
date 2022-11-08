package com.hwf.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Component;

import com.hwf.config.SqlSessionFactoryService;
import com.hwf.model.SurveyDTO;

@Component
public class SurveyDAO {
	private SqlSessionFactory sqlSessionFactory;
	private SqlSession sqlSession = null;
	

	public SurveyDAO() {
		
		sqlSessionFactory = SqlSessionFactoryService.getSqlSessionFactory();
	}
	
	
	
	// insert
	public int insert(SurveyDTO dto) {
		
		System.out.println(dto.toString());
		
		
		try {
			
			System.out.println("1");
			sqlSession = sqlSessionFactory.openSession();
			System.out.println("2");
			int result = sqlSession.insert("surveydao.insert", dto);
			System.out.println("3");
			sqlSession.commit();
			System.out.println("4");
			return result;

		} catch (Exception e) {
			return 0;
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		} // try end
	} // write end

}
