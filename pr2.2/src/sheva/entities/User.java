package sheva.entities;

import sheva.exceptions.WrongUserObjectException;

public class User {
    private String username;
    private String role;
    private String password;

    public User(String username, String role, String password) {
        this.username = username;
        this.role = role;
        this.password = password;
    }

    public User() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return username + ";" + role + ";" + password;
    }

    public String toDisplayString() {
        return "Username: " + username + "\n" +
                "Role: " + role + "\n" +
                "Password: " + password + "\n";
    }

    public User inflateUser(String userObject) throws WrongUserObjectException {
        if (!userObject.contains(";")) {
            throw new WrongUserObjectException();
        }
        String[] values = userObject.split(";");
        username = values[0];
        role = values[1];
        password = values[2];
        return this;
    }
}
