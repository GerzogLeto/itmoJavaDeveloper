package com.grudnov.lessons.exam.client_server_multithreading;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListSet;

public class ServerWriter implements Runnable {
    BlockingDeque messages;
    ConcurrentHashMap<String, Connection> connections;
    Connection connection;

    public ServerWriter(BlockingDeque messages, ConcurrentHashMap<String, Connection> connections, Connection connection) {
        this.messages = messages;
        this.connections = connections;
        this.connection = connection;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                SimpleMessage message = (SimpleMessage) messages.take();
                System.out.println(Thread.currentThread().getName() + " take message from queue");
                for (Map.Entry<String, Connection> entry : connections.entrySet()) {
                    if(!(entry.getKey().equals(message.getSender()))){
                        entry.getValue().sendMessage(message);
                        System.out.println(Thread.currentThread().getName() + " send message");
                    }
                }
                //connection.close();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
                Thread.currentThread().interrupt();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
}




