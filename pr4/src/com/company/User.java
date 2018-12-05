package com.company;

public abstract class User {
    public enum UserType {
        STUDENT,
        TEACHER
    }

    public SchoolSystem schoolSystem;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void startProcess() {
        Printer.print("Welcome, " + this.toString());
        Printer.print("Here is a menu:");
    }

    public void register(String name, SchoolSystem schoolSystem) {
        this.schoolSystem = schoolSystem;
        this.name = name;
        schoolSystem.registerUser(this);
    }

    public abstract void startSession(SchoolSystem schoolSystem);
}
