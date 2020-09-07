package 객체_04;

import java.util.* ;

public class App {

	private int num ;	// 정답을 저장하는 변수

	public void run(){
		
		System.out.print("> 프로그램을 시작합니다.\n"
				+ "1~100 중 하나의 숫자를 맞추는 게임 입니다.\n");

		while(true){

			while(true){
				
				char startChar ;
				System.out.print("게임을 플레이 하시겠습니까 (y/n) ? ");
				startChar = this.useScanner().next().charAt(0) ;
				if(startChar =='y')
					break ;
				else if(startChar == 'n'){
					System.out.println("프로그램을 종료합니다.");
					System.exit(0) ;
				}	// n이 입력되었을 경우 프로그램을 종료
				else
					System.out.println("Error : 잘못된 입력입니다.");
			
			}
			
			System.out.println("\n게임을 시작합니다.\n"
					+ "...정답을 생성합니다");
			this.num = this.randomNum() ;
			
			for(int i=5 ; i>0 ; i--){
				int guess ;
				System.out.println("(기회 : "+i+"번) What is your guess ? ");
				try{
				guess = this.useScanner().nextInt() ;
				if(guess==num){
					System.out.println("정답입니다 !!");
					break ;
				}
				else if(guess==5576)
					System.out.println("Cheat : "+this.num) ;
				else if(guess>num)
					System.out.println("숫자가 너무 큽니다.");
				else
					System.out.println("숫자가 너무 작습니다.");
				
				}catch(Exception e){
					System.out.println("Error : 잘못된 입력입니다.\n"
							+ "기회를 한번 잃었습니다.");
				}
				
				if(i==1)
					System.out.println("패배하였습니다.\n"
							+ "정답은 "+this.num+"이었습니다.\n");

			}

		}

	}

	private int randomNum(){
	// 1~100 의 숫자중 하나를 무작위로 반환하는 메소드
		return (new Random().nextInt(100) + 1) ;
	}

	private Scanner useScanner(){
		// Scanner 사용을 위한 메소드
		return new Scanner(System.in) ;
	}

}
