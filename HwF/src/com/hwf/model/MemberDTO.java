package com.hwf.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class MemberDTO {

	private String memberid; // 아이디
	private String memberpwd; // 비번
	private String membername; // 이름
	private String membersex; // 성별

	

	public MemberDTO(String memberid, String memberpwd) {
		this.memberid = memberid;
		this.memberpwd = memberpwd;
	}


}
