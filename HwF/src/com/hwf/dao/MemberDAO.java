package com.hwf.dao;


import java.util.Map;

import com.hwf.model.MemberDTO;

public interface MemberDAO {
	//회원가입 처리
	public int insertUser(Map<String,String> map);
	//로그인 처리
	public Map<String,Object> selectUser(String userid);
	//
	public boolean checkMember(MemberDTO dto);
}
