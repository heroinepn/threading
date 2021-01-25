package com.company.demo03;

import com.company.demo01.Thread05;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.SimpleFormatter;

//模拟网络延迟 放大问题发生性
//模拟倒计时
public class TestSleep {
    public static void main(String[] args) {
        //打印当前系统时间
        Date startTime=new Date(System.currentTimeMillis());
        while (true){
            try {

                Thread.sleep(1000);
                System.out.println(new SimpleDateFormat("HH:mm:ss").format(startTime));
                startTime=new Date(System.currentTimeMillis());
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }

//        try {
//            tenDown();
//        }catch (InterruptedException e){
//            e.printStackTrace();
//        }
    }
    public static void tenDown() throws InterruptedException {
        int num=10;

       while (true){
           Thread.sleep(1000);
           System.out.println("num"+num--);
           if (num <=0) {
               break;
           }
       }



    }
}

