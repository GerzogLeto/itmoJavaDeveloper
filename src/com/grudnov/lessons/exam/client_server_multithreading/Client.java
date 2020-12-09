package com.grudnov.lessons.exam.client_server_multithreading;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) {
        Thread sendMessage = new Thread( new ClientSendMessage());
        sendMessage.setName("sendClientThread");
        sendMessage.start();
        Thread getMessage = new Thread( new ClientGetMessage());
        getMessage.setName("getClientThread");
        getMessage.start();
    }
}
