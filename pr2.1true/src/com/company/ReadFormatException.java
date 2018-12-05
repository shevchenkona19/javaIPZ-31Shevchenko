package com.company;

public class ReadFormatException extends Exception {
    public ReadFormatException(String gotFormat) {
        super("Wrong input format: " + gotFormat + "; Expected number");
    }
}