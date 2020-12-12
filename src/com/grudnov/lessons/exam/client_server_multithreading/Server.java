package com.grudnov.lessons.exam.client_server_multithreading;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TransferQueue;

public class Server {

    public void start() throws Exception {
        try(ServerSocket serverSocket = new ServerSocket(8093)){
            System.out.println("Server start");
            //ConcurrentSkipListSet<Connection> connections = new ConcurrentSkipListSet<>();
            //TransferQueue<SimpleMessage> messages = new LinkedTransferQueue<>();
            while(true){
                Socket socket = serverSocket.accept();
              /*  connections.add(new Connection(socket));
                for (Connection connection : connections) {
                    SimpleMessage temp = connection.getMessage();
                    messages.put(temp);
                    System.out.println(temp);
                    connection.sendMessage(messages.take());*/
                try(Connection connection = new Connection(socket)){
                    System.out.println(connection.getMessage());
                    connection.sendMessage(SimpleMessage.getMessage("server","message recieved",
                            Thread.currentThread().getName()));

                }
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Server server = new Server();
        try {
            try {
                server.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
