package com.excelupload.service;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.excelupload.domain.testListDTO;
import com.excelupload.persistence.testListDAO;

import lombok.extern.slf4j.Slf4j;
import utill.ExcelRead;
import utill.ExcelReadOption;


@Slf4j
@Service
public class testServiceImpl implements testService {
	
	@Autowired // DB사용
	private SqlSession sqlSession;
	
	testListDAO tDao;
	
	@Autowired
	public void TestDAO() {
		tDao = sqlSession.getMapper(testListDAO.class);
	}
	
	//DB list 
	public List<testListDTO> list() {
		
		log.info("서비스 진행");
		return tDao.list();
	}

	
	
	
	//엑셀 업로드 
	@Override
	public void excelUpload(File destFile) {
	
		log.info("서비스 도착 :" + destFile.getAbsolutePath()); 
		
		ExcelReadOption excelReadOption = new ExcelReadOption();
		
		//파일경로 추가
		excelReadOption.setFilePath(destFile.getAbsolutePath()); // 파일 실행 경로 
		
		 //추출할 컬럼명 추가
        excelReadOption.setOutputColumns("A", "B", "C","D","E");
        
        //시작 행 
        excelReadOption.setStartRow(2);
        
        List<Map<String, String>>excelContent  = ExcelRead.read(excelReadOption); //ExcelRead 의 read는 static class 
        
        Map<String, Object> paramMap = new HashMap<String, Object>();
       
        
        paramMap.put("excelContent", excelContent);
        
        try {
        	tDao.insertExcel(paramMap);
        }catch(Exception e) {
            e.printStackTrace();
        }
        
        
       
		
	}

	

	

}
