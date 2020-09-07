import java.io.File;
import java.io.IOException;
import javax.swing.JFileChooser;

public class Main {
	private static ExcelReader _excelreader ;
	private static XSSFworkbook _xwb ;

	public static void main(String[] args) throws IOException
	{
		// �о�� ���� ������ ������ �� �ִ� ���� ���� ��ȭ���ڸ� ����.
		JFileChooser fc = new JFileChooser();
		_xwb = new XSSFworkbook() ;

		for(int i=0 ; i<3 ; i++){
			if (fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
			{
				File file = fc.getSelectedFile();

				// ���� ������ ���ڿ��� �о�´�.
				_excelreader = new ExcelReader(file, _xwb) ;
				_excelreader.read();

			}
		}		
		_xwb.outputXwb() ;

	}	// main

}	// class