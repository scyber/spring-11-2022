package ru.otus.spring.execption;

public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(String message, Throwable cause){
        super(message,cause);
    }
}
