package com.company.demo01;
// 线程开启不一定立即执行，由cpu调度执行
// 创建线程方式一：继承Thread类，重新Run()方法,调用Start开启线程
public class Thread01 extends Thread {
    public void run() {
        //run 方法线程体
        for (int i = 0; i < 30; i++) {
            System.out.println("test01" + i);
        }
    }


    public static void main(String[] args) {
        // 主线程
        //调用start()方法开启线程
        Thread01 thread01 = new Thread01();
        thread01.start();//交替执行
        //thread01.run();先执行

        for (int i = 0; i < 30; i++) {
            System.out.println("test02" + i);
        }
    }
}
