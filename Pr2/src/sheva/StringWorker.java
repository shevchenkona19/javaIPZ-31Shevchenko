package sheva;

import java.util.HashMap;

public class StringWorker {
    private String mainText;
    private HashMap<Integer, Character> symbolsTable;
    private Utils utils;

    public StringWorker(String mainText) {
        utils = new Utils();
        StringBuilder builder = new StringBuilder();
        symbolsTable = new HashMap<>();
        char[] chars = mainText.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (c == ',' ||
                    c == '.' ||
                    c == '?' ||
                    c == '\\' ||
                    c == '/' ||
                    c == '{' ||
                    c == '_' ||
                    c == '}' ||
                    c == '(' ||
                    c == ')' ||
                    c == '!') {
                symbolsTable.put(i, c);
                builder.append("*");
                continue;
            }
            builder.append(c);
        }
        this.mainText = builder.toString();
    }

    public void reworkText() {
        String[] wordsArray = mainText.split(" ");
        for (int j = 0; j < wordsArray.length; j++) {
            if (wordsArray[j].length() == 4) {
                if (wordsArray[j].contains("*") || wordsArray[j].contains("\n")) continue;
                wordsArray[j] = wordsArray[j].toUpperCase();
            }
            if (wordsArray[j].length() == 5) {
                if (wordsArray[j].contains("*") || wordsArray[j].contains("\n")) {
                    wordsArray[j] = wordsArray[j].toUpperCase();
                }
            }
        }
        String joinedString = utils.join(wordsArray);
        char[] chars = joinedString.toCharArray();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (c == '*') {
                c = symbolsTable.get(i);
            }
            builder.append(c);
        }
        mainText = builder.toString();
    }

    @Override
    public String toString() {
        return mainText;
    }
}