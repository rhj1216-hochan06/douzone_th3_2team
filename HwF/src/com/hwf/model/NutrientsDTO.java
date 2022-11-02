package com.hwf.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class NutrientsDTO {

	private int nutrientsID; // 영양제 번호 
	private String nutrientsName; // 영양제 이름 
	private int nutrientsPrice; // 영양제 가격 
	private int nutrientsCategory; // 영양제 카테고리 
	private String nutrientsIMG; // 영양제 사진 주소
	private String nutrientsDetail; // 영양제 설명 
	private String nutrientsDOM; // 영양제 제조날짜 
	private String dailyInTake; // 영양제 하루에 먹어야 하는 수량 
	private int numperbottle; // 영양제 한병에 있는 수량 
	private int remainingNum; // 현재 잔여 갯수 
	private String nutrientsTestLink; // 인바디, 설문 결과

}
