package com.grudnov.lessons.exam.client_server_multithreading;

import java.io.IOException;
import java.net.Socket;

public class ClientGetMessage implements Runnable {
    @Override
    public void run() {
        while(true){
            try(Connection connection = new Connection(new Socket("127.0.0.1", 8091))){
                System.out.println("thread: " + Thread.currentThread().getName()+
                        "\n" + connection.getMessage());
            } catch (IOException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
        }
        }
    }

}

