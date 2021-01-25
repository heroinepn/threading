package com.company.demo02;
//代理模式
/*
* 1.真实对象和代理对象都要实现同一个接口
* 2.代理对象代理真实对象
* 3.代理对象扩展真实对象功能
* */
public class StaticProxy {
    public static void main(String[] args) {
        like l1= new like(new me());
        l1.One();

//        me m1=new me();
//        new Thread(()-> System.out.println("test")).start();
//        new like(new me()).One();
    }

}

interface Fill {
    void One();
}

//真是角色
class me implements Fill {
    public void One() {
        System.out.println("one");

    }

}

//代理角色
class like implements Fill {
    //代理对象代理真实对象
    private Fill target;

    public like(Fill target) {
        this.target = target;
    }

    public void One() {
        before();
        this.target.One();//真实对象
        after();
    }
    private  void after(){
        System.out.println("之后");
    }
    private  void before(){
        System.out.println("开始之前");
    }
}