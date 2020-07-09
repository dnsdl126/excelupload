package com.excelupload.domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
@NoArgsConstructor

public class testListDTO {

	private int snum;
	private String sname;
	private String sgrade;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date sbirth;
	private String school;
	
}
