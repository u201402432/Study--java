package Lab_2;
import java.math.* ;
public class main {
	
	static String[] shape = {"하트","클로버","스페이스","다이아"} ;
	
	public static void main (String[] args){

			System.out.println("카드를 뽑겠습니다.");
			int s = (int)(Math.random()*4) ;
			int n = (int)(Math.random()*10) +1 ;
			
			Card card = new Card(shape[s], n) ;
			
			System.out.println("뽑은 카드의 모양은 "+card.getShape()+" 이고"
					+ "숫자는 "+card.getValue()+"입니다.");
	
		
	}
}
