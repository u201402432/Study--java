import java.io.File;
import java.io.IOException;
import javax.swing.JFileChooser;

public class Main {
	private static ExcelReader _excelreader ;
	private static XSSFworkbook _xwb ;

	public static void main(String[] args) throws IOException
	{
		// 읽어올 엑셀 파일을 선택할 수 있는 파일 열기 대화상자를 띄운다.
		JFileChooser fc = new JFileChooser();
		_xwb = new XSSFworkbook() ;

		for(int i=0 ; i<3 ; i++){
			if (fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
			{
				File file = fc.getSelectedFile();

				// 엑셀 파일을 문자열로 읽어온다.
				_excelreader = new ExcelReader(file, _xwb) ;
				_excelreader.read();

			}
		}		
		_xwb.outputXwb() ;

	}	// main

}	// class