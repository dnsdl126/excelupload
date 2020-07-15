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

	private Integer snum;
	private String sname;
	private String sgrade;
	private Date sbirth;
	private String school;
	
}
