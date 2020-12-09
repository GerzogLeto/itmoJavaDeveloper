package com.grudnov.lessons.lesson26.hw_pizzeria;

import java.util.concurrent.ArrayBlockingQueue;

public class ThreadCook implements Runnable {


    private ArrayBlockingQueue<Order> orders2;
    private ArrayBlockingQueue<Order> orders3;

    public ThreadCook(ArrayBlockingQueue<Order> orders2, ArrayBlockingQueue<Order> orders3) {
        this.orders2 = orders2;
        this.orders3 = orders3;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            System.out.println("order getting from queue1 " + Thread.currentThread() );
            try {
                Thread.sleep(3000);
                System.out.println("Order was get from Queue2 ");
                System.out.println("Order put in Queue3 ");
                orders3.put(orders2.take());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
        }

    }
}
