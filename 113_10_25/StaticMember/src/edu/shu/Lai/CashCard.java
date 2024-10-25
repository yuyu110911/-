package edu.shu.Lai;

public class CashCard {
    private String number;
    private int balance;
    private int bonus;
    private  final int BONUSCASH = 10;
    private static int cardOrder;
    //方法身份辨識 = 方法名稱 + 參數個數 + 參數型態
    public CashCard(){
        setNumber("unkonwn");
    }
    public CashCard(String number){
        setNumber(number);
        System.out.printf("第 %d 張卡%n", ++this.cardOrder);
    }

    public CashCard(String number,int balance){
        setNumber(number);
        setBalance(balance);
        System.out.printf("第 %d 張卡%n", ++this.cardOrder);
    }

    public CashCard(String number, int balance, int bonus) {
        setNumber(number);
        setBalance(balance);
        setBonus(bonus);
        System.out.printf("第 %d 張卡%n", ++this.cardOrder);
//        this.number = number;
//        this.balance = balance;
//        this.bonus = bonus;
    }



    public String getNumber(){
        return this.number;
    }

    public int getBalance(){
        return this.balance;
    }

    public int getBouns(){
        return this.bonus;
    }

    public void setNumber(String number){
        this.number = number;
    }


    public void setBalance(int balance) {
        if(balance > 0){
            this.balance = balance;
        }
        else{
            System.out.println("格式不符，保持原值");
        }
    }

    public void setBonus(int bonus) {
        if(bonus > 0){
            this.bonus = bonus;
        }
        else{
            System.out.println("格式不符，保持原值");
        }

    }

    //儲值
    public void store(int money){
        topUp(money);
    }

    public void store(String number,int money){
        if(this.number.equals(number)){
            if(money > 0){
                this.balance += money;
                if(money >= 1000){
                    this.bonus += money/1000;
                }
            }else {
                System.out.println("儲值金額為負，來亂的!");
            }
        }else {
            System.out.println("卡號不符");
        }
    }

    private void topUp(int money){
        if (money>0){
            this.balance += money;
            if(money >= 1000){
                this.bonus += money/1000;
            }
        } else{
            System.out.println("儲值金額為負，來亂的!");
        }
    }
    //扣款
    public void charge(String number, int money){
        if(this.number.equals(number)){
            deduction(money);
        }
        else{
            System.out.println("卡號不符");
        }
    }

    public void charge(String number, int money,int bonus){
        if(this.number.equals(number)){
            exchange(bonus);
            deduction(money);
        }
        else{
            System.out.println("卡號不符");
        }
    }

    private void deduction(int money){
        if (money > 0){
            if(money <= this.balance){
                this.balance -= money;
            }
            else {
                System.out.println("餘額不足，可憐啊!");
            }
        }
        else {
            System.out.println("扣除金額為負，來亂的!");
        }

    }

    public int exchange(int bouns){
        if(bouns >0 && this.bonus >= bouns){
            this.bonus -= bouns;
            setBalance(this.balance + bonus * BONUSCASH);
        }
        else{
            System.out.println("點數不足");
        }

        return this.bonus;
    }
}
