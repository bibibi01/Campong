package com.multi.campong.moim.vo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Moim {
	private int meetNo;
	private String name;
	private String contentId;
	private String title;
	private String apes;
	private String introduction;
	private String status;
	private String startDate;
	private String endDate;
	private String ageRange;
	private String minExpense;
	private String maxExpense;
	private String phone;
}
