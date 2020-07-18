package utill;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.util.CellReference;

public class ExcelCellRef {
	

    /**
     * Cell에 해당하는 Column Name을 가젼온다(A,B,C..)
     * 만약 Cell이 Null이라면 int cellIndex의 값으로
     * Column Name을 가져온다.
     * @param cell
     * @param cellIndex
     * @return
     */
    public static String getName(Cell cell, int cellIndex) {
        int cellNum = 0;
        if(cell != null) {
            cellNum = cell.getColumnIndex();
        }
        else {
            cellNum = cellIndex;
        }
 
        return CellReference.convertNumToColString(cellNum);
    }
 
    @SuppressWarnings("deprecation")
    public static String getValue(Cell cell) {
    	
    	switch (cell.getCellType()) { // 각 셀에 담겨있는 데이터의 타입을 체크하고, 해당 타입에 맞게 가져온다.
        
    	case Cell.CELL_TYPE_NUMERIC:
            if (DateUtil.isCellDateFormatted(cell)) {
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                return dateFormat.format(cell.getDateCellValue());
            } else {
               
            	return String.valueOf(cell.getNumericCellValue());
                
            }
            
        case Cell.CELL_TYPE_STRING:
            return cell.getStringCellValue();
       
        case Cell.CELL_TYPE_BLANK:
            return "";
        
        case Cell.CELL_TYPE_ERROR:
            return String.valueOf(cell.getErrorCellValue());
        
        default : 
            return cell.getStringCellValue();
    }
}
    }

