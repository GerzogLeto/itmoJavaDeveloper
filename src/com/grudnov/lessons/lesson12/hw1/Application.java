package com.grudnov.lessons.lesson12.hw1;

import java.io.FileNotFoundException;
import java.nio.file.AccessDeniedException;
import java.util.jar.JarException;

public class Application {
    public static void throwException(Status status) throws AccessDeniedException{
        try{
            switch (status){
                case JAR_ERROR :
                    throw new JarException();

                case FILE_NOT_FOUND:
                    throw new FileNotFoundException();

                case ACCESS_DENIED:
                    throw new AccessDeniedException("file");

            }

        }catch (FileNotFoundException e){
            System.out.println(e.getMessage() + " Sorry, but file not found :( ");
        }catch (AccessDeniedException e){
            System.out.println(e.getMessage());
            throw e;
        }catch (JarException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws AccessDeniedException  {
        throwException(Status.values()[(int)(Math.random() * Status.values().length )]);
    }
}


