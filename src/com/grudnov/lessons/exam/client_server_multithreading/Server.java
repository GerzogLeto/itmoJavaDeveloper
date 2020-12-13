package com.grudnov.lessons.exam.client_server_multithreading;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.*;

public class Server {

    public void start() throws Exception {
        try (ServerSocket serverSocket = new ServerSocket(8094)) {
            System.out.println("Server start");
            //ConcurrentSkipListSet<Socket> sockets = new ConcurrentSkipListSet<>();
            BlockingDeque messages = new LinkedBlockingDeque(1);
            while (true) {
                Socket socket = serverSocket.accept();
                //Connection connection =  new Connection(socket);
                //connection.sendMessage(connection.getMessage());
                //sockets.add(socket);
                    Thread serverReader = new Thread(new ServerReader(socket,messages));
                    serverReader.start();
                    Thread serverWriter = new Thread(new ServerWriter(messages));
                    serverWriter.start();

            }
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
