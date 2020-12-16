package com.grudnov.lessons.exam.client_server_multithreading;

import java.io.IOException;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.ConcurrentHashMap;

public class ServerReader implements Runnable {
    private Connection connection;
    private BlockingDeque messages;
    private ConcurrentHashMap<String, Connection> connections;
    private String sender;

    public ServerReader(Connection connection, BlockingDeque messages,
                        ConcurrentHashMap<String, Connection> connections) {
        this.connection = connection;
        this.messages = messages;
        this.connections = connections;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                SimpleMessage message = connection.getMessage();
                this.sender = message.getSender();
                connections.put(message.getSender(), connection);
                System.out.println(Thread.currentThread().getName() + " connection added to Map");
                    messages.put(message);
                    System.out.println(Thread.currentThread().getName() + " put message in queue");

            } catch (InterruptedException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt();
            } catch (IOException e) {
                //e.printStackTrace();
                try {
                    messages.put(SimpleMessage.getMessage(this.sender,"exit"));
                    connections.remove(sender);
                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                }
                Thread.currentThread().interrupt();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

        }
    }

}
