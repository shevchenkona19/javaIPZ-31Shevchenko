package com.company;

public class Teacher extends User {

    private User.UserType type = UserType.TEACHER;

    @Override
    public String toString() {
        return "Teacher " + getName();
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
