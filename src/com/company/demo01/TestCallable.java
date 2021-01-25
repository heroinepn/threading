package com.company.demo01;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.*;

//创建线程方式三：实现Callable方式
public class TestCallable implements Callable<Boolean > {
    private String url;//网络图片地址
    private String name;//保存的文件名
    public TestCallable(String url, String name){
        this.url=url;
        this.name=name;
    }
    // 下载图片的线程执行体
    @Override
    public Boolean call() {
        WebDownLoader2 webDownLoader2=new WebDownLoader2();
        webDownLoader2.downloader(url,name);
        System.out.println("下载文件名"+name);
        return true;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        TestCallable T01 = new TestCallable("https://img-blog.csdnimg.cn/2020041414382368.png","1.png");
        TestCallable T02 = new TestCallable("https://img-blog.csdnimg.cn/20200414144400444.png","2.png");
        TestCallable T03 = new TestCallable("https://img-blog.csdnimg.cn/20200414144828652.png","3.png");
        //创建执行服务：
         ExecutorService ser= Executors.newFixedThreadPool(3);
        //提交执行
        Future<Boolean> result1=ser.submit(T01);
        Future<Boolean> result2=ser.submit(T02);
        Future<Boolean> result3=ser.submit(T03);
       //获取结果:
         boolean r1=result1.get();
        boolean r2=result2.get();
        boolean r3=result3.get();

      //关闭服务
        ser.shutdownNow();




    }
}

// 下载器
class WebDownLoader2 {
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
