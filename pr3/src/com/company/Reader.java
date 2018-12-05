package com.company;

import java.util.Scanner;

public class Reader {
    private Scanner scanner = new Scanner(System.in);

    public int readChoice() {
        String choiceNotConverted = scanner.nextLine();
        return Integer.valueOf(choiceNotConverted);
    }

    public String readQuery() {
        return scanner.nextLine();
    }

    public void close() {
        scanner.close();
    }
}
