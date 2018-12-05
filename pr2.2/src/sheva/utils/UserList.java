package sheva.utils;

import sheva.entities.User;
import sheva.exceptions.ArrayLengthException;

public class UserList {
    private User[] users;
    private int index = 0;

    public UserList() {
        users = new User[2];
    }

    public UserList(User[] init) {
        users = init;
    }

    public void push(User user) {
        users[index] = user;
        index++;
        if (index == users.length - 1) {
            User[] expandUsers = new User[users.length * 2];
            try {
                users = copy(users, expandUsers);
            } catch (ArrayLengthException e) {
                e.printStackTrace();
            }
        }
    }

    private void trim() {
        User[] trimmed = new User[index];
        System.arraycopy(users, 0, trimmed, 0, trimmed.length);
        users = trimmed;
    }

    public User[] getArray() {
        trim();
        return users;
    }

    private User[] copy(User[] from, User[] to) throws ArrayLengthException {
        if (to.length < from.length) {
            throw new ArrayLengthException();
        }
        System.arraycopy(from, 0, to, 0, from.length);
        return to;
    }
}
