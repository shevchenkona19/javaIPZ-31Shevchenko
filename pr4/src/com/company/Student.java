package com.company;

public class Student extends User {
    private User.UserType type = User.UserType.STUDENT;

    @Override
    public String toString() {
        return "Student " + getName();
    }

    @Override
    public void startSession(SchoolSystem schoolSystem) {
        super.startProcess();
        this.schoolSystem = schoolSystem;
        Menu menu = schoolSystem.getMenu(type);
        Printer.print(menu.toString());
        int choice = Input.getChoice();
        menu.getWorkerByIndex(choice).onClick();
    }
}
