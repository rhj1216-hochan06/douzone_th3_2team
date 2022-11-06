package com.hwf.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class NutrientsDTO {
	
/*************** NutrientsDTO (영양제) ***************/
	
	private int nutrientsId; 		//영양제 id
	private String nutrientsName;	//영양제 이름
	private int nutrientsPrice;		//영양제 가격
	private int nutrientsCategory;	//영양제 카테고리
	private String nutrientsImg;	//영양제 이미지
	private String nutrientsDetail;	//영양제 상세설명
	private String nutrientsDom;	//영양제 제조날짜
	private String dailyIntake;		//1일 섭취 갯수
	private int numPerBottle;		//1통 당 갯수
	private int remainingNum; 		//현재 잔여 갯수
	private String nutrientsLink; 	//인바디,설문 연결값 (Link -> nutrientsLink로 변경)
	
	
	//AdminController - AdminNutrientsInsert()에서 필요한 생성자
	public NutrientsDTO(String nutrientsName, int nutrientsPrice, int nutrientsCategory, String nutrientsImg, String nutrientsDetail, String nutrientsDom, String dailyIntake, int numPerBottle, int remainingNum, String nutrientsLink) {
		super();
		this.nutrientsName = nutrientsName;
		this.nutrientsPrice = nutrientsPrice;
		this.nutrientsCategory = nutrientsCategory;
		this.nutrientsImg = nutrientsImg;
		this.nutrientsDetail = nutrientsDetail;
		this.nutrientsDom = nutrientsDom;
		this.dailyIntake = dailyIntake;
		this.numPerBottle = numPerBottle;
		this.remainingNum = remainingNum;
		this.nutrientsLink = nutrientsLink;
	}
}
