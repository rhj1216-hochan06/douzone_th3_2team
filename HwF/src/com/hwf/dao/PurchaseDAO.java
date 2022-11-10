package com.hwf.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Component;

import com.hwf.config.SqlSessionFactoryService;
import com.hwf.model.PurchaseDTO;

@Component
public class PurchaseDAO {
	private SqlSessionFactory sqlSessionFactory;
	private SqlSession sqlSession = null;

	public PurchaseDAO() {

		sqlSessionFactory = SqlSessionFactoryService.getSqlSessionFactory();
	}

	//회원 - 주문내역 조회
	public List<PurchaseDTO> selectmemberid(String memberid) {
		try {
			sqlSession = sqlSessionFactory.openSession();

			return sqlSession.selectList("purchasedao.selectmemberid", memberid);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		} // try end
	}
	
	
	//관리자 - 전체 주문내역 조회
	public List<PurchaseDTO> AdminOrderSelect() {
		try {
			sqlSession = sqlSessionFactory.openSession();

			return sqlSession.selectList("adminMapper.AdminOrderSelect");
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
			
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		} 
	}

}