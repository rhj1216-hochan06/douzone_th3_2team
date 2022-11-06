package com.hwf.model;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class NutrientsDTO {
	
/*************** NutrientsDTO (영양제) ***************/
	
	private int nutrientsID; 		//영양제 id
	private String nutrientsName;	//영양제 이름
	private int nutrientsPrice;		//영양제 가격
	private int nutrientsCategory;	//영양제 카테고리
	private String nutrientsImg;	//영양제 이미지
	private String nutrientsDetail;	//영양제 상세설명
	private Date nutrientsDoM;		//영양제 제조날짜
	private String dailyIntake;		//1일 섭취 갯수
	private int numPerBottle;		//1통 당 갯수
	private int remainingNum; 		//현재 잔여 갯수
	private String nutrientsLink; 	//인바디,설문 연결값 (Link -> nutrientsLink로 변경)

}
