package com.excelupload.persistence;

import java.util.List;
import java.util.Map;

import com.excelupload.domain.testListDTO;



public interface testListDAO {

	
	public List<testListDTO> list();
	
	public int insertDB(Map<String, Object> map);


}
