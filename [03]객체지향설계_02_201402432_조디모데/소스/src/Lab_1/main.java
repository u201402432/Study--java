package Lab_1;

public class main {
	
	static zoo[] z = new zoo[50];
	
	public static void main(String[] args) {
		
		for(int i=0 ; i<5 ; i++){
			z[i] = new zoo() ;
			z[i].run() ;
		}
		
		for(int i=0 ; i<5 ; i++){
			System.out.println(i+"��° ������ ���� �����Դϴ�.");
			z[i].printAnimal();
		}
			
		
	}
}
