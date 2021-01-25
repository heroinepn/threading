package com.company.demo01;


//创建线程方式2：实现Runnable接口重写run()方法，执行线程需要接入Runnable接口实现类，调用start方法
public class Thread03 implements Runnable {
    public void run() {
        //run 方法线程体
        for (int i = 0; i < 30; i++) {
            System.out.println("t1" + i);
        }
    }


    public static void main(String[] args) {
        // 主线程
        //创建Runnable接口的实现类对象
        Thread03 thread03 = new Thread03();
        //创建线程对象，通过线程对象开启线程
//        Thread thread = new Thread(Thread03);
//        thread.start();//交替执行
            new Thread(thread03).start();

        for (int i = 0; i < 30; i++) {
            System.out.println("t2" + i);
        }
    }
}
