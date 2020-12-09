package com.grudnov.lessons.exam.client_server_multithreading;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public void start()   {
        try(ServerSocket serverSocket = new ServerSocket(8091)){
            System.out.println("Server start");
            while(true){
                Socket socket = serverSocket.accept();
                try(Connection connection = new Connection(socket)){
                    System.out.println(connection.getMessage());
                    connection.sendMessage(SimpleMessage.getMessage("server","received",
                            Thread.currentThread().getName()));
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Server server = new Server();
        server.start();
    }
}
