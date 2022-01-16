package com.mycompany.app;

public class CvvNotANumberException extends Exception{
    CvvNotANumberException(String msg) {
        super(msg);
    }
}
