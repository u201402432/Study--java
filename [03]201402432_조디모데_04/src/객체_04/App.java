package ��ü_04;

import java.util.* ;

public class App {

	private int num ;	// ������ �����ϴ� ����

	public void run(){
		
		System.out.print("> ���α׷��� �����մϴ�.\n"
				+ "1~100 �� �ϳ��� ���ڸ� ���ߴ� ���� �Դϴ�.\n");

		while(true){

			while(true){
				
				char startChar ;
				System.out.print("������ �÷��� �Ͻðڽ��ϱ� (y/n) ? ");
				startChar = this.useScanner().next().charAt(0) ;
				if(startChar =='y')
					break ;
				else if(startChar == 'n'){
					System.out.println("���α׷��� �����մϴ�.");
					System.exit(0) ;
				}	// n�� �ԷµǾ��� ��� ���α׷��� ����
				else
					System.out.println("Error : �߸��� �Է��Դϴ�.");
			
			}
			
			System.out.println("\n������ �����մϴ�.\n"
					+ "...������ �����մϴ�");
			this.num = this.randomNum() ;
			
			for(int i=5 ; i>0 ; i--){
				int guess ;
				System.out.println("(��ȸ : "+i+"��) What is your guess ? ");
				try{
				guess = this.useScanner().nextInt() ;
				if(guess==num){
					System.out.println("�����Դϴ� !!");
					break ;
				}
				else if(guess==5576)
					System.out.println("Cheat : "+this.num) ;
				else if(guess>num)
					System.out.println("���ڰ� �ʹ� Ů�ϴ�.");
				else
					System.out.println("���ڰ� �ʹ� �۽��ϴ�.");
				
				}catch(Exception e){
					System.out.println("Error : �߸��� �Է��Դϴ�.\n"
							+ "��ȸ�� �ѹ� �Ҿ����ϴ�.");
				}
				
				if(i==1)
					System.out.println("�й��Ͽ����ϴ�.\n"
							+ "������ "+this.num+"�̾����ϴ�.\n");

			}

		}

	}

	private int randomNum(){
	// 1~100 �� ������ �ϳ��� �������� ��ȯ�ϴ� �޼ҵ�
		return (new Random().nextInt(100) + 1) ;
	}

	private Scanner useScanner(){
		// Scanner ����� ���� �޼ҵ�
		return new Scanner(System.in) ;
	}

}
