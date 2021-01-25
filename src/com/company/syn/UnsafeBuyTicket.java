package com.company.syn;
//不安全买票,买到负票
public class UnsafeBuyTicket {
    public static void main(String[] args) {
        BuyTicket buyTicket = new BuyTicket();
        new Thread(buyTicket,"a").start();
        new Thread(buyTicket,"b").start();
        new Thread(buyTicket,"c").start();

    }
}

class BuyTicket implements Runnable{
    //票
    private int ticketNums=10;
    boolean flag=true;//外部停止方式
    @Override
    public void run() {
        //买票

        while (flag){
            try {
                buy();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }//锁 this本身
    private synchronized void buy() throws InterruptedException {
        //判断是否有票
        if (ticketNums <=0) {
            flag=false;
            return;
        }
        //模拟延迟
        Thread.sleep(100);
        //买票
        System.out.println(Thread.currentThread().getName()+"拿到"+ticketNums--);
    }
}