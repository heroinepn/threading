package com.company.demo02;

/**
 * 推导lamda表达式
 */
public class TestLamda01 {

    //3.静态内部类
    static class Olike2 implements Ilike {
        public void lamda() {
            System.out.println("two lamda");
        }
    }

    public static void main(String[] args) {
        Ilike ilike = new Olike();
        ilike.lamda();
        ilike = new Olike2();
        ilike.lamda();

        //4.局部内部类
        class Olike3 implements Ilike {
            public void lamda() {
                System.out.println("three lamda");
            }
        }
        ilike = new Olike3();
        ilike.lamda();
        //5.匿名内部类,没有类的名称必须借助接口或者父类
        ilike = new Ilike(){
        public void lamda(){
            System.out.println("four lamda");
        }

    }; ilike.lamda();
    //6.lamda简化
        ilike=()->{
            System.out.println("five lamda");

        };ilike.lamda();
    }
}

//1.定义一个函数式接口
interface Ilike {
    void lamda();
}

//2.实现类
class Olike implements Ilike {

    @Override
    public void lamda() {
        System.out.println("one lamda");
    }
}
//3.