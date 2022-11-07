package com.hwf.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class SurveyDTO {

	private String surveyid;
	private String goal ; // 목표 (증량/감량)
	private String currentstate; //현재 상태 (비만/정상/왜소)
	private String currentintke; //현재 섭취 상태 (과다/정상/부족)
	private String link; //결과 제품 추천용
	private String memberid; // 아이디회원id (외래키)


	public SurveyDTO(String goal,String currentstate,String currentintke,String link,String memberid) {
		this.goal= goal;
		this.currentstate=currentstate;
		this.currentintke= currentintke;
		this.link= link;
		this.memberid= memberid;
		
	}

}
