package com.company;

import java.util.Scanner;

public class Input {
    private static Scanner scanner = new Scanner(System.in);

    public static String getNextLine() {
        return scanner.nextLine();
    }

    public static int getChoice() {
        int ch = 0;
        boolean isOkay = false;
        do {
            try {
                ch = Integer.valueOf(getNextLine());
                isOkay = true;
            } catch (Exception e) {
                Printer.print("Please, type a num instead");
            }
        } while (!isOkay);
        return ch;
    }
}
