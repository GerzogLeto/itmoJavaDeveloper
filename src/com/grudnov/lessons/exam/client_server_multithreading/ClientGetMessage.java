package com.grudnov.lessons.exam.client_server_multithreading;

import java.io.IOException;
import java.net.Socket;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.TransferQueue;

public class ClientGetMessage implements Runnable {
    private TransferQueue deque;

    public ClientGetMessage(TransferQueue deque) {
        this.deque = deque;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                System.out.println(((Connection)deque.take()).getMessage());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}

