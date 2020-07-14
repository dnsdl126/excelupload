package utill;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ExcelRead {
	 public static List<Map<String, String>> read(ExcelReadOption excelReadOption) { 
		 
		 
	        Workbook wb = ExcelFileType.getWorkbook(excelReadOption.getFilePath());
	        // 엑셀 파일 자체
	        // 엑셀파일을 읽어 들인다.
	      
	 
	        int sheetNum = wb.getNumberOfSheets(); 
	        //모든 시트
	       
	        int numOfcells = 0;
	        
	        Row row = null;
	        Cell cell = null;
	        
	        String cellName = "";
	        
	        
	        Map<String, String> map = null;
	        // 각 row 마다 값을 저장할 맵 객체
	        // putt("A", "이름"); 같은 형식
	        
	        
	        List<Map<String, String>> result = new ArrayList<Map<String, String>>(); 
	        // 각 Row를 리스트에 담는다
	        // 하나의 Row는 하나의 Map으로 표현 
	        // List에는 모든 Row를 담는다
			
	        //sheet  수만큼 반복 
	        for(int i=0; i<sheetNum; i++) {
		        	log.info( "sheet 이름 : " + wb.getSheetName(i)); 
		        	//:Name: /xl/worksheets/sheet6.xml
		        	
		        	Sheet sheet = wb.getSheetAt(i);
		        	
		        	int numOfRows = sheet.getPhysicalNumberOfRows(); 
		        	// 유효한 데이터가 있는 행의 개수를 가지고 옴 
		        	
		        	for(int rowIndex = excelReadOption.getStartRow()-1 ; rowIndex < numOfRows; rowIndex++  ) {
		        	// rowIndex =  추출을 시작할 행 인덱스 
		        	// 워크북에서 가져온 시트에서  rowIndex에 해당하는 Row를 가지고 온다 
		        	// 하나의 Row는 여러가지 cell을 가지고 있음
		        	
			        	row = sheet.getRow(rowIndex);
			        	
			        	if(row != null) {
			        		
			        		numOfcells = row.getLastCellNum();
			        		//가져온 row의 셀 개수 
			        		
			        		map = new HashMap<String, String>();
			        		// 데이터를 담을 맵 객체
			        		
			        		for(int cellIndex = 0; cellIndex < numOfcells; cellIndex++) {
			        			 
				        			 cell = row.getCell(cellIndex);
				        			 cellName = ExcelCellRef.getName(cell, cellIndex);
				        			 // Row에서 cellIndex에 해당하는 Cell을 가지고 온다
				        			 // 이름 예 : A, B, C 
			        			 
					        			 if( !excelReadOption.getOutputColumns().contains(cellName) ) {
					        				 // 추출 대상 컬럼인지 확인
					        				 // 컬럼이 아닌경우 다시 for 시작
					        				 continue;
					                        }
			        			 
			        			 map.put(cellName, ExcelCellRef.getValue(cell));
			        			 // map의 객체의 cell 이름을 key로 데이터 담음
			        			 
			        		 }
			        		
			        		result.add(map);
			        		//map을 다시 list로 담음 
			        		
			        	}
			        		
		        	}
	        	}
	        	return result;
	        }
	        
	}       
	        
	        
