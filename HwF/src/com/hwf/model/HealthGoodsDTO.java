package com.hwf.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class HealthGoodsDTO { // model

	private int healthGoodsId, healthGoodsPrice, healthGoodsCategory; 
	private String healthGoodsName, healthGoodsImg, healthGoodsDetail;

}
