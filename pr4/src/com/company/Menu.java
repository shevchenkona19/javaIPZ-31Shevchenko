package com.company;

public class Menu {
    private Option[] options;

    public Menu(Option[] options) {
        this.options = options;
    }

    public IMenuOption getWorkerByIndex(int index) {
        return options[index].getMenuOption();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < options.length; i++) {
            sb.append(i)
                    .append(". ")
                    .append(options[i].getName())
                    .append("\n");
        }
        return sb.toString();
    }
}
