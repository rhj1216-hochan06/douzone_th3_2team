package com.hwf.model;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GoodsDTO { // model

	//HealthGoodsDTO (헬스용품)
	private int healthGoodsId, healthGoodsPrice, healthGoodsCategory; 
	private String healthGoodsName, healthGoodsImg, healthGoodsDetail;

	//HealthFoodDTO (헬스식품)
	private int hfId, hfPrice, hfCategory;
	private String hfName, hfImg, hfDetail, hfTestLink;
	private Date hfDom;
	
	//NutrientsDTO (영양제)
	private int nutrientsID, nutrientsPrice, nutrientsCategory, numPerBottle, remainingNum; 
	private String nutrientsName, nutrientsImg, nutrientsDetail, dailyIntake, link; 
	private Date nutrientsDoM;
}
