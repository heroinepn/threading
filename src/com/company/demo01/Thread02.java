package com.company.demo01;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

//实现多线程同步下载图片
public class Thread02 extends Thread{
    private String url;//网络图片地址
    private String name;//保存的文件名
    public Thread02(String url, String name){
        this.url=url;
        this.name=name;
    }
    // 下载图片的线程执行体
    @Override
    public void run() {
        WebDownLoader webDownLoader=new WebDownLoader();
        webDownLoader.downloader(url,name);
        System.out.println("下载文件名"+name);
    }

    public static void main(String[] args) {
        Thread02 thread01 = new Thread02("https://img-blog.csdnimg.cn/2020041414382368.png","1.png");
        Thread02 thread02 = new Thread02("https://img-blog.csdnimg.cn/20200414144400444.png","2.png");
        Thread02 thread03 = new Thread02("https://img-blog.csdnimg.cn/20200414144828652.png","3.png");
       //同时下载 交替下载，不按照顺序
        thread01.start();
        thread02.start();
        thread03.start();



    }
}

// 下载器
class WebDownLoader {
    //下载方法
    public void downloader(String url, String name) {
        try {
            //网页上的地址变成文件
            FileUtils.copyURLToFile(new URL(url), new File(name));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("IO异常downloader方法出现问题");
        }
    }
}