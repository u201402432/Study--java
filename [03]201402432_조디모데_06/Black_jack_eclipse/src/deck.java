import java.util.Scanner;

public class deck {
	public static String[][] dec = { { "0", "0", "0", "0" },
		{ "1", "1", "1", "1" }, { "2", "2", "2", "2" },
		{ "3", "3", "3", "3" }, { "4", "4", "4", "4" },
		{ "5", "5", "5", "5" }, { "6", "6", "6", "6" },
		{ "7", "7", "7", "7" }, { "8", "8", "8", "8" },
		{ "9", "9", "9", "9" }, { "10", "10", "10", "10" },
		{ "J", "J", "J", "J" }, { "Q", "Q", "Q", "Q" },
		{ "K", "K", "K", "K" }, { "A", "A", "A", "A" } };
	// ���õ� ī�尡 �پ��� �׸�ŭ ������ ���� ī�尡 ���õ� Ȯ���� �پ���.

	static String[][] decReset ;
	int money, bet;
	String[] card;
	int total, cardNum ;
	int[] sum ;
	
	public deck(){

		this.decReset = dec.clone() ;
		this.money = 50000 ;
		this.card = new String[6] ;
		this.total = 0 ;
		this.cardNum = 2 ;
		this.sum = new int[6] ;
		
	}
	
	void Reset(deck deal, deck play) { // ���� �Ұ��.
		int reset=0 ; // ī�带 �� ����Ͽ��� ��� ���� �����.
		
		for(int i=0 ; i<dec.length ; i++){
			for(int j=0 ; j<dec[i].length ; j++){
				if(dec[i][j]!=null){
					reset ++ ;
				}
			}
		}

		if(reset>=8)
			dec = decReset.clone() ;
		
		deal.bet = -1;
		deal.cardNum = 2;
		play.cardNum = 2;
		deal.total = 0 ;
		play.total = 0 ;
	}

	void draw(deck deal, deck play) {

		for (int i = 0; i < 2; i++) {
			int card1 = (int) (Math.random() * 14 + 1);
			int card2 = (int) (Math.random() * 3 + 1);

			play.card[i] = dec[card1][card2];

			if (card1 <= 10) {
				play.sum[i] = card1;
			} else if (card1 == 14) {
				play.sum[i] = 11;
			} else {
				play.sum[i] = 10;
			}

			if (dec[card1][card2] == null)
				i--;

			dec[card1][card2] = null;
		}

		ifHaveA(play);

		int num = 0;

		System.out.print("���� ���� ī�� : ");

		for (int j = 0; j < play.cardNum; j++) {
			System.out.print(play.card[j] + " ");
		}
		for (int j = 0; j < play.cardNum; j++) {
			num += play.sum[j];
		}
		System.out.println("\n�� ī�� ���� �� : " + num);
		System.out.println();
		play.total = num;

	}

	void dealersCard(deck deal, deck play) { // ���� ù ī��, ���ñݾ� ����
		Scanner sc = new Scanner(System.in);

		for (int i = 0; i < 2; i++) {
			int card1 = (int) (Math.random() * 14 + 1);
			int card2 = (int) (Math.random() * 3 + 1);

			deal.card[i] = this.dec[card1][card2];

			deal.sum[i] = card1;
			deal.total += deal.sum[i];

			if (this.dec[card1][card2] == null)
				i--;

			this.dec[card1][card2] = null;
		}

		System.out.println("������ ���� ī�� : " + card[0] + " ? ");

		do {
			System.out.println("���� �ݾ��� �Է��� �ּ���. (�ּ� 100) ");
			play.bet = sc.nextInt();

		} while (play.bet > play.money || play.bet < 100);

		play.money -= play.bet;
	}

	void ifHaveA(deck who) {

		if (who.bet == -1) {
			// ������ A ī�带 ������ 11�� �����Ѵ�.
		} else {
			int a = 0, num = 0, select;
			Scanner sc = new Scanner(System.in);
			for (int i = 0; i < who.cardNum; i++) {
				if (who.sum[i] == 11)
					a++;
				else
					num += who.sum[i];
			}

			switch (a) {

			case 4:
				System.out.println("ī���߿� A�� �ֽ��ϴ�.");
				System.out.println((num + 4) + ", " + (num + 14));
				System.out.println("���° ���� �����ϰڽ��ϱ�? (1 or 2)");
				select = sc.nextInt();

				if (select == 1) {
					who.total = (num + 4);
					for (int i = 0; a > 0; i++) {
						if (who.sum[i] == 11) {
							who.sum[i] = 1;
							a--;
						}
					}
				} else {
					a = 3;
					for (int i = 0; a > 0; i++) {
						if (who.sum[i] == 11) {
							who.sum[i] = 1;
							a--;
						}
					}
				}
				break;
			case 3:
				System.out.println("ī���߿� A�� �ֽ��ϴ�.");
				System.out.println((num + 3) + ", " + (num + 13));
				System.out.println("���° ���� �����ϰڽ��ϱ�? (1 or 2)");
				select = sc.nextInt();

				if (select == 1) {
					for (int i = 0; a > 0; i++) {
						if (who.sum[i] == 11) {
							who.sum[i] = 1;
							a--;
						}
					}
				} else {
					a = 2;
					for (int i = 0; a > 0; i++) {
						if (who.sum[i] == 11) {
							who.sum[i] = 1;
							a--;
						}
					}
				}
				break;

			case 2:
				System.out.println("ī���߿� A�� �ֽ��ϴ�.");
				System.out.println((num + 2) + ", " + (num + 12));
				System.out.println("���° ���� �����ϰڽ��ϱ�? (1 or 2)");
				select = sc.nextInt();

				if (select == 1) {
					for (int i = 0; a > 0; i++) {
						if (who.sum[i] == 11) {
							who.sum[i] = 1;
							a--;
						}
					}
				} else {
					a = 1 ;
					for (int i = 0; a > 0; i++) {
						if (who.sum[i] == 11) {
							who.sum[i] = 1;
							a-- ;
						}
					}
				}

			case 1:
				System.out.println("ī���߿� A�� �ֽ��ϴ�.");
				System.out.println((num + 1) + ", " + (num + 11));
				System.out.println("���° ���� �����ϰڽ��ϱ�? (1 or 2) ");
				select = sc.nextInt();

				if (select == 1) {
					for (int i = 0; a > 0; i++) {
						if (who.sum[i] == 11) {
							who.sum[i] = 1;
							a--;
						}
					}
				}
				break;

			}
		}
	}

