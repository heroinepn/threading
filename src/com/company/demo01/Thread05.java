package com.company.demo01;
//多个线程同时操作同一个对象
//买火车票的例子
//发现问题 多个线程操作同一个资源的情况下线程不安全，数据混乱
public class Thread05 implements Runnable{
    //票数
    private int TicketNums=100;


    @Override
    public void run() {
        while(true){
            if (TicketNums<=0) {
                break;
            }
            //模拟延迟
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"抢到"+TicketNums+"票");
        }
    }

    public static void main(String[] args) {
        Thread05 thread05 =new Thread05();

        new Thread(thread05,"one").start();
        new Thread(thread05,"two").start();
        new Thread(thread05,"three").start();

    }



}
