import java.util.Scanner;

public class game {
	
	public void run() {
		
		deck deal = new deck();
		deck play = new deck();

		while(true){
			deal.Reset(deal, play);
			this.start(deal, play);

			if(play.money<=0){
				System.out.println("모든 돈을 잃으셨습니다.");
				System.exit(0);
			}

		}

	}
	
	public void start(deck deal, deck play){
		deal.Reset(deal, play);
		
		Scanner sc = new Scanner(System.in);

		System.out.println("현재 소지금 : " + play.money);
		System.out.println("플레이 하시려면 'start'를 입력하세요");
		String start = sc.next();
		if (start.equals("start")) {
			System.out.println();
			deal.draw(deal, play);
			deal.dealersCard(deal, play);
			deal.reDraw(play);
			deal.dealerRedraw(deal);
			deal.end(deal, play);
		} else {
			System.out.println("프로그램을 종료합니다.");
			System.exit(0);
		}

	}
	
}
