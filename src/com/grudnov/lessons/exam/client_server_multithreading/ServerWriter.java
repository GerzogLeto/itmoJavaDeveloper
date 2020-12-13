package com.grudnov.lessons.exam.client_server_multithreading;

import java.io.IOException;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.ConcurrentSkipListSet;

public class ServerWriter implements Runnable {
    BlockingDeque messages;
    ConcurrentSkipListSet<Connection> connections;

    public ServerWriter(BlockingDeque messages,ConcurrentSkipListSet<Connection> connections) {
        this.messages = messages;
        this.connections = connections;
    }

    @Override
    public void run() {
            try {
                SimpleMessage message = (SimpleMessage)messages.take();
                for (Connection connection : connections) {
                    connection.sendMessage(message);
                }
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




