package com.excelupload.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


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
		log.info("있음?"+list);
		model.addAttribute("list", list);
		
		return "list/list";
	}
	
}
