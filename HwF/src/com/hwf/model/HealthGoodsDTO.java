package com.hwf.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class HealthGoodsDTO { // model

	private int goodsId; // 헬스용품 id
	private int goodsPrice; // 헬스용품 가격
	private int goodsCategory; // 헬스용품 카테고리
	private String goodsName; // 헬스용품 이름
	private String goodsImg; // 헬스용품 이미지
	private String goodsDetail; // 헬스용품 상세설명
	private String link; // 설문조사 링크
}