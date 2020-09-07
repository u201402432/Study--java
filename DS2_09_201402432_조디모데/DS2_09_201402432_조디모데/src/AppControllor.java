import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

public class AppControllor {

	static int N = 2000000; // size of the file in disk
	static int M = 100000; // max items the memory buffer can hold
	private AppView _appView;
	private ExternalSort _externalSort;

	public AppControllor(){

	}
	
	public void run(){
		this._appView= new AppView();
		this._externalSort= new ExternalSort(N, M);
		this._appView.outputMessage(MessageID.Notice_StartProgram);
		this._appView.outputMessage(MessageID.Notice_ShowOriginalInput);
		String orignalDataFileName= this.generateInput(N, this._appView.inputString());
		this._appView.outputMessage(MessageID.Notice_ShowResultInput);
		String resultDataFileName= this._appView.inputString();
		_externalSort.externalSort(orignalDataFileName,resultDataFileName);
		this._appView.showSortingResult(orignalDataFileName, resultDataFileName);
		this._appView.outputMessage(MessageID.Notice_EndProgram);
	}
	
	private String generateInput(int n, String inputString){
		Random r = new Random() ;
		FileWriter fileWriter ;
		
		try{
			
			fileWriter = new FileWriter (inputString+".txt") ;
			
			for(int i=0 ; i<n ; i++)
				fileWriter.write(Integer.toString( r.nextInt(2000000) ) +"\n" ) ;
			
		}catch(Exception e){
			System.out.println(e.getMessage()) ;
		}
	
		return inputString+".txt" ;
	}

}
