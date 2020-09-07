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
	private XSSFWorkbook _xwb ;	// ����� �Ź��� ���� workbook
	private XSSFSheet _xwbSheet ;	// �Ź��� ������ sheet
	private CellStyle _cellStyleGreen ;	// �� ��Ÿ�� green
	private CellStyle _cellStyleRed ;	// �� ��Ÿ�� red
	
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
		// Green : ����  ;  Red : ����
		
		this._cellStyleGreen.setFillForegroundColor(HSSFColor.LIME.index) ;
		this._cellStyleGreen.setFillPattern(CellStyle.BIG_SPOTS) ;
		// �� ��Ÿ�� ����
		
		this._cellStyleRed.setFillForegroundColor(HSSFColor.ROSE.index) ;
		this._cellStyleRed.setFillPattern(CellStyle.BIG_SPOTS) ;
		// �� ��Ÿ�� ����
		
	}
	
	// �ð�ǥ ����, ���� ����
	public void makeSheet(int rowindex, int columnindex, Message message, String name){
		Cell cell = this.getCellByRowCol(rowindex, columnindex) ;
		
		switch(message){
		case Error:
			break;
		case isGreen:
			// �̹� �������� ������ ��� �ٽ� �������� ������ �ָ� �ȵǱ� ������ �� �ڵ带 �߰��Ͽ���.
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
	
	// rowindex�� columnindex�� �̿��Ͽ� �Ź��� ���������� cell�� ã�� ��ȯ�Ѵ�.
	private Cell getCellByRowCol(int rowindex, int columnindex){
		Row rowx = _xwbSheet.getRow(rowindex) ;
		Cell cellx = rowx.getCell(columnindex) ;
		return cellx ;
	}
	
	private void cellToGreen(Cell aCell){	// ������ ���� ��� ������� �ٲ�
		aCell.setCellStyle(this._cellStyleGreen) ;
	}

	private void cellToRed(Cell aCell){	// ������ ���� ��� cell�� ���������� �ٲٰ� ������ �Է��Ѵ�.
		aCell.setCellStyle(this._cellStyleRed) ;
		aCell.setCellValue("����") ;
	}
	
	// xwb���
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
