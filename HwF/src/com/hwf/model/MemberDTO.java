package com.hwf.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MemberDTO { // model

	private String memberId, memberPwd, memberName;
	private int memberSex;

	public MemberDTO(String memberId, String memberName) {
		this.memberId = memberId;
		this.memberName = memberName;
	}

	public MemberDTO(String memberId, String memberName, int memberSex) {
		this.memberId = memberId;
		this.memberName = memberName;
		this.memberSex = memberSex;
	}

}
