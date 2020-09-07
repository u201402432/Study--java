import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XSSFworkbook {
	private XSSFWorkbook _xwb ;	// 출력할 신버전 엑셀 workbook
	private XSSFSheet _xwbSheet ;	// 신버전 엑셀의 sheet
	private CellStyle _cellStyleGreen ;	// 셀 스타일 green
	private CellStyle _cellStyleRed ;	// 셀 스타일 red
	
	public XSSFworkbook(){
		this._xwb = new XSSFWorkbook() ;
		this._xwbSheet = this._xwb.createSheet("Result") ;
		
		for(int i=0 ; i<38 ; i++){
			this._xwbSheet.createRow(i) ;
			for(int j=0 ; j<10 ; j++)
				this._xwbSheet.getRow(i).createCell(j) ;
		}
		
		this._cellStyleGreen = _xwb.createCellStyle() ;
		this._cellStyleRed = _xwb.createCellStyle() ;
		// Green : 공강  ;  Red : 수업
		
		this._cellStyleGreen.setFillForegroundColor(HSSFColor.LIME.index) ;
		this._cellStyleGreen.setFillPattern(CellStyle.BIG_SPOTS) ;
		// 셀 스타일 설정
		
		this._cellStyleRed.setFillForegroundColor(HSSFColor.ROSE.index) ;
		this._cellStyleRed.setFillPattern(CellStyle.BIG_SPOTS) ;
		// 셀 스타일 설정
		
	}
	
	// 시간표 수업, 공강 설정
	public void makeSheet(int rowindex, int columnindex, Message message, String name){
		Cell cell = this.getCellByRowCol(rowindex, columnindex) ;
		
		switch(message){
		case Error:
			break;
		case isGreen:
			// 이미 수업으로 설정된 경우 다시 공강으로 설정해 주면 안되기 때문에 이 코드를 추가하였다.
			if(cell.getCellStyle().getFillForegroundColor()==HSSFColor.ROSE.index)
				break ;
			
			this.cellToGreen(cell) ;
			break;
			
		case isRed:
			this.cellToRed(cell) ;
			break;
			
		default:
			break;
			
		}
		
	}
	
	public void makeSheet(int rowindex, int columnindex, String value){
		Cell cell = this.getCellByRowCol(rowindex, columnindex) ;
		cell.setCellValue(value) ;
		
	}
	
	// rowindex와 columnindex를 이용하여 신버전 엑셀파일의 cell을 찾아 반환한다.
	private Cell getCellByRowCol(int rowindex, int columnindex){
		Row rowx = _xwbSheet.getRow(rowindex) ;
		Cell cellx = rowx.getCell(columnindex) ;
		return cellx ;
	}
	
	private void cellToGreen(Cell aCell){	// 수업이 없을 경우 녹색으로 바꿈
		aCell.setCellStyle(this._cellStyleGreen) ;
	}

	private void cellToRed(Cell aCell){	// 수업이 있을 경우 cell을 빨간색으로 바꾸고 수업을 입력한다.
		aCell.setCellStyle(this._cellStyleRed) ;
		aCell.setCellValue("수업") ;
	}
	
	// xwb출력
	public void outputXwb(){
		
		FileOutputStream stream = null;
		
		try {
			stream = new FileOutputStream("Result.xlsx");
			this._xwb.write(stream);
			stream.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}	// try
		
	}
	
}
