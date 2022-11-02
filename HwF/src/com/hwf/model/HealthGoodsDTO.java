package com.hwf.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class HealthGoodsDTO { // model

	private int goodsId, goodsPrice, goodsCategory; 
	private String goodsName, goodsImg, goodsDetail;

}
