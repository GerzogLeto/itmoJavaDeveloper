package com.grudnov.lessons.exam.client_server_multithreading;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Connection implements AutoCloseable, Comparable {
    private Socket socket;
    private ObjectInputStream input;
    private ObjectOutputStream output;

    public Connection(Socket socket) throws IOException {
        this.socket = socket;
        this.output = new ObjectOutputStream(this.socket.getOutputStream());
        this.input = new ObjectInputStream(this.socket.getInputStream());
    }

    public    SimpleMessage getMessage() throws IOException, ClassNotFoundException {
        return (SimpleMessage) input.readObject();
    }

    public     void sendMessage(SimpleMessage message) throws IOException {
        message.setDateTime();
        output.writeObject(message);
        output.flush();
    }

    @Override
    public void close() throws Exception {
        input.close();
        output.close();
        socket.close();
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
