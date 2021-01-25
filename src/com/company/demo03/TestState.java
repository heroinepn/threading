package com.company.demo03;

import com.sun.javafx.scene.control.skin.TableHeaderRow;
//进入死亡不可重新启动
public class TestState {
    public static void main(String[] args) throws InterruptedException {
        Thread thread=new Thread(()->{
            for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("///");
        });


        //观察状态
        Thread.State state = thread.getState();
        System.out.println(state);//new

        //观察启动
        thread.start();
        state =thread.getState();
        System.out.println(state);//run

        while (state !=Thread.State.TERMINATED){
               // 只要线程不终止 就一直输出状态
            Thread.sleep(100);
            state=thread.getState();//更新线程状态
            System.out.println(state);
        }
    }

}
