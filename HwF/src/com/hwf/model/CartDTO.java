package com.hwf.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class CartDTO {
	
	private String memberId; // 고객 아이디
	private String productsId; // 물품 아이디
	private String productsName; // 물품 이름
	private String productsIMG; // 물품 사진 주소
	private int productsPrice; // 물품 가격
	private int reservation; // 즉시, 예약 선택
	private String purchasetime; // 구매할 날짜
	private String endtime; // 수령이 끝나는 날짜
	
	public CartDTO(String memberId, String productsId, String productsName, String productsIMG, int productsPrice,
			int reservation, String purchasetime, String endtime) {
		super();
		this.memberId = memberId;
		this.productsId = productsId;
		this.productsName = productsName;
		this.productsIMG = productsIMG;
		this.productsPrice = productsPrice;
		this.reservation = reservation;
		this.purchasetime = purchasetime;
		this.endtime = endtime;
	}
	
	
	
}