package com.pooja.healthcare.exception;

public class AppointementAlreadyExisting extends Throwable{

    public AppointementAlreadyExisting(String message) {
        super(message);
    }
}
