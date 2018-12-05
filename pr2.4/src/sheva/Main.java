package sheva;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        List<List<String>> lists = new ArrayList<>();
        Random random = new Random();
        int listsSize = random.nextInt(5000);
        if (listsSize < 3) listsSize += 3;
        for (int i = 0; i < listsSize; i++) {
            lists.add(new ArrayList<>());
            int innerListSize = random.nextInt(9);
            for (int j = 0; j < innerListSize; j++) {
                lists.get(i).add("" + random.nextInt(9));
            }
        }
        printListOfLists(lists);
        Comparator comparator = new Comparator();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Type in 1 base value: ");
        String base1 = scanner.nextLine();
        System.out.println("Type in 2 base value: ");
        String base2 = scanner.nextLine();
        System.out.println("Type in 3 base value: ");
        String base3 = scanner.nextLine();
        comparator.setBaseValues(base1, base2, base3);
        List<List<String>> foundList = new ArrayList<>();
        for (List<String> list : lists) {
            if (list.size() > 2) {
                comparator.setCompareElementsValues(list);
                if (comparator.compare()) {
                    foundList.add(list);
                }
            }
        }
        printListOfLists(foundList);
    }

    private static void printListOfLists(List<List<String>> lists) {
        for (List<String> list : lists) {
            System.out.println("List: ");
            for (String s : list) {
                System.out.print(s + " ");
            }
            System.out.println();
        }
    }
}
