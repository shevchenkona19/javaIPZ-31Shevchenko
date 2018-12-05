package sheva.db;

import sheva.entities.User;
import sheva.exceptions.WrongUserObjectException;
import sheva.utils.UserList;

import java.io.*;
import java.nio.file.Files;

public class Db {
    private File workingFile;

    public Db(String pathToFile) {
        workingFile = new File(pathToFile);
    }

    public User[] getAllUsers() {
        UserList list = new UserList();
        try (BufferedReader reader = Files.newBufferedReader(workingFile.toPath())) {
            String line;
            while ((line = reader.readLine()) != null) {
                list.push(new User().inflateUser(line));
            }
        } catch (IOException | WrongUserObjectException e) {
            System.err.println("Error in loading users: " + e.getMessage());
        }
        return list.getArray();
    }

    public void addUser(User user) {
        String userObject = user.toString();
        try (FileWriter fw = new FileWriter(workingFile, true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {
            out.append(userObject);
            out.append("\n");
        } catch (IOException x) {
            System.err.format("IOException: %s%n", x);
        }
    }

    public void addUser(User[] users) {
        String[] userObjects = new String[users.length];
        for (int i = 0; i < userObjects.length; i++) {
            userObjects[i] = users[i].toString();
        }
        for (String userObject : userObjects) {
            try (FileWriter fw = new FileWriter(workingFile, true);
                 BufferedWriter bw = new BufferedWriter(fw);
                 PrintWriter out = new PrintWriter(bw)) {
                out.append(userObject);
                out.append("\n");
            } catch (IOException x) {
                System.err.format("IOException: %s%n", x);
            }
        }
    }

    public User[] findUsersByRole(String role1) {
        User[] users = getAllUsers();
        UserList list = new UserList();
        for (User user : users) {
            if(user.getRole().equals(role1)) {
                list.push(user);
            }
        }
        return list.getArray();
    }
}
