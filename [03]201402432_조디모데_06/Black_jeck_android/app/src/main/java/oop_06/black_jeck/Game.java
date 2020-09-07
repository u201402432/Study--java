package oop_06.black_jeck;

import android.view.View;

public class Game {
    private AppView v ;
    public Game(AppView v){
        this.v = v ;
    }

    public void run() {

        Deck deal = new Deck(v);
        Deck play = new Deck(v);

        while(true){
            deal.Reset(deal, play);
            start(deal, play);

            if(play.money<=0){
                this.v.printString("모든 돈을 잃으셨습니다.");
                System.exit(0);
            }

        }

    }

    public void start(Deck deal, Deck play) {

        deal.Reset(deal, play);

        this.v.printString("현재 소지금 : " + play.money);
        this.v.printString("플레이 하시려면 'start'를 입력하세요");
        String start ;

        start = v.scanString();
        if (start.equals("start")) {
            this.v.printString("\n");
            deal.draw(deal, play);
            deal.dealersCard(deal, play);
            deal.reDraw(play);
            deal.dealerRedraw(deal);
            deal.end(deal, play);
        } else {
            this.v.printString("프로그램을 종료합니다.");
            System.exit(0);
        }

    }

}
