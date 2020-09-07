
import java.util.Scanner;

public class AppView {
	
	private Scanner _sc ;
	
	AppView(){
		this._sc = new Scanner(System.in) ;
	}
	
	public int inputInt(){
		return this._sc.nextInt() ;
	}
	
	public int inputMaxDataSize(){
		this.outputMessage("Insert Max Data Size >> ");
		return this._sc.nextInt() ;
	}
	
	public int inputSortType() {
		this.outputMessage("Select a Sort >> ");
		return this._sc.nextInt() ;
	}
	
	public int inputDataTerm() {
		this.outputMessage("Insert Data Term >> ");
		return this._sc.nextInt() ;
	}
	
	public void outputResult(int dataSize, double InsertionSortDuration,
			double QuickSortDuration, double HeapSortDuration,
			double BubbleSortDuration) {
		
		String str = dataSize+"\t\t"+(int)InsertionSortDuration+"\t\t"+(int)QuickSortDuration
					 +"\t\t"+(int)HeapSortDuration+"\t\t"+(int)BubbleSortDuration ;
		
		this.outputMessage(str) ;
	}
	
	public void outputMessage (String aMessageString) { 
		System.out.print(aMessageString);
	}


	
	
	
}
