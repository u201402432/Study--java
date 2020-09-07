import java.util.* ;

public class AppView {

	private Scanner _sc ;

	public AppView(){
		this._sc = new Scanner(System.in) ;
	}

	public void showInputOrignalDataFileName(){

	}
	public void showInputResultDataFileName(){

	}
	public void showSortingResult(String orignalDataFileName, String resultDataFileName){
		System.out.println("END External Sort : " + orignalDataFileName+ " > " + resultDataFileName);
	}
	public void showMsg(String aString){
		System.out.println(aString);
	}
	public String inputString(){
		return this._sc.nextLine() ;
	}


	public void outputMessage(MessageID noticeStartprogram) {

		switch(noticeStartprogram){

		case Notice_StartProgram :
			System.out.println("< 외부정렬 프로그램을 시작합니다 >");
			break ;
		case Notice_ShowOriginalInput : 
			System.out.print("input origenal file name : ");
			break ;
		case Notice_ShowResultInput : 
			System.out.print("input result file neme : ");
			break ;
		case Notice_EndProgram :
			System.out.println("< 외부정렬 프로그램을 종료합니다 >");
			break ;

		default :
		}

	}

}
