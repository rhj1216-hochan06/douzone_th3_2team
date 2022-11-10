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

	// 회원 - 주문내역 조회
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

	// 관리자 - 전체 주문내역 조회
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

	// 헬스용품 구매
	public int purchaseGoods(PurchaseDTO dto) {

		try {
			sqlSession = sqlSessionFactory.openSession();

			int result = sqlSession.insert("purchasedao.insertgoods", dto);

			sqlSession.commit();
			return result;
		} catch (Exception e) {

			return 0;
		}
	}
	
	// 헬스식품 구매
	public int purchaseHealthFood(PurchaseDTO dto) {

		try {
			sqlSession = sqlSessionFactory.openSession();

			int result = sqlSession.insert("purchasedao.insertfood", dto);

			sqlSession.commit();
			return result;
		} catch (Exception e) {

			return 0;
		}
	}
	
	//영양제 구매
	public int purchaseNutr(PurchaseDTO dto) {

		try {
			sqlSession = sqlSessionFactory.openSession();

			int result = sqlSession.insert("purchasedao.insertnutr", dto);

			sqlSession.commit();
			return result;
		} catch (Exception e) {

			return 0;
		}
	}

	//삭제
	public int deleteData(String id) {
		try {
			sqlSession = sqlSessionFactory.openSession();

			int result = sqlSession.delete("purchasedao.deleteDataByMemberId", id);

			sqlSession.commit();
			return result;
		} catch (Exception e) {

			return 0;
		}

	}

}