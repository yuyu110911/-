package edu.shu.main;
import java.util.Scanner;
import edu.shu.Lai.*;

public class CardApp {
    public static void main(String[] args) {
        CashCard[] cards = {
                new CashCard("A001", 50),
                new CashCard("A002", 300),
                new CashCard("A003", 5000, 1),
                new CashCard("A003"),
                //new CashCard("A004", 2000, 2),
                //new CashCard("A005", 3000, 3)
        };

        Scanner input = new Scanner(System.in);

//        for(var card : cards) {
//            System.out.printf("為(%s, %d, %d)儲值",
//                    card.getNumber(), card.getBalance(), card.getBouns());
//
//            card.store(input.nextInt());
//            //card.balance += input.nextInt();
//
//            System.out.printf("明細(%s, %d, %d)%n",
//                    card.getNumber(), card.getBalance(), card.getBouns());
//        }
        for(int i=0; i < cards.length; i++){
            System.out.printf("為(%s, %d, %d)儲值",
                    cards[i].getNumber(), cards[i].getBalance(), cards[i].getBouns());
            if ( i % 2 == 0){
                cards[i].store(input.nextInt());
                //cards[i].balance += input.nextInt();

            }
            else {
                cards[i].store(input.nextInt());
                //card.balance += input.nextInt();
            }
            System.out.printf("明細(%s, %d, %d)%n",
                    cards[i].getNumber(), cards[i].getBalance(), cards[i].getBouns());
        }

        cards[1].charge("A002",500);
        System.out.printf("明細(%s, %d, %d)%n",
                cards[1].getNumber(), cards[1].getBalance(), cards[1].getBouns());
        cards[1].charge("A002",100,1);
        System.out.printf("明細(%s, %d, %d)%n",
                cards[1].getNumber(), cards[1].getBalance(), cards[1].getBouns());


    }
}