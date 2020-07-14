package com.excelupload.service;

import java.io.File;
import java.util.List;

import com.excelupload.domain.testListDTO;



public interface testService {
	
	//DB 정보 select 
	public List<testListDTO> list();

	//excel read 
	public void excelUpload(File destFile);

}
