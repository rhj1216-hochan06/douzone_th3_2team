package com.hwf.model;

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
	private String purchaseMethod; // 결제 방식
	private String purchaseReceipt; // 수령 방식 (즉시/예약)
	private String purchaseDate; // 구매(결제) 날짜
	private String receiptStartDate; // 수령(픽업) 시작일
	private int receiptPeriod; // 수령(픽업) 기간
	private int healthgoodsID; // 헬스용품 id (외래키)
	private int hfid; // 식품 id (외래키)
	private int nutrientsID; // 영양제 id (외래키)
	private String memberID; // 회원id (외래키)

	public PurchaseDTO(int purchasePrice, String purchaseReceipt, String receiptStartDate, int receiptPeriod,
			int nutrientsID, String memberID) {
		super();
		this.purchasePrice = purchasePrice;
		this.purchaseReceipt = purchaseReceipt;
		this.receiptStartDate = receiptStartDate;
		this.receiptPeriod = receiptPeriod;
		this.nutrientsID = nutrientsID;
		this.memberID = memberID;
	}

	public PurchaseDTO(int purchaseNum, int purchasePrice, int hfid, String memberID) {
		super();
		this.purchaseNum = purchaseNum;
		this.purchasePrice = purchasePrice;
		this.hfid = hfid;
		this.memberID = memberID;
	}

	public PurchaseDTO(int purchaseNum, int purchasePrice, String purchaseReceipt, int healthgoodsID, String memberID) {
		super();
		this.purchaseNum = purchaseNum;
		this.purchasePrice = purchasePrice;
		this.purchaseReceipt = purchaseReceipt;
		this.healthgoodsID = healthgoodsID;
		this.memberID = memberID;
	}
}
