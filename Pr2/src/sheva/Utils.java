package sheva;

import java.util.Scanner;

public class Utils {

    public void print(String text) {
        System.out.println(text);
    }

    public void print(char[] chars) {
        for (char c : chars) {
            System.out.print(c + " ");
        }
    }

    public String readText() {
        System.out.println("Введите текст пожалуйста: ");
        Scanner scanner = new Scanner(System.in);
        StringBuilder builder = new StringBuilder();

        while (scanner.hasNextLine()) {
            String s = scanner.nextLine();
            if (s.length() == 0) break;
            Scanner lineScanner = new Scanner(s);
            while (lineScanner.hasNext()) {
                builder.append(lineScanner.next());
                builder.append(" ");
            }
            builder.append("\n");
            lineScanner.close();
        }
        scanner.close();
        return builder.toString();
    }

    public String join(String[] array) {
        StringBuilder builder = new StringBuilder();
        for (int j = 0; j < array.length; j++) {
            if (j == array.length - 1) {
                builder.append(array[j]);
            } else {
                builder.append(array[j]);
                builder.append(" ");
            }
        }
        return builder.toString();
    }
}
