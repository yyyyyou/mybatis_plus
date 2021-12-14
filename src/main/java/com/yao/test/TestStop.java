package com.yao.test;

public class TestStop implements Runnable {

    //设置一个标识符
    private boolean flag = true;

    @Override
    public void run() {
        int i = 0;
        while (flag) {
            System.out.println("run...Thread" + i++);
        }
    }

    //设置一个公开的方法，更改标识符
    public void stop() {
        this.flag = false;
    }

    public static void main(String[] args) {
        TestStop testStop = new TestStop();
        new Thread(testStop).start();

        for (int i = 0; i < 1000; i++) {
            System.out.println("main" + i);
            if (i == 900) {
                //调用stop方法，切换标志位，让线程停止
                testStop.stop();
                System.out.println("线程停止了~");
            }
        }
    }
}