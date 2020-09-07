package oop_06.black_jeck;

public class Deck {
    public static String[][] dec = { { "0", "0", "0", "0" },
            { "1", "1", "1", "1" }, { "2", "2", "2", "2" },
            { "3", "3", "3", "3" }, { "4", "4", "4", "4" },
            { "5", "5", "5", "5" }, { "6", "6", "6", "6" },
            { "7", "7", "7", "7" }, { "8", "8", "8", "8" },
            { "9", "9", "9", "9" }, { "10", "10", "10", "10" },
            { "J", "J", "J", "J" }, { "Q", "Q", "Q", "Q" },
            { "K", "K", "K", "K" }, { "A", "A", "A", "A" } };
    // 선택된 카드가 줄어들면 그만큼 이전에 뽑힌 카드가 선택될 확줄이 줄어든다.

    static String[][] decReset ;
    int money, bet;
    String[] card;
    int total, cardNum ;
    int[] sum ;
    private AppView view ;
    public Deck(AppView view){
        this.view = view ;
        this.decReset = dec.clone() ;
        this.money = 50000 ;
        this.card = new String[6] ;
        this.total = 0 ;
        this.cardNum = 2 ;
        this.sum = new int[6] ;

    }

    void Reset(Deck deal, Deck play) { // 재경기 할경우.
        int reset=0 ; // 카드를 다 사용하였을 경우 새로 만든다.

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

    void draw(Deck deal, Deck play) {

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

        this.view.printString("내가 뽑은 카드 : ");

        for (int j = 0; j < play.cardNum; j++) {
            this.view.printString(play.card[j] + " ");
        }
        for (int j = 0; j < play.cardNum; j++) {
            num += play.sum[j];
        }
        this.view.printString("\n내 카드 수의 합 : " + num);
        this.view.printString("\n");
        play.total = num;

    }

    void dealersCard(Deck deal, Deck play) { // 딜러 첫 카드, 베팅금액 설정

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

        this.view.printString("딜러가 뽑은 카드 : " + card[0] + " ? ");

        do {
            this.view.printString("베팅 금액을 입력해 주세요. (최소 100) ");
            play.bet = Integer.parseInt(view.scanString()) ;

        } while (play.bet > play.money || play.bet < 100);

        play.money -= play.bet;
    }

    void ifHaveA(Deck who) {

        if (who.bet == -1) {
            // 딜러는 A 카드를 무조건 11로 간주한다.
        } else {
            int a = 0, num = 0, select;
            for (int i = 0; i < who.cardNum; i++) {
                if (who.sum[i] == 11)
                    a++;
                else
                    num += who.sum[i];
            }

            switch (a) {

                case 4:
                    this.view.printString("카드중에 A가 있습니다.");
                    this.view.printString((num + 4) + ", " + (num + 14));
                    this.view.printString("몇번째 값을 선택하겠습니까? (1 or 2)");
                    select = Integer.parseInt(view.scanString()) ;

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
                    this.view.printString("카드중에 A가 있습니다.");
                    this.view.printString((num + 3) + ", " + (num + 13));
                    this.view.printString("몇번째 값을 선택하겠습니까? (1 or 2)");
                    select = Integer.parseInt(view.scanString()) ;

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
                    this.view.printString("카드중에 A가 있습니다.");
                    this.view.printString((num + 2) + ", " + (num + 12));
                    this.view.printString("몇번째 값을 선택하겠습니까? (1 or 2)");
                    select = Integer.parseInt(view.scanString()) ;

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
                    this.view.printString("카드중에 A가 있습니다.");
                    this.view.printString((num + 1) + ", " + (num + 11));
                    this.view.printString("몇번째 값을 선택하겠습니까? (1 or 2) ");
                    select = Integer.parseInt(view.scanString()) ;

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

    void reDraw(Deck who) {
        while (true) {
            this.view.printString("카드를 더 뽑으려면 draw 를 입력하세요");
            String draw = view.scanString() ;
            if (draw.equals("draw")) {
                int card1;
                int card2;
                this.view.printString("카드를 한장 더 뽑습니다.");

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

                this.view.printString("내가 뽑은 카드 : ");

                for (int j = 0; j < who.cardNum; j++) {
                    this.view.printString(who.card[j] + " ");
                }
                for (int j = 0; j < who.cardNum; j++) {
                    num += who.sum[j];
                }
                this.view.printString("내 카드 수의 합 : " + num);
                this.view.printString("\n");
                who.total = num;
            } else {
                this.view.printString("카드를 추가로 뽑지 않습니다.");
                break;
            }
        }
    }

    void dealerRedraw(Deck deal) {
        while (true) {
            int num = 0;
            for (int i = 0; i < deal.cardNum; i++) {
                num += deal.sum[i];
            }

            if (num >= 17) {
                this.view.printString("딜러의 카드값 : " + num);
                break;
            } else {
                int card1;
                int card2;
                this.view.printString("\n");
                this.view.printString("딜러가 카드를 한장 더 뽑습니다.");

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
                this.view.printString("딜러가 뽑은 카드 : ");
                for (int j = 0; j < deal.cardNum; j++) {
                    this.view.printString(deal.card[j] + " ");
                }
                for (int j = 0; j < deal.cardNum; j++) {
                    num += deal.sum[j];
                }

                this.view.printString("딜러의 카드 수의 합 : " + num);
                deal.total = num;

            }
        }
    }

    void end(Deck deal, Deck play) {

        findBlackJack(deal, play) ;

        if (deal.total > 21 && play.total > 21) {
            this.view.printString("플레이어가 졌습니다.\n");
        } else if (deal.total > 21 && play.total <= 21) {
            this.view.printString("플레이어가 이겼습니다.\n");
            play.money += 2 * play.bet;
        } else if (deal.total <= 21 && play.total > 21) {
            this.view.printString("플레이어가 졌습니다.\n");
        } else if (deal.total <= 21 && play.total <= 21) {
            if (deal.total > play.total) {
                this.view.printString("플레이어가 졌습니다.\n");
            } else if (deal.total == play.total) {
                this.view.printString("무승부 입니다.\n");
                play.money += play.bet;
            } else {
                this.view.printString("플레이어가 이겼습니다.\n");
                play.money += 2 * play.bet;
            }
        }
        this.view.printString("이번 게임을 마칩니다.\n");
    }
    void findBlackJack(Deck deal, Deck play) {

        if (play.cardNum == 2 && play.total == 21 && deal.total != 21) {
            this.view.printString("블랙잭 입니다. 배팅 금액의 1.5배를 받습니다.");
            play.money = play.money + (int) (play.bet * 2.5);
        }
    }
} // class