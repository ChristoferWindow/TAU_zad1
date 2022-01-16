package com.mycompany.app;

public class StringNotAsciiException extends Exception{
    StringNotAsciiException(String msg){
        super(msg);
    }
}
