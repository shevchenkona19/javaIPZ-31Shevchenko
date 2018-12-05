package com.company;

public class Main {

    public static void main(String[] args) {
        String name = "Никита Шевченко";
        Utils utils = new Utils();
        utils.printN("Разработчик: " + name);
        int size;
        do {
            utils.printN("Введите число для задания размерности матрицы");
            try {
                size = utils.readNumber();
            } catch (ReadFormatException e) {
                size = -1;
                utils.printN(e.getMessage() );
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
        short avg = (short) (sum / (size * size));
        utils.printN("Среднее арефметическое: " + avg);
        int counter = 0;
        while (counter < size) {
            mainArray[counter][counter] = avg;
            counter++;
        }
        utils.printN(mainArray);
    }
}
