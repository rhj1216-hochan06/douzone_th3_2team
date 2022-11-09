package com.hwf.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PurchaseDTO {

	private int purchaseId; // 구매 id
	private int purchaseNum; // 구매 갯수
	private int purchasePrice; // 구매 가격
	private String purchaseMethod; // 결제 방식 (카카오페이/현금)
	private String purchaseReceipt; // 수령 방식 (즉시/예약)
	private String purchaseDate; // 구매(결제) 날짜
	private String receiptStartDate; // 수령(픽업) 시작일
	private int receiptPeriod; // 수령(픽업) 기간
	private int healthgoodsID; // 헬스용품 id (외래키)
	private int hfid; // 식품 id (외래키)
	private int nutrientsID; // 영양제 id (외래키)
	private String memberID; // 회원id (외래키)


}
