package com.grudnov.lessons.exam.client_server_multithreading;

import java.io.IOException;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.ConcurrentSkipListSet;

public class ServerWriter implements Runnable {
    BlockingDeque messages;

    public ServerWriter(BlockingDeque messages) {
        this.messages = messages;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                Connection connection = (Connection)messages.take();
                connection.sendMessage(connection.getMessage());
                //connection.close();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}



