package com.grudnov.lessons.lesson19.hw_encryption;

import java.io.*;

public class Application {
    public static void main(String[] args) {
        File fileInput = new File("sources/in.txt");
        File fileOutput = new File("sources/out.txt");
        try {
            fileInput.createNewFile();
            fileOutput.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            writeToFile(fileInput, "Hello", false);
            encryptData(readToFile(fileInput).getBytes(), fileOutput);
            decryptData(fileOutput);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void decryptData(File file) throws IOException {
        try(EncryptionInDecor encryptionIn = new EncryptionInDecor(new FileInputStream(file))){
            byte[] bytes = new byte[512];
            encryptionIn.read(bytes);
            String res = encryptionIn.getDecryptionString();
            if(res.equals("Hello")){
                System.out.println("Decrypting correct");
                System.out.println(res);
            }
        }
    }

    public static void encryptData(byte[] data, File file) throws IOException {
        try (EncryptionOutDecor encryptionOut = new EncryptionOutDecor(new FileOutputStream(file));
        ) {
            encryptionOut.write(data);
        }
        }

        public static void writeToFile (File file, String data,boolean append)
            throws IOException {
            try (BufferedOutputStream buffer = new BufferedOutputStream(new FileOutputStream(file, append))) {
                buffer.write(data.getBytes());
            }
        }

        public static String readToFile (File file) throws IOException {
            try (BufferedInputStream buffer = new BufferedInputStream(new FileInputStream(file));
                 ByteArrayOutputStream byteArray = new ByteArrayOutputStream();
            ) {
                String res = null;
                byte[] bytes = new byte[512];
                int data;
                while ((data = buffer.read(bytes)) != -1) {
                    byteArray.write(bytes, 0, data);
                }
                return res = new String(byteArray.toByteArray());
            }
        }
    }

    class EncryptionInDecor extends FilterInputStream {
    private String str;

        protected EncryptionInDecor(InputStream in) {
            super(in);
        }

        public String getDecryptionString() {
            return str;
        }

        @Override
        public int read(byte[] bytes) throws IOException {
            byte key = (byte) 0b1111_1111;
            ByteArrayOutputStream byteArray = new ByteArrayOutputStream();
            int data = 0;
            while((data = in.read(bytes) ) != -1){
                for (int i = 0; i < data; i++) {
                    bytes[i] ^= key;
                }
                byteArray.write(bytes, 0, data);
            }
            this.str  =byteArray.toString();

            return 0;
        }
    }

    class EncryptionOutDecor extends FilterOutputStream {

        public EncryptionOutDecor(OutputStream out) {
            super(out);
        }

        @Override
        public void write(byte[] b) throws IOException {
            //encrypting xor ^
            byte key = (byte) 0b1111_1111;
            for (int i = 0; i < b.length; i++) {
                b[i] ^= key;
            }
            out.write(b);
        }
    }
