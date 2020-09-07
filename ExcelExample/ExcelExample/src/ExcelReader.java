import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;


// Apache POI , jar archives download : http://poi.apache.org/download.html

public class ExcelReader{
	
	private XSSFworkbook _xwb ;	// 출력할 신버전 엑셀 workbook
	private FileInputStream _fis ;	// 받은 file의 inputStream
	private File _givenFile ;	// 받은 엑셀 file
	private HSSFWorkbook _hwb ;		// 받은 엑셀 file의 workbook
	
	public ExcelReader(File file, XSSFworkbook xwb){
		this._xwb = xwb ;
		// 엑셀 07년도 버전보다 높은 XSSFWorkbook을 이용한 엑셀 파일 생성
		
		this._givenFile = file ;
	}
	
	@SuppressWarnings("deprecation")
	public void read() throws IOException{
			
		//파일을 읽기위해 엑셀파일을 가져온다 
		this._fis = new FileInputStream(this._givenFile) ;
		this._hwb = new HSSFWorkbook(this._fis) ;
		
		int rowindex = 0 ;
		int columnindex = 0 ;

		//시트 수 (첫번째에만 존재하므로 0을 준다)
		//만약 각 시트를 읽기위해서는 FOR문을 한번더 돌려준다
		HSSFSheet sheet=this._hwb.getSheetAt(0);
		
		//행의 수
		int rows = sheet.getPhysicalNumberOfRows();
		
		for(rowindex = 0 ; rowindex<rows ; rowindex++){
			
			//행을 읽는다
			HSSFRow row=sheet.getRow(rowindex);
			
			if(row !=null){				
				//셀의 수
				int cells = row.getPhysicalNumberOfCells() ;

				for(columnindex = 0 ; columnindex<=cells ; columnindex++){
					//셀값을 읽는다
					HSSFCell cell=row.getCell((short) columnindex);
					String value="";
					
					//셀이 빈값일경우를 위한 널체크
					if(cell==null)
						continue;
					else{
						//타입별로 내용 읽기
						switch (cell.getCellType()){
						case HSSFCell.CELL_TYPE_FORMULA:
							value=cell.getCellFormula();
							break;
						case HSSFCell.CELL_TYPE_NUMERIC:
							value=cell.getNumericCellValue()+"";
							break;
						case HSSFCell.CELL_TYPE_STRING:
							value=cell.getStringCellValue()+"";
							break;
						case HSSFCell.CELL_TYPE_BLANK:
							value=cell.getBooleanCellValue()+"";
							break;
						case HSSFCell.CELL_TYPE_ERROR:
							value=cell.getErrorCellValue()+"";
							break;
						}

						if(cell.getCellType()!= HSSFCell.CELL_TYPE_BLANK){
							
							if(this.isInTimeTable(rowindex, columnindex)){	// 기본 양식을 제외한 시간표 안일경우.
								
							// 시간 표 안에서 셀 내용이 비어있지 않을경우 ( 수업이 있을 경우 아래 코드를 실행 )
								this._xwb.makeSheet(rowindex, columnindex, Message.isRed, this._givenFile.getName()) ;
							}
							else{ // 시간표 밖
								this._xwb.makeSheet(rowindex, columnindex, value) ;
							}
						}
						else{
							this._xwb.makeSheet(rowindex, columnindex, Message.isGreen, this._givenFile.getName()) ;
						}

					} // if(cell!=null)
					System.out.println("각 셀 내용 :"+value);
					
				}	// for(column)
				
			}	// if(row!=null)
		}	// for(rowindex) 

	} // Read 메소드
	
	private boolean isInTimeTable(int rowindex, int columnindex){
		return ( rowindex>=2 && rowindex<=36 && columnindex>=1 ) ;
	}
	
}