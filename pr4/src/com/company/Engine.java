package com.company;

public class Engine {
    private SchoolSystem schoolSystem = new SchoolSystem();
    private boolean keepGoing = true;

    private Menu initMenu = new Menu(new Option[]{
            new Option("login", () -> {
                Printer.print("Type your name: ");
                String name = Input.getNextLine();
                User user = schoolSystem.login(name);
                user.startSession(schoolSystem);
            }),
            new Option("register", () -> {
                Printer.print("Type your name: ");
                String name = Input.getNextLine();
                User user;
                Printer.print("Who are you?");
                Printer.print("0. Teacher");
                Printer.print("1. Student");
                int choice = Input.getChoice();
                if (choice == 0) {
                    user = new Teacher();
                } else {
                    user = new Student();
                }
                user.setName(name);
                schoolSystem.registerUser(user);
                user.startSession(schoolSystem);
            }),
            new Option("exit", () -> keepGoing = false)
    });

    public void start() {
        Printer.print("Welcome to school sys v1!");
        do {
            Printer.print("");
            Printer.print(initMenu.toString());
            int choice = Input.getChoice();
            initMenu.getWorkerByIndex(choice).onClick();
        } while (keepGoing);
    }
}
