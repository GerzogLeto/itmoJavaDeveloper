package com.grudnov.lessons.exam.client_server_multithreading;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.TransferQueue;

public class ClientSendMessage implements Runnable {
    private BlockingDeque deque;

    public ClientSendMessage(BlockingDeque deque) {
        this.deque = deque;
    }

    @Override
    public void run() {
        String name;
        Scanner scanner = new Scanner(System.in);
        System.out.println("set name client: ");
        name = scanner.nextLine();
        String message;
        while (!Thread.currentThread().isInterrupted()){
            try{
                System.out.println("enter message: ");
                message = scanner.nextLine();
                send(SimpleMessage.getMessage(name, message));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
        }

    }
    private void send(SimpleMessage message) throws InterruptedException {
        try {
            Connection connection = new Connection(new Socket("127.0.0.1", 8094));
            connection.sendMessage(message);
            deque.put(connection);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //System.out.println(connection.getMessage());
    }

}
