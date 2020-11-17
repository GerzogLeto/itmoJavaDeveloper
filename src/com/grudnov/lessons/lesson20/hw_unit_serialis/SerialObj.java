package com.grudnov.lessons.lesson20.hw_unit_serialis;

import java.io.*;

public class SerialObj {
    public static void writeToFile(Object obj) throws IOException {
        File file = new File("sources/save_game.bin");
        file.createNewFile();
        try(ObjectOutputStream output = new ObjectOutputStream(
                new FileOutputStream(file, false))){
            output.writeObject(obj);
        }
    }

    public static Object readFromFile() throws IOException, ClassNotFoundException {
        Object obj = null;
        File file = new File("sources/save_game.bin");
        file.createNewFile();
        try(ObjectInputStream input = new ObjectInputStream(new FileInputStream(file))){
            return obj = input.readObject();
        }
    }
}
