package com.company.syn;

import java.util.concurrent.locks.ReentrantLock;

//测试lock锁
public class TestLock {
    public static void main(String[] args) {
        TestLock2 t2 = new TestLock2();
        TestLock2 t3 = new TestLock2();
        TestLock2 t4= new TestLock2();
        new Thread(t2,"a").start();
        new Thread(t3,"b").start();
        new Thread(t4,"c").start();
    }
}
class TestLock2 implements  Runnable{
    int ticketNums=10;
    //定义Lock锁
    private  final  ReentrantLock lock=new ReentrantLock();
    @Override
    public void run() {
        while (true){
            try {
                lock.lock();//加锁
                if (ticketNums >0) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(Thread.currentThread().getName()+ticketNums--);
                }else {
                    break;
                }
            }finally {
                //解锁
                lock.unlock();
            }

        }
    }
}