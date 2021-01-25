package com.company.syn;
//不安全的取钱
//两个人去银行取钱
public class UnsafeBank {
    public static void main(String[] args) {
        Account account = new Account("投资基金",1000);
        Drawing boy=new Drawing(account,50,"a");
        Drawing girl=new Drawing(account,100,"b");
        boy.start();
        girl.start();
    }
}

//账户
class Account{
    int money;//余额
    String name;//卡名

    public Account(String name ,int money ) {
        this.name = name;
        this.money = money;
    }

}
//银行：模拟取钱
class Drawing extends Thread{
    Account account;//账户
    int drawingMoney;//取了多少钱
    int nowMoney;//剩余多少钱
    public Drawing(Account account,int drawingMoney, String name){
        super(name);
        this.account=account;
        this.drawingMoney=drawingMoney;

    }
    //取钱


    @Override
    public  void run() {
        //锁的对象就是变化的量，需要增删改
        synchronized (account){
            //判断是否有钱
            if (account .money-drawingMoney<0) {
                System.out.println(Thread.currentThread().getName()+"钱不够");
                return;
            }
            //模拟延迟 sleep放大问题的发生性
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //卡内余额
            account.money=account.money-drawingMoney;
            //手里的钱
            nowMoney=+drawingMoney;
            System.out.println(account.name+"余额为"+account.money);
            //this.getName()==Thread.currentThread().getName()
            System.out.println(this.getName()+"手里的钱"+nowMoney);
        }

    }
}