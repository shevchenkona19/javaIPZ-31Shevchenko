package com.company;

import java.util.Random;
import java.util.Scanner;

public class Utils {
    public void print(String string) {
        System.out.print(string);
    }

    public void printN(String string) {
        System.out.print(string + "\n");
    }

    public short[][] getPopulatedArrayForSize(int size) {
        Random random = new Random();
        short[][] array = new short[size][size];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = (short)(random.nextInt(Short.MAX_VALUE) - Short.MAX_VALUE /2 );
            }
        }
        return array;
    }

    public void printN(short[][] array) {
        for(short[] row : array) {
            for (short num : row) {
                System.out.printf("%-7d ", num);
            }
            printN("");
        }
    }

    public int readNumber() throws ReadFormatException {
        int size;
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        try {
            size = Integer.valueOf(input);
        } catch (NumberFormatException e) {
            throw new ReadFormatException("string");
        }
        return size;
    }

}
