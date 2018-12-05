package com.company;

public class Answer {
    private String text;
    private boolean isCorrect;
    private boolean isChosen;

    public Answer(String text, boolean isCorrect, boolean isChosen) {
        this.text = text;
        this.isCorrect = isCorrect;
        this.isChosen = isChosen;
    }

    public Answer() {}

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isCorrect() {
        return isCorrect;
    }

    public void setCorrect(boolean correct) {
        isCorrect = correct;
    }

    public boolean isChosen() {
        return isChosen;
    }

    public void setChosen(boolean chosen) {
        isChosen = chosen;
    }
}
