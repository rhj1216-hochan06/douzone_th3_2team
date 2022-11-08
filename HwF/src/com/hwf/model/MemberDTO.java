package com.hwf.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MemberDTO { // model

<<<<<<< HEAD
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
=======
	private String memberid; // 회원 id
	private String memberpwd; // 회원 pw
	private String membername; // 회원 이름
	private String membersex; // 회원 성별
>>>>>>> origin/HongGeonho

	public MemberDTO(String memberid, String memberpwd) {
		this.memberid = memberid;
		this.memberpwd = memberpwd;
	}
}
