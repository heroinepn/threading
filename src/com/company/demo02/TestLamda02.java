package com.company.demo02;
//lamda表达式只能有一行代码简化，多行用代码块 函数式接口专用
public class TestLamda02 {
    public static void main(String[] args) {
//        Ilove ilove=(int a)->{
//            System.out.println(" lamda"+a);
//
//        };
//        ilove.love(2);
//        //1.简化去掉参数类型 去掉完 a,b,c... 但必须加上括号 没有类的名称必须借助接口或者父类
//         ilove=( a)->{
//            System.out.println(" lamda"+a);
//
//        };
//        ilove.love(3);
//        //2.去掉括号
//        ilove=a -> {
//            System.out.println(" lamda"+a);
//
//        }; ilove.love(4);
//        //3.去掉花括号
//        ilove=a -> System.out.println(" lamda"+a); ilove.love(5);

        Ilove  ilove=a -> System.out.println(" lamda"+a); ilove.love(6);
    }
}
interface  Ilove{
    void love(int a);
}