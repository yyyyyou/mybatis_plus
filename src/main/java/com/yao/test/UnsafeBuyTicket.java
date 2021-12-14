package com.yao.test;

//线程不安全，买票重复
public class UnsafeBuyTicket {

    public static void main(String[] args) {
        BuyTicket buyTicket = new BuyTicket();


        new Thread(buyTicket, "我").start();
        new Thread(buyTicket, "你").start();
        new Thread(buyTicket, "他").start();
    }
}

class BuyTicket implements Runnable {
    //票
    private int ticket = 10;
    //外部停止标志
    boolean flag = true;


    @Override
    public void run() {
        //买票
        while (flag) {
            try {
                buy();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    //synchronized:同步方法，锁的是this
    public synchronized void buy() throws InterruptedException {
        if (ticket <= 0) {
            flag = false;
            return;
        }
        //模拟延时
        Thread.sleep(1000);

        System.out.println(Thread.currentThread().getName() + "买到" + ticket--);
    }
}