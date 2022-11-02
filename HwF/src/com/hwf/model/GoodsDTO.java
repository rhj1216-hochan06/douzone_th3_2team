package com.hwf.model;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GoodsDTO { // model

	/*************** HealthGoodsDTO (헬스용품) ***************/
	
	private int healthGoodsId, healthGoodsPrice, healthGoodsCategory; 
	private String healthGoodsName, healthGoodsImg, healthGoodsDetail;
	private String healthGoodsLink; //추가

	//AdminController - AdminGoodsInsert()에서 필요한 생성자
	public GoodsDTO(String healthGoodsName, int healthGoodsPrice, int healthGoodsCategory, String healthGoodsImg, String healthGoodsDetail, String healthGoodsLink) {
		super();
		this.healthGoodsName = healthGoodsName;
		this.healthGoodsPrice = healthGoodsPrice;
		this.healthGoodsCategory = healthGoodsCategory;
		this.healthGoodsImg = healthGoodsImg;
		this.healthGoodsDetail = healthGoodsDetail;
		this.healthGoodsLink = healthGoodsLink;
	}
	
	
	
	/*************** HealthFoodDTO (헬스식품) ***************/
	
	private int hfId, hfPrice, hfCategory;
	private String hfName, hfImg, hfDetail;
//	private java.util.Date hfDom;
//	private Date hfDom;
	private String hfDom;
	private String hfLink; //추가
	
	//AdminController - AdminGoodsInsert()에서 필요한 생성자
//	public GoodsDTO(String hfName, int hfPrice, int hfCategory, String hfImg, String hfDetail, String hfLink) {
//		this.hfName = hfName;
//		this.hfPrice = hfPrice;
//		this.hfCategory = hfCategory;
//		this.hfImg = hfImg;
//		this.hfDetail = hfDetail;
//		this.hfLink = hfLink;
//	}
	
	public GoodsDTO(String hfName, int hfPrice, int hfCategory, String hfImg, String hfDetail, String hfDom, String hfLink) {
		super();
		this.hfName = hfName;
		this.hfPrice = hfPrice;
		this.hfCategory = hfCategory;
		this.hfImg = hfImg;
		this.hfDetail = hfDetail;
		this.hfDom = hfDom;
		this.hfLink = hfLink;
	}
	
//	public GoodsDTO(String hfName, int hfPrice, int hfCategory, String hfImg, String hfDetail, Date hfDom, String hfLink) {
//		super();
//		this.hfName = hfName;
//		this.hfPrice = hfPrice;
//		this.hfCategory = hfCategory;
//		this.hfImg = hfImg;
//		this.hfDetail = hfDetail;
//		this.hfDom = hfDom;
//		this.hfLink = hfLink;
//	}
	
//	public GoodsDTO(String hfName, int hfPrice, int hfCategory, String hfImg, String hfDetail, java.util.Date hfDom, String hfLink) {
//		super();
//		this.hfName = hfName;
//		this.hfPrice = hfPrice;
//		this.hfCategory = hfCategory;
//		this.hfImg = hfImg;
//		this.hfDetail = hfDetail;
//		this.hfDom = hfDom;
//		this.hfLink = hfLink;
//	}
	
	
	
	/*************** NutrientsDTO (영양제) ***************/
	
	private int nutrientsID, nutrientsPrice, nutrientsCategory, numPerBottle, remainingNum; 
	private String nutrientsName, nutrientsImg, nutrientsDetail, dailyIntake;
	private Date nutrientsDoM;
	private String link; //추후에 nutrientsLink로 변경
}
