package com.grudnov.lessons.exam.client_server_multithreading;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.util.concurrent.*;

public class Client {

    public static void main(String[] args) throws InterruptedException, IOException {
        TransferQueue deque = new LinkedTransferQueue();
        Socket socket = new Socket("127.0.0.1", 8096);
        Connection connection = new Connection(socket);

        try  {
            Thread sendMessage = new Thread( new ClientSendMessage(deque, connection));
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
