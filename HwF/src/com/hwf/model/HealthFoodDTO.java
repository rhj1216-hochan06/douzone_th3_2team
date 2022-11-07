package com.hwf.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class HealthFoodDTO {
	private int hfid; // 식품 id
	private String hfName; // 식품 이름
	private int hfPrice; // 식품 가격
	private int hfCategory; // 식품 카테고리
	private String hfIMG; // 식품 이미지
	private String hfDetail; // 식품 상세설명
	private Date hfDoM; // 식품 제조날짜
	private String link; // 인바디,설문 연결값

}