package Lab_2;
import java.math.* ;
public class main {
	
	static String[] shape = {"��Ʈ","Ŭ�ι�","�����̽�","���̾�"} ;
	
	public static void main (String[] args){

			System.out.println("ī�带 �̰ڽ��ϴ�.");
			int s = (int)(Math.random()*4) ;
			int n = (int)(Math.random()*10) +1 ;
			
			Card card = new Card(shape[s], n) ;
			
			System.out.println("���� ī���� ����� "+card.getShape()+" �̰�"
					+ "���ڴ� "+card.getValue()+"�Դϴ�.");
	
		
	}
}
