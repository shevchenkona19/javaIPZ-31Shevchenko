package company;

import java.util.Scanner;

public class Reader {
    private Scanner scanner = new Scanner(System.in);

    public int readChoice() {
        Printer printer = new Printer();
        String choiceNotConverted;
        boolean isError;
        String reg = "^[0-9]+$";
        do {
            choiceNotConverted = scanner.nextLine();
            try {
                if (choiceNotConverted.matches(reg)) {
                    isError = false;
                } else {
                    throw new IncorrectInputException("Only numbers! repeat please:");
                }
            } catch (IncorrectInputException e) {
                Engine.logger.error(e.getMessage());
                isError = true;
            }
        } while (isError);
        return Integer.valueOf(choiceNotConverted);
    }

    public String readQuery(boolean allowNumbers) {
        String regex;
        Printer printer = new Printer();
        if (allowNumbers) regex = "^[0-9A-Za-z ]+$";
        else regex = "^[A-Za-z ]+$";
        boolean isError;
        String input;
        do {
            input = scanner.nextLine();
            try {
                if (input.matches(regex)) {
                    isError = false;
                } else {
                    throw new IncorrectInputException("Error in reading string! Check it before continue:");
                }
            } catch (IncorrectInputException e) {
                Engine.logger.error(e.getMessage());
                isError = true;
            }
        } while (isError);
        return input;
    }

    public void close() {
        scanner.close();
    }
}
