package com.company;

import com.sun.istack.internal.Nullable;

public class SchoolSystem {
    private User[] users;
    private ITest[] tests;

    public enum Subjects {
        MATH,
        LITERATURE
    }

    public SchoolSystem() {
        users = new User[0];
        tests = new ITest[0];
    }

    private Menu studentMenu = new Menu(new Option[]{
            new Option("Review all Tests", () -> {
                for (ITest t : tests) {
                    t.printTest();
                }
            }),
            new Option("Choose this to take a test", () -> {
                Printer.print("Type test id: ");
                for (int i = 0; i < tests.length; i++) {
                    ITest test = tests[i];
                    Printer.print(i, test.getTestName());
                }
                int choice = Input.getChoice();
                int score = tests[choice].begin();
                Printer.print("Congrats! your score is " + score);
            })});

    private Menu teacherMenu = new Menu(new Option[]{
            new Option("Create a test", () -> {
                ITest test = new Test();
                Printer.print("Please, choose a subject: ");
                Subjects[] subjects = Subjects.values();
                for (int i = 0; i < subjects.length; i++) {
                    Printer.print(i + ". Subject " + subjects[i]);
                }
                int subjectId = Input.getChoice();
                test.createTest(subjects[subjectId]);
                Printer.print("Please type a name for this test: ");
                String name = Input.getNextLine();
                test.setTestName(name);
                Printer.print("Please, say how much questions there should be: ");
                int questionsNum = Input.getChoice();
                for (int i = 0; i < questionsNum; i++) {
                    Question question = new Question();
                    Printer.print("Please, specify a title for question: ");
                    question.setTitle(Input.getNextLine());
                    Printer.print("How much answers will be there?");
                    int answersCount = Input.getChoice();
                    for (int j = 0; j < answersCount; j++) {
                        Answer answer = new Answer();
                        Printer.print("Name answer #" + j + ":");
                        answer.setText(Input.getNextLine());
                        Printer.print("Will this answer be a correct one?");
                        Printer.print("0 - no");
                        Printer.print("1 - yes");
                        int choice = Input.getChoice();
                        answer.setCorrect(choice == 1);
                        Printer.print("\n");
                        question.addAnswer(answer);
                    }
                    test.addQuestion(question);
                }
                Printer.print("test has been created!");
                addTest(test);
            })
    });

    private Menu defaultMenu = new Menu(new Option[]{
            new Option("Exit", () -> Printer.print("goodBye!"))
    });

    public ITest[] getTests() {
        return tests;
    }

    public ITest getTest(int id) {
        return tests[id];
    }

    public void addTest(ITest test) {
        ITest[] newArr = new ITest[tests.length + 1];
        for (int i = 0; i < newArr.length; i++) {
            if (i == tests.length) {
                newArr[i] = test;
                break;
            }
            newArr[i] = tests[i];
        }
        this.tests = newArr;
    }

    public void registerUser(User user) {
        User[] newArr = new User[users.length + 1];
        for (int i = 0; i < newArr.length; i++) {
            if (i == users.length) {
                newArr[i] = user;
                break;
            }
            newArr[i] = users[i];
        }
        this.users = newArr;
    }

    public Menu getMenu(User.UserType userType) {
        switch (userType) {
            case STUDENT:
                return studentMenu;
            case TEACHER:
                return teacherMenu;
            default:
                return defaultMenu;
        }
    }

    @Nullable
    public User login(String name) {
        for (User user : users) {
            if (user.getName().equals(name)) return user;
        }
        return null;
    }

}
