package com.grudnov.lessons.lesson20.hw_client_server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashSet;
import java.util.Set;

public class SimpleServer {
    private Connection connection;
    Set<String> clients = new HashSet<>();

    public void start() throws IOException, ClassNotFoundException, InterruptedException {
        try (ServerSocket serverSocket = new ServerSocket(8090)){
            System.out.println("Server started");
            while (true) {
                Socket socket = serverSocket.accept();
                connection = new Connection(socket);
                SimpleMessage message = connection.readMessage();
                if(message.getText().equals("/help")){
                    connection.sendMessage(SimpleMessage.getMessage("server",
                            Source.commandList));
                }
                if(message.getText().equals("/count")){
                    connection.sendMessage(SimpleMessage.getMessage("server",
                            "number of clients: " + clients.size()));
                }
                if(message.getText().equals("I am connecting")){
                    clients.add(message.getSender());
                }
                if(message.getText().equals("/ping")){
                    Thread.sleep(5000);
                    connection.sendMessage(SimpleMessage.getMessage("server", "ping"));
                }

                connection.sendMessage(SimpleMessage.getMessage("server", "получено"));
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        SimpleServer server = new SimpleServer();
        try {
            server.start();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
