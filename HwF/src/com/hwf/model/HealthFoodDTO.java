package com.hwf.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class HealthFoodDTO {
	
	/*************** HealthFoodDTO (헬스식품) ***************/
	
	private int hfId;			    //헬스식품 id
	private String hfName;			//헬스식품 이름
	private int hfPrice;			//헬스식품 가격
	private int hfCategory;			//헬스식품 카테고리
	private String hfImg;			//헬스식품 이미지
	private String hfDetail;		//헬스식품 상세설명
//	private java.sql.Date hfDom;    //헬스식품 제조날짜
//	private java.util.Date hfDom;   //헬스식품 제조날짜
//	private Date hfDom;				//헬스식품 제조날짜
	private String hfDom;			//헬스식품 제조날짜
	private String hfLink; 			//인바디,설문 연결값
	
	
	//AdminController - AdminHealthFoodInsert()에서 필요한 생성자
	public HealthFoodDTO(String hfName, int hfPrice, int hfCategory, String hfImg, String hfDetail, String hfDom, String hfLink) {
		super();
		this.hfName = hfName;
		this.hfPrice = hfPrice;
		this.hfCategory = hfCategory;
		this.hfImg = hfImg;
		this.hfDetail = hfDetail;
		this.hfDom = hfDom;
		this.hfLink = hfLink;
	}

}
