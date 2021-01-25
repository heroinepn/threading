package com.company.demo03;
//测试守护线程

public class TestDaemon {

    public static void main(String[] args) {
        Country country = new Country();
        Me me = new Me();
        Thread thread = new Thread(country);
        thread.setDaemon(true);//默认false表示用户线程 正常的线程都是用户线程
        thread.start();//守护线程启动
        new Thread(me).start();//用户线程启动

    }
}

//国家
class Country implements  Runnable{

    @Override
    public void run() {
        while (true){
            System.out.println("守护每一天");
        }
    }
}
//我
class Me implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 36500; i++) {
            System.out.println("每天被守护");
        }
        System.out.println("谢谢");
    }
}