import java.util.Scanner;

public class game {
	
	public void run() {
		
		deck deal = new deck();
		deck play = new deck();

		while(true){
			deal.Reset(deal, play);
			this.start(deal, play);

			if(play.money<=0){
				System.out.println("��� ���� �����̽��ϴ�.");
				System.exit(0);
			}

		}

	}
	
	public void start(deck deal, deck play){
		deal.Reset(deal, play);
		
		Scanner sc = new Scanner(System.in);

		System.out.println("���� ������ : " + play.money);
		System.out.println("�÷��� �Ͻ÷��� 'start'�� �Է��ϼ���");
		String start = sc.next();
		if (start.equals("start")) {
			System.out.println();
			deal.draw(deal, play);
			deal.dealersCard(deal, play);
			deal.reDraw(play);
			deal.dealerRedraw(deal);
			deal.end(deal, play);
		} else {
			System.out.println("���α׷��� �����մϴ�.");
			System.exit(0);
		}

	}
	
}
