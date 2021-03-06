package com.excelupload.controller;


import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.excelupload.domain.testListDTO;
import com.excelupload.service.testService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller

public class testcontroller {

	@Autowired
	testService tService;

	
	@GetMapping("/list")
	public String list(Model model){
	
		log.info("테스트를 시작 합니다 ");
		
		List <testListDTO> list = tService.list();
		
		for (testListDTO testListDTO : list) {
			log.info(testListDTO.toString());
		}
		log.info("list 출력 "+list);
		model.addAttribute("list", list);
		
		return "list/list";
	}
	
	@PostMapping("/excelupload")
	public String excelupload(MultipartFile excelFile, MultipartHttpServletRequest request) throws Exception  {
		 
		
		excelFile = request.getFile("excelFile"); 
	
		File destFile = new File("C:\\upload\\"+excelFile.getOriginalFilename()); // 경로 설정 
		
		 
		 try {
	            //내가 설정한 위치에 내가 올린 파일을 만든다
	            excelFile.transferTo(destFile);
	         } catch(Exception e) {
	            throw new RuntimeException(e.getMessage(),e);
	         }
	
		 	tService.excelUpload(destFile); // 경로 가지고 이동 
		 	
		 	return "list/list";
	}
}
