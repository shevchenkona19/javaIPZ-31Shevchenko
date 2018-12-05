package com.company;

import java.util.concurrent.atomic.AtomicBoolean;

public class Question implements IQuestion {
    private Answer[] answers;
    private String title;

    public Question() {
        answers = new Answer[0];
        title = "";
    }

    @Override
    public void ask() {
        Option[] options = new Option[answers.length + 1];
        AtomicBoolean keepGoing = new AtomicBoolean(true);
        for (int i = 0; i < options.length; i++) {
            options[i] = new Option();
            if (i == answers.length) {
                options[i].setName("To next question");
                options[i].setMenuOption(() -> keepGoing.set(false));
                break;
            }
            options[i].setName(answers[i].getText());
            int finalI = i;
            options[i].setMenuOption(() -> respond(finalI));
        }
        Menu menu = new Menu(options);
        do {
            Printer.print(menu.toString());
            int choice = Input.getChoice();
            menu.getWorkerByIndex(choice).onClick();
        } while (keepGoing.get());
    }

    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public void addAnswer(Answer answer) {
        Answer[] newArr = new Answer[answers.length + 1];
        for (int i = 0; i < newArr.length; i++) {
            if (i == answers.length) {
                newArr[i] = answer;
                break;
            }
            newArr[i] = answers[i];
        }
        this.answers = newArr;
    }

    @Override
    public void respond(int id) {
        answers[id].setChosen(true);
    }

    @Override
    public boolean getMark() {
        boolean isCorrect = true;
        for (Answer answer : answers) {
            if (answer.isChosen()) {
                if (!answer.isCorrect()) isCorrect = false;
            } else if (answer.isCorrect()) isCorrect = false;
        }
        return isCorrect;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < answers.length; i++) {
            builder.append((i));
            builder.append(". ");
            builder.append(answers[i].getText());
            builder.append("\n");
        }
        return title + "\n" + builder.toString();
    }
}
