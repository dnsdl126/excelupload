package com.excelupload.service;

import java.io.File;
import java.util.List;

import com.excelupload.domain.testListDTO;



public interface testService {

	public List<testListDTO> list();

	public void excelUpload(File destFile);

}
