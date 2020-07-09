package com.excelupload.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.excelupload.domain.testListDTO;
import com.excelupload.persistence.testListDAO;

import lombok.extern.slf4j.Slf4j;

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
	
	public List<testListDTO> list() {
		
		log.info("서비스 진행");
		return tDao.list();
	}

	

}
