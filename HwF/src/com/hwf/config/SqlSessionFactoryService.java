<<<<<<< HEAD
package com.hwf.config;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlSessionFactoryService {

	//static 변수 -> 컴파일 되기전부터 메모리에 할당(자리 차지)
	private static SqlSessionFactory sqlSessionFactory;

	//익명 함수 (SqlSessionFactory = static 변수이기 때문에 static 영역에 초기화작업 (초기화 1번만 진행 후 재사용))
	//익명 함수이기 때문에 호출 불가
	static {
		String source = "./sqlMapConfig.xml";
		try {
			Reader reader = Resources.getResourceAsReader(source);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);

		} catch (Exception e) {
			e.printStackTrace();
		}
	} // end static

	public static SqlSessionFactory getSqlSessionFactory() {
		return sqlSessionFactory;
	}
}
=======
package com.hwf.config;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlSessionFactoryService {

	private static SqlSessionFactory sqlSessionFactory;

	static {
		String source = "./sqlMapConfig.xml";
		try {
			Reader reader = Resources.getResourceAsReader(source);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);

		} catch (Exception e) {
			e.printStackTrace();
		}
	} // end static

	public static SqlSessionFactory getSqlSessionFactory() {
		return sqlSessionFactory;
	}
}
>>>>>>> 7b57c06a2b993e3ac410128127817a588db8d338
