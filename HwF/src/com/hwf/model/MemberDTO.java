package com.hwf.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MemberDTO { // model

	private String memberId; // 회원 id
	private String memberPwd; // 회원 pw
	private String memberName; // 회원 이름
	private int memberSex; // 회원 성별

}
