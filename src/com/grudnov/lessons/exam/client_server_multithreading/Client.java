package com.grudnov.lessons.exam.client_server_multithreading;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.util.concurrent.*;

public class Client {

    public static void main(String[] args) throws InterruptedException, IOException {
        ConcurrentSkipListSet set = new ConcurrentSkipListSet();
        Socket socket = new Socket("127.0.0.1", 8096);
        Connection connection = new Connection(socket);
        set.add(connection);

        try  {
            Thread sendMessage = new Thread( new ClientSendMessage(set));
            sendMessage.setName("ClientSenderThread");
            sendMessage.start();
            System.out.println("ClientSenderThread started ");
            Thread getMessage = new Thread( new ClientGetMessage(set));
            getMessage.setName("ClientPrintMessage");
            getMessage.start();
            System.out.println("ClientPrintMessage started ");
            sendMessage.join();
            getMessage.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
