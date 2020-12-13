package com.grudnov.lessons.exam.client_server_multithreading;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.util.concurrent.*;

public class Client {

    public static void main(String[] args) throws InterruptedException, IOException {
        BlockingDeque deque = new LinkedBlockingDeque(10) ;

        try  {
            Thread sendMessage = new Thread( new ClientSendMessage(deque));
            sendMessage.start();
            Thread getMessage = new Thread( new ClientGetMessage(deque));
            getMessage.start();
            sendMessage.join();
            getMessage.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
