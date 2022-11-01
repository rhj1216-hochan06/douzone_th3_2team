package com.hwf.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class NutrientsDTO {
	
	private int nutrientsID;
	private String nutrientsName;
	private int nutrientsPrice;
	private int nutrientsCategory;
	private String nutrientsIMG;
	private String nutrientsDetail;
	private Date nutrientsDOM;
	private String DailyInTake;
	private int numperbottle;
	private int remainingNum;
	private String nutrientsTestLink;
	
	
}
