package sheva;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String name = "Никита Шевченко";
        Utils utils = new Utils();
        utils.printN("Разработчик: " + name);
        Scanner scanner = new Scanner(System.in);
        int size = -1;
        do {
            utils.printN("Введите число для задания размерности матрицы");
            String input = scanner.next();
            try {
                size = Integer.valueOf(input);
            } catch (Exception e) {
                size = -1;
                utils.printN("Вы ввели не число");
            }
        } while (size == -1);
        utils.printN("Спасибо!");

        short[][] mainArray = utils.getPopulatedArrayForSize(size);
        utils.printN(mainArray);

        int sum = 0;
        for (short[] row : mainArray) {
            for (short num : row) {
                sum += num;
            }
        }
        short avg = (short)(sum / (size * size));
        utils.printN("Среднее арефметическое: " + avg);
        int counter = 0;
        while (counter < size) {
            mainArray[counter][counter] = avg;
            counter++;
        }
        utils.printN(mainArray);
    }
}
