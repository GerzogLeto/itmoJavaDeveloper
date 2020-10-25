package com.grudnov.lessons.lesson12.exceptions;
// если нужно созд собственн класс искл времени выполнения то наслед от RuntimeException
//еслм времени выполн то от Exception
public class ChatException extends  Exception {

    public ChatException(String message) {
        super(message);
    }

    //можем переопред методы родителя


    @Override
    public String getMessage() {
        return super.getMessage() + "Be careful";
    }
}
