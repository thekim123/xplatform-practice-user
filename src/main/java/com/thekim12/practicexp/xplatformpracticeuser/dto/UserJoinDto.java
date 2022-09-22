package com.thekim12.practicexp.xplatformpracticeuser.dto;

import com.tobesoft.xplatform.data.DataSet;

import lombok.Data;

@Data
public class UserJoinDto {
	
	private DataSet dataSet;
	private int rowNo;
	private String colid;

}
