package com.grudnov.lessons.lesson26.hw_pizzeria;

import java.util.concurrent.ArrayBlockingQueue;

public class ThreadOficant implements Runnable {

    private ArrayBlockingQueue<Order> orders1;
    private ArrayBlockingQueue<Order> orders2;

    public ThreadOficant(ArrayBlockingQueue<Order> orders1,ArrayBlockingQueue<Order> orders2 ) {
        this.orders1 = orders1;
        this.orders2 = orders2;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            System.out.println("order getting from queue1 " + Thread.currentThread() );
            try {
                Thread.sleep(500);
                System.out.println("Order was get from Queue1 ");
                System.out.println("Order put in Queue2 ");
                orders2.put(orders1.take());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
        }

    }
}
