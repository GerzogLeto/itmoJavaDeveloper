package com.grudnov.lessons.exam.client_server_multithreading;

import java.io.IOException;
import java.net.Socket;
import java.util.concurrent.BlockingDeque;

public class ClientGetMessage implements Runnable {
    private BlockingDeque deque;

    public ClientGetMessage(BlockingDeque deque) {
        this.deque = deque;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                Connection connection = (Connection) deque.take();
                System.out.println("thread: " + Thread.currentThread().getName() +
                        "\n" + connection.getMessage());
                connection.close();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}

