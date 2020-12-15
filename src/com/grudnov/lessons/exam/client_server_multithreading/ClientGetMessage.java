package com.grudnov.lessons.exam.client_server_multithreading;

import java.io.IOException;
import java.net.Socket;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.TransferQueue;

public class ClientGetMessage implements Runnable {
    private ConcurrentSkipListSet set;

    public ClientGetMessage(ConcurrentSkipListSet set) {
        this.set = set;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                for (Object connection : set) {
                    Connection connection1  =(Connection)connection;
                    SimpleMessage message = connection1.getMessage();
                    System.out.println(message);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}