	void reDraw(deck who) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("ī�带 �� �������� draw �� �Է��ϼ���");
			String draw = sc.next();
			if (draw.equals("draw")) {
				int card1;
				int card2;
				System.out.println("ī�带 ���� �� �̽��ϴ�.");

				who.cardNum++;

				do {
					card1 = (int) (Math.random() * 14 + 1);
					card2 = (int) (Math.random() * 3 + 1);
				} while (this.dec[card1][card2] == null);

				who.card[who.cardNum - 1] = this.dec[card1][card2];
				this.dec[card1][card2] = null;

				if (card1 <= 10) {
					who.sum[who.cardNum - 1] = card1;
				} else if (card1 == 14) {
					who.sum[who.cardNum - 1] = 11;
				} else {
					who.sum[who.cardNum - 1] = 10;
				}

				ifHaveA(who);

				int num = 0;

				System.out.println("���� ���� ī�� : ");

				for (int j = 0; j < who.cardNum; j++) {
					System.out.print(who.card[j] + " ");
				}
				for (int j = 0; j < who.cardNum; j++) {
					num += who.sum[j];
				}
				System.out.println("�� ī�� ���� �� : " + num);
				System.out.println();
				who.total = num;
			} else {
				System.out.println("ī�带 �߰��� ���� �ʽ��ϴ�.");
				break;
			}
		}
	}

	void dealerRedraw(deck deal) {
		while (true) {
			int num = 0;
			for (int i = 0; i < deal.cardNum; i++) {
				num += deal.sum[i];
			}

			if (num >= 17) {
				System.out.println("������ ī�尪 : " + num);
				break;
			} else {
				int card1;
				int card2;
				System.out.println();
				System.out.println("������ ī�带 ���� �� �̽��ϴ�.");

				deal.cardNum++;

				do {
					card1 = (int) (Math.random() * 14 + 1);
					card2 = (int) (Math.random() * 3 + 1);
				} while (this.dec[card1][card2] == null);

				deal.card[deal.cardNum - 1] = this.dec[card1][card2];
				this.dec[card1][card2] = null;

				if (card1 <= 10) {
					deal.sum[deal.cardNum - 1] = card1;
				} else if (card1 == 14) {
					deal.sum[deal.cardNum - 1] = 11;
				} else {
					deal.sum[deal.cardNum - 1] = 10;
				}

				ifHaveA(deal);

				num = 0;
				System.out.print("������ ���� ī�� : ");
				for (int j = 0; j < deal.cardNum; j++) {
					System.out.print(deal.card[j] + " ");
				}
				for (int j = 0; j < deal.cardNum; j++) {
					num += deal.sum[j];
				}
				System.out.println();
				System.out.println("������ ī�� ���� �� : " + num);
				deal.total = num;
				System.out.println();
			}
		}
	}

	void end(deck deal, deck play) {

		findBlackJack(deal, play);

		if (deal.total > 21 && play.total > 21) {
			System.out.println("�÷��̾ �����ϴ�.\n");
		} else if (deal.total > 21 && play.total <= 21) {
			System.out.println("�÷��̾ �̰���ϴ�.\n");
			play.money += 2 * play.bet;
		} else if (deal.total <= 21 && play.total > 21) {
			System.out.println("�÷��̾ �����ϴ�.\n");
		} else if (deal.total <= 21 && play.total <= 21) {
			if (deal.total > play.total) {
				System.out.println("�÷��̾ �����ϴ�.\n");
			} else if (deal.total == play.total) {
				System.out.println("���º� �Դϴ�.\n");
				play.money += play.bet;
			} else {
				System.out.println("�÷��̾ �̰���ϴ�.\n");
				play.money += 2 * play.bet;
			}
		}
		System.out.println("�̹� ������ ��Ĩ�ϴ�.\n");
	}
	void findBlackJack(deck deal, deck play) {

		if (play.cardNum == 2 && play.total == 21 && deal.total != 21) {
			System.out.println("���� �Դϴ�. ���� �ݾ��� 1.5�踦 �޽��ϴ�.");
			play.money = play.money + (int) (play.bet * 0.5);
		}
	}
} // class