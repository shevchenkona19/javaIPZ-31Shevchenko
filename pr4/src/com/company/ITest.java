package com.company;

public interface ITest {

    void createTest(SchoolSystem.Subjects subject);

    void addQuestion(IQuestion question);

    int begin();

    void printTest();

    int getTestId();

    String getTestName();
    void setTestName(String name);
}
