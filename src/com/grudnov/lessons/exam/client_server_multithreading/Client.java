package com.grudnov.lessons.exam.client_server_multithreading;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

public class Client {

    public static void main(String[] args) throws InterruptedException, IOException {
        BlockingDeque deque = new LinkedBlockingDeque(1);
        try  {
            Thread sendMessage = new Thread( new ClientSendMessage(deque));
            sendMessage.setName("sendClientThread");
            sendMessage.start();
            Thread getMessage = new Thread( new ClientGetMessage(deque));
            getMessage.setName("getClientThread");
            getMessage.start();
            sendMessage.join();
            getMessage.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
