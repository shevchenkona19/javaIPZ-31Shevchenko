package com.company;

public interface IQuestion {
    void ask();
    void setTitle(String title);
    void addAnswer(Answer answer);
    void respond(int id);
    boolean getMark();
}
