package com.company;

public class Printer {
    public static void print(String s) {
        System.out.println(s);
    }

    public static void print(String... s) {
        for (String s1 : s) {
            System.out.print(s1 + " ");
        }
        System.out.println();
    }

    public static void print(int a, String s) {
        System.out.println(a + " - " + s);
    }
}
