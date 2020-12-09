package com.grudnov.lessons.exam.client_server_multithreading;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class ClientSendMessage implements Runnable {
    @Override
    public void run() {
        String name;
        Scanner scanner = new Scanner(System.in);
        System.out.println("set name client: ");
        name = scanner.nextLine();
        String message;
        while (true){
            System.out.println("enter message: ");
            message = scanner.nextLine();
            send(SimpleMessage.getMessage(name, message, Thread.currentThread().getName()));
        }

    }
    private void send(SimpleMessage message){
        try(Connection connection = new Connection(new Socket("127.0.0.1", 8091))){
            connection.sendMessage(message);
            //System.out.println(connection.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
