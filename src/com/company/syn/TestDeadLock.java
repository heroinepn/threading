package com.company.syn;
//死锁：多个线程互相抱着对方需要的资源，形成僵持
public class TestDeadLock {
    public static void main(String[] args) {
        Makeup up1= new Makeup(0,"one");
        Makeup up2= new Makeup(1,"two");
        up1.start();
        up2.start();
    }
}
//口红
class Lipstick{}
//镜子
class Mirror{

}
class Makeup extends Thread{
    //需要的资源只有一份，用static来保证只有一份
    static Lipstick lipstick=new Lipstick();
    static Mirror mirror= new Mirror();
    int choice;//选择
    String name;//使用化妆品的人


    public Makeup( int choice,String name) {
        this.choice=choice;
        this.name=name;
    }
    public  void run(){
        //化妆
        try {
            makeup();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    //化妆，互相持有对方的锁，就是要拿到对方的资源
    private  void makeup() throws InterruptedException {
        if (choice == 0) {
            synchronized (lipstick){
                //获得口红的锁
                System.out.println(this.name+"获得口红的锁");
                    Thread.sleep(1000);
//                //1秒钟后获得镜子的锁
//                synchronized (mirror){
//                    System.out.println(this.name+"获得镜子的锁");
//                }
            }//放外面不卡锁
            synchronized (mirror){
                   System.out.println(this.name+"获得镜子的锁");
               }
        }else{
            synchronized (mirror){
                System.out.println(this.name+"获得镜子的锁");
                Thread.sleep(1000);
                //1秒钟后获得口红的锁
//            synchronized (lipstick){
//            //获得口红的锁
//            System.out.println(this.name+"获得口红的锁");
//
//
//            }
                synchronized (lipstick){
                    //获得口红的锁
                    System.out.println(this.name+"获得口红的锁");


                }
        }
    }
}}