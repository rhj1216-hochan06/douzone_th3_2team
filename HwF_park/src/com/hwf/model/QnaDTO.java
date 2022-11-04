package com.hwf.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class QnaDTO {   // model

	private int qnaid;
	private String qnadate;
	private String qnacontent, qnaanswer, memberid;
	
	public QnaDTO(String qnacontent, String qnaanswer, String memberid) {
		super();
		this.qnacontent = qnacontent;
		this.qnaanswer = qnaanswer;
		this.memberid = memberid;
	}

}






