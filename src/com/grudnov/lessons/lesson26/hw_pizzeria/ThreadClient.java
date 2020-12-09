package com.grudnov.lessons.lesson26.hw_pizzeria;

import java.util.concurrent.ArrayBlockingQueue;

public class ThreadClient implements Runnable {
    private ArrayBlockingQueue<Order> orders1;

    public ThreadClient(ArrayBlockingQueue<Order> orders) {
        this.orders1 = orders;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            System.out.println("Client make order " + Thread.currentThread() );
            try {
                Thread.sleep(1000);
                orders1.put(new Order());
                System.out.println("Order was pass in Queue1 " + orders1);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
        }

    }
}
