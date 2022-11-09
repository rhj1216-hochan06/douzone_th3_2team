package com.hwf.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Component;

import com.hwf.config.SqlSessionFactoryService;
import com.hwf.model.QnaDTO;

@Component
public class QnaDAO {

	private SqlSessionFactory sqlSessionFactory;
	private SqlSession sqlSession = null; // DML 처리 함수를 갖고 있다.

	public QnaDAO() {
		sqlSessionFactory = SqlSessionFactoryService.getSqlSessionFactory();
	}

	// select all
	public List<QnaDTO> selectAll() {
		try {
			sqlSession = sqlSessionFactory.openSession(); // app과 db를 연결(통로)
			return sqlSession.selectList("dao.selectAll");
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		} // try end
	}

	// insert
	public int insert(QnaDTO dto) {

		try {
			sqlSession = sqlSessionFactory.openSession();
			int result = sqlSession.insert("dao.insert", dto);
			sqlSession.commit(); //
			return result;

		} catch (Exception e) {
//			sqlSession.rollback();  // 단일 쿼리 실행시 의미가 없다.
			return 0;
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		} // try end
	} // write end

	public List<QnaDTO> getSearchList(Map<String, String> map) {
		try {
			/*
			 * for(Map.Entry<String, String> m : map.entrySet()){
			 * System.out.println(m.getKey() + "/" + m.getValue() +"-"); }
			 */
			sqlSession = sqlSessionFactory.openSession();
			return sqlSession.selectList("dao.selectSearch", map); // mapping 이름과 같아야함
		} catch (Exception e) {
			return null;
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
	}

	public int delete(int qnaid) {
		sqlSession = sqlSessionFactory.openSession();

		try {
			int rowcount = sqlSession.delete("dao.delete", qnaid); // dao.delete에 seq번호를 가지고 실행
			sqlSession.commit();
			return rowcount;
		} catch (Exception e) {
			return 0;
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		} // try end
	} // delete end

	public QnaDTO detailList(int qnaid) {
		try {
			sqlSession = sqlSessionFactory.openSession();
			QnaDTO dto = sqlSession.selectOne("dao.detailList", qnaid);
			System.out.println("dto : " + dto);
			return dto;
		} catch (Exception e) {
			return null;
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		} // try end
	} // end detail

	// update
	public int update(QnaDTO dto) {
		try {
			sqlSession = sqlSessionFactory.openSession();
			int rowcount = sqlSession.update("dao.update", dto);
			sqlSession.commit();
			return rowcount;

		} catch (Exception e) {
			return 0;
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
	} // end update

	// 전체 검색 조회_2
	public List<QnaDTO> getSearchList2(Map<String, String> map) {

		try {

			sqlSession = sqlSessionFactory.openSession();
			return sqlSession.selectList("dao.selectSearch2", map);

		} catch (Exception e) {
			return null;
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
	}

}
