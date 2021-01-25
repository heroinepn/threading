package com.company.demo03;
//测试join方法
public class TestJoin implements  Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("线程VIP"+i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        //启动线程
        Thread thread= new Thread(new TestJoin());
        thread.start();
        //主线程
        for (int i = 0; i < 300; i++) {
            if (i == 200) {
                thread.join();//插队
            }
            System.out.println("main"+i);
        }


    }
}
