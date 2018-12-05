package sheva;

import sheva.db.Db;
import sheva.entities.User;
import sheva.utils.Printer;
import sheva.utils.Reader;

public class Engine {

    public void start() {
        boolean doWork = true;
        Reader reader = new Reader();
        String path;
        Printer.print("Type path to db: ");
        path = reader.readString();
        Db db = new Db(path);
        do {
            Printer.print("1. Add new User to DB;");
            Printer.print("2. View all users in DB;");
            Printer.print("3. Find users by role;");
            Printer.print("4. Exit;");
            int choice = -1;
            try {
                choice = reader.readChoice();
            } catch (Exception e) {
                Printer.print("Wrong input! Expected number.");
            }
            switch (choice) {
                case 1:
                    User user = new User();
                    Printer.print("Username: ");
                    String username = reader.readString();
                    Printer.print("Role: ");
                    String role = reader.readString();
                    Printer.print("Password: ");
                    String password = reader.readString();
                    user.setUsername(username);
                    user.setRole(role);
                    user.setPassword(password);
                    db.addUser(user);
                    break;
                case 2:
                    User[] users = db.getAllUsers();
                    for (User user1 : users) {
                        Printer.print(user1.toDisplayString());
                    }
                    break;
                case 3:
                    Printer.print("Type role search");
                    String role1 = reader.readString();
                    User[] users1 = db.findUsersByRole(role1);
                    Printer.print("Found: ");
                    for (User user1 : users1) {
                        Printer.print(user1.toDisplayString());
                    }
                    break;
                case 4:
                    doWork = false;
                    break;
            }
        } while (doWork);
        reader.destroy();
    }
}
