package com.company;

public class Test implements ITest {
    private IQuestion[] questions;
    private SchoolSystem.Subjects subject;
    private String name;

    public Test() {
        questions = new IQuestion[0];
    }

    @Override
    public void createTest(SchoolSystem.Subjects subject) {
        this.subject = subject;
    }

    @Override
    public void addQuestion(IQuestion question) {
        IQuestion[] newArr = new IQuestion[questions.length + 1];
        for (int i = 0; i < newArr.length; i++) {
            if (i == questions.length) {
                newArr[i] = question;
                break;
            }
            newArr[i] = questions[i];
        }
        this.questions = newArr;
    }

    @Override
    public int begin() {
        for (IQuestion question : questions) {
            question.ask();
        }
        int correct = 0;
        for (IQuestion question : questions) {
            if (question.getMark()) {
                correct++;
            }
        }
        if (correct != 0) {
            return (questions.length / correct) * 100;
        } else return 0;
    }

    @Override
    public void printTest() {
        System.out.print(this.toString());
    }

    @Override
    public int getTestId() {
        return 0;
    }

    @Override
    public String getTestName() {
        return name;
    }

    @Override
    public void setTestName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Test named ").append(name).append(" of ").append(subject).append(" subject;\n");
        sb.append("Total questions: ").append(questions.length).append(";\n");
        sb.append("Qustions: \n");
        for (IQuestion question : questions) {
            sb.append(question.toString());
        }
        return sb.toString();
    }
}
