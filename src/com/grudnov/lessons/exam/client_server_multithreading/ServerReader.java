package com.grudnov.lessons.exam.client_server_multithreading;

import java.io.IOException;
import java.net.Socket;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.LinkedBlockingDeque;

public class ServerReader implements Runnable {
    private Connection connection;
    BlockingDeque messages;

    public ServerReader(Connection connection, BlockingDeque messages) {
        this.connection = connection;
        this.messages = messages;
    }

    @Override
    public void run() {
        try {
            messages.put(connection.getMessage());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
