package com.grudnov.lessons.lesson20.hw_client_server;

import com.grudnov.lessons.lesson15.hwMessage.Message;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.time.temporal.ChronoUnit;
import java.util.Properties;
import java.util.Scanner;

public class Client {
    private String ip;
    private int port;
    private Scanner scanner;
    private String name;

    public Client(String ip, int port) {
        this.ip = ip;
        this.port = port;
        scanner = new Scanner(System.in);
    }

    public void start() throws Exception {
        String name = scanner.nextLine();
        this.name = name;
        String message;
        while (true){
            sendAndPrintMessage(SimpleMessage.getMessage(this.name, "I am connecting"));
            System.out.println("Введите сообщение");
            message = scanner.nextLine();
            if(message.equals("/exit")) break;
            sendAndPrintMessage(SimpleMessage.getMessage(name, message));
        }
    }

    private void sendAndPrintMessage(SimpleMessage message) throws Exception {
        try (Connection connection
                     = new Connection(new Socket(ip, port))){
            connection.sendMessage(message);
            SimpleMessage fromServer = connection.readMessage();
            if(fromServer.getText().equals("ping")){
                System.out.println(ChronoUnit.MILLIS.between(message.getDateTime(),fromServer.getDateTime()));
            }
            System.out.println("от сервера: " + fromServer);
        }
    }

    public static void main(String[] args) {
        // ip 127.0.0.1 : 8090 read from config.properties
        Properties properties = new Properties();
        try (FileReader input = new FileReader(new File("sources/config.properties"))){
            properties.load(input);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        try {
            new Client(new Properties().getProperty("ip"),
                    Integer.valueOf(properties.getProperty("port"))).start();
        } catch (Exception e) {
            e.printStackTrace();
        }
        // если необходимо запустить параллельно несколько клиентов
        // Client -> edit configurations -> allow parallel run
    }
}
