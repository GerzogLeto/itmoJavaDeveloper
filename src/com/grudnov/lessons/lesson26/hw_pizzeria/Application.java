package com.grudnov.lessons.lesson26.hw_pizzeria;

import java.util.concurrent.ArrayBlockingQueue;

public class Application {
    public static void main(String[] args) {
        ArrayBlockingQueue<Order> queue_1 = new ArrayBlockingQueue<>(20, true);
        ArrayBlockingQueue<Order> queue_2 = new ArrayBlockingQueue<>(20, true);
        ArrayBlockingQueue<Order> queue_3 = new ArrayBlockingQueue<>(20, true);

        new Thread(new ThreadClient(queue_1)).start();
        new Thread(new ThreadClient(queue_1)).start();
        new Thread(new ThreadClient(queue_1)).start();
        new Thread(new ThreadOficant(queue_1, queue_2)).start();
        new Thread(new ThreadCook(queue_2, queue_3)).start();


    }
}
