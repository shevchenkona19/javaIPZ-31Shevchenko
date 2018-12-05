package sheva.utils;

import java.util.Scanner;

public class Reader {
    private Scanner scanner;

    public Reader() {
        scanner = new Scanner(System.in);
    }
    public int readChoice() {
        return Integer.valueOf(scanner.nextLine());
    }
    public String readString() {
        return scanner.nextLine();
    }

    public void destroy() {
        scanner.close();
    }
}
