package com.grudnov.lessons.exam.client_server_multithreading;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.*;

public class Server {

    public void start() throws Exception {
        try (ServerSocket serverSocket = new ServerSocket(8096)) {
            System.out.println("Server start");
            ConcurrentHashMap<String, Connection> connections = new ConcurrentHashMap<>();
            BlockingDeque messages = new LinkedBlockingDeque(1);
            //Socket socket = serverSocket.accept();
            //Connection connection = new Connection(socket);
            while (true) {
                Connection connection = new Connection(serverSocket.accept());
                //connections.add(connection);
                System.out.println("connect added");
                Thread serverReader = new Thread(new ServerReader(connection, messages, connections));
                serverReader.setName("ServerReader");
                serverReader.start();
                System.out.println("Reader started ");
                Thread serverWriter = new Thread(new ServerWriter(messages, connections, connection));
                serverWriter.setName("Server writer");
                serverWriter.start();
                System.out.println("Writer started ");
            }

            //sockets.add(socket);
            //Thread serverReader = new Thread(new ServerReader(socket,messages));
            //serverReader.start();
            //Thread serverWriter = new Thread(new ServerWriter(messages));
            //serverWriter.start();

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
