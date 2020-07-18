package utill;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ExcelRead {
	 public static List<Map<String, Object>> read(ExcelReadOption excelReadOption) { 
		 
		 
	        Workbook wb = ExcelFileType.getWorkbook(excelReadOption.getFilePath());
	        // 엑셀 파일 자체
	        // 엑셀파일을 읽어 들인다.
	      
	 
	        int sheetNum = wb.getNumberOfSheets(); 
	        //모든 시트
	       
	        int numOfcells = 0;
	        
	        Row row = null;
	        Cell cell = null;
	        
	        String cellName = "";
	        
	        
	        Map<String, Object> map = null;
	        // 각 row 마다 값을 저장할 맵 객체
	        // putt("A", "이름"); 같은 형식
	        
	        
	        List<Map<String, Object>> result = new ArrayList<Map<String, Object>>(); 
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
			        		
			        		map = new HashMap<String, Object>();
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
					        			 
					        			 
					        			 switch (cell.getCellType()) { // 각 셀에 담겨있는 데이터의 타입을 체크하고, 해당 타입에 맞게 가져온다.
					        		        
					        		    	case Cell.CELL_TYPE_NUMERIC:
					        		            if (DateUtil.isCellDateFormatted(cell)) {
					        		                //SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
					        		                map.put(cellName, cell.getDateCellValue()); //날짜 형식 (엑셀 셀형식 날짜로 되어있어야한다 )
					        		                
					        		                //log.info("Date :" + cell.getDateCellValue());
					        		                break;
					        		            } else {
					        		            	
					        		            	//log.info("int : " + Integer.toString((int)cell.getNumericCellValue()));
					        		            	 map.put(cellName, new Double(cell.getNumericCellValue()).intValue()); 
					        		            	 //intValue() : Integer객체에서 int 형 값을 추출
					        		            	 //parseint() : String형 객체에서 int형 값 추출  
					        		            	 
					        		            	 // double 은 기본 형 Double은 wrapper class 
					        		            	 // 반환으로 int 형이 필요하다 colum은 Integer 로 되어있지만
					        		            	 // postgresql dataType : Integer == java dataType : int
					        		            	 // 반환으로 int가 들어가 야 한다
					        		            	 // map 의 value 가 object type 으로 선언 했는데
					        		            	 // object type의 변수는 객체자료형만 표현이 가능 하므로
					        		            	 // int, double 등의 기본자료형 불가
					        		            	 // Wrapper 클래스를 사용하여 객체자료형으로 변환해야 한다 
					        		           
					        		            	 
					        		            	 
					        		            	 break;

					        		            }
					        		            
					        		        case Cell.CELL_TYPE_STRING:
					        		            map.put(cellName, cell.getStringCellValue());
					        		            break;
					        		        case Cell.CELL_TYPE_BLANK:
					        		            map.put(cellName, "");
					        		            break;
					        		        case Cell.CELL_TYPE_ERROR:
					        		            map.put(cellName, String.valueOf(cell.getErrorCellValue()));
					        		            break;
					        		        default : 
					        		            map.put(cellName, cell.getStringCellValue());
					        		            break;
					        		    } 
			        			 
					        			 
					        			 
			        			 //map.put(cellName, ExcelCellRef.getValue(cell));
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
	        
	        
