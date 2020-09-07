import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;


// Apache POI , jar archives download : http://poi.apache.org/download.html

public class ExcelReader{
	
	private XSSFworkbook _xwb ;	// ����� �Ź��� ���� workbook
	private FileInputStream _fis ;	// ���� file�� inputStream
	private File _givenFile ;	// ���� ���� file
	private HSSFWorkbook _hwb ;		// ���� ���� file�� workbook
	
	public ExcelReader(File file, XSSFworkbook xwb){
		this._xwb = xwb ;
		// ���� 07�⵵ �������� ���� XSSFWorkbook�� �̿��� ���� ���� ����
		
		this._givenFile = file ;
	}
	
	@SuppressWarnings("deprecation")
	public void read() throws IOException{
			
		//������ �б����� ���������� �����´� 
		this._fis = new FileInputStream(this._givenFile) ;
		this._hwb = new HSSFWorkbook(this._fis) ;
		
		int rowindex = 0 ;
		int columnindex = 0 ;

		//��Ʈ �� (ù��°���� �����ϹǷ� 0�� �ش�)
		//���� �� ��Ʈ�� �б����ؼ��� FOR���� �ѹ��� �����ش�
		HSSFSheet sheet=this._hwb.getSheetAt(0);
		
		//���� ��
		int rows = sheet.getPhysicalNumberOfRows();
		
		for(rowindex = 0 ; rowindex<rows ; rowindex++){
			
			//���� �д´�
			HSSFRow row=sheet.getRow(rowindex);
			
			if(row !=null){				
				//���� ��
				int cells = row.getPhysicalNumberOfCells() ;

				for(columnindex = 0 ; columnindex<=cells ; columnindex++){
					//������ �д´�
					HSSFCell cell=row.getCell((short) columnindex);
					String value="";
					
					//���� ���ϰ�츦 ���� ��üũ
					if(cell==null)
						continue;
					else{
						//Ÿ�Ժ��� ���� �б�
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
							
							if(this.isInTimeTable(rowindex, columnindex)){	// �⺻ ����� ������ �ð�ǥ ���ϰ��.
								
							// �ð� ǥ �ȿ��� �� ������ ������� ������� ( ������ ���� ��� �Ʒ� �ڵ带 ���� )
								this._xwb.makeSheet(rowindex, columnindex, Message.isRed, this._givenFile.getName()) ;
							}
							else{ // �ð�ǥ ��
								this._xwb.makeSheet(rowindex, columnindex, value) ;
							}
						}
						else{
							this._xwb.makeSheet(rowindex, columnindex, Message.isGreen, this._givenFile.getName()) ;
						}

					} // if(cell!=null)
					System.out.println("�� �� ���� :"+value);
					
				}	// for(column)
				
			}	// if(row!=null)
		}	// for(rowindex) 

	} // Read �޼ҵ�
	
	private boolean isInTimeTable(int rowindex, int columnindex){
		return ( rowindex>=2 && rowindex<=36 && columnindex>=1 ) ;
	}
	
}