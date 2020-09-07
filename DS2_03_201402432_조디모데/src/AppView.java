import java.util.Scanner;
public class AppView {

	private Scanner _sc ;

	AppView(){
		this._sc = new Scanner(System.in) ;
	}

	public int inputNumber() {
		return this._sc.nextInt() ;
	}

	public void outputMessage(String MessageID){
		System.out.print(MessageID);
	}

	public void outputMessage(MessageID MessageID) { 
		switch(MessageID) {
		case Notice_StartProgram :
			this.outputMessage("[Notice] 프로그램을 시작합니다. \n");
			break ;
		case Notice_EndProgram :
			this.outputMessage("[Notice] 프로그램을 종료합니다. \n");
			break ;
		case Error_WrongEdge : 
			this.outputMessage("[Error] 입력 오류입니다. \n");
			break ;
		case Notice_ShowPath : 
			this.outputMessage("최단경로는 다음과 같습니다.\n");
			break ;
		default:
			break;
		}
		
	}
	
	public Edge inputEdge(int v1, int v2, int cost){
		return new DirectedEdge(v1, v2, cost) ;
	}

	public void outputShortestDistance(int tailVertex, int i) {
		this.outputMessage("Distance ["+tailVertex+"] = " + i + "\n" );
	}

	public void outputPrintPathFirst(Integer next) {
		System.out.print(next);
		
	}

	public void outputPrintPath(Integer next) {
		System.out.print(" - "+next);
	}

	
}
