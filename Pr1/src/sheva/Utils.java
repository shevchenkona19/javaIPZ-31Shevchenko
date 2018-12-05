package sheva;

import java.util.Random;

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
}
