package com.hwf.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SearchDTO {
	
	// 헬스용품
	private int goodsId, goodsPrice, goodsCategory; 
	private String goodsName, goodsImg, goodsDetail;

	// 식품
	private String hfname;
	

	
	
	private String nutrientsname;


	public SearchDTO(int goodsId, String goodsName, int goodsPrice, int goodsCategory, String goodsImg,
			String goodsDetail) {
		super();
		this.goodsId = goodsId;
		this.goodsName = goodsName;
		this.goodsPrice = goodsPrice;
		this.goodsCategory = goodsCategory;		
		this.goodsImg = goodsImg;
		this.goodsDetail = goodsDetail;
	}
	
	
	
	
	
	
	
	
	
	
	
	
}




/*
 * HealthgoodsName varchar2(37), --헬스용품 이름
 * 
 * HFName varchar2(600), --식품 이름
 * 
 * NutrientsName varchar2(600), --영양제 이름
 */