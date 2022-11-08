package com.hwf.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Component;

import com.hwf.config.SqlSessionFactoryService;
import com.hwf.model.InbodyDTO;

@Component
public class InbodyDAO {
	private SqlSessionFactory sqlSessionFactory;
	private SqlSession sqlSession = null;
	

	public InbodyDAO() {
		
		sqlSessionFactory = SqlSessionFactoryService.getSqlSessionFactory();
	}
	
	
	
	// insert
	public int insert(InbodyDTO dto) {
		
		System.out.println(dto.toString());
		
		
		try {
			
			System.out.println("1");
			sqlSession = sqlSessionFactory.openSession();
			System.out.println("2");
			int result = sqlSession.insert("inbodydao.insert", dto);
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
