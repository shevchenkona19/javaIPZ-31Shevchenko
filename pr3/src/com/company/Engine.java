package com.company;

public class Engine {
    public void start() {
        Reader reader = new Reader();
        Printer printer = new Printer();
        int size;
        printer.print("Welcome to our store! Fill in items please! You may use auto-fill or manual fill: 1 - auto; 2 - manual");
        int choice1 = reader.readChoice();
        Plumbing[] plumbings;

        switch (choice1) {
            case 1:
                printer.print("Please, specify store size. From 1 to 100 000 000");
                size = reader.readChoice();
                plumbings = new Plumbing[size];
                for (int i = 0; i < plumbings.length; i++) {
                    plumbings[i] = Filler.fill(plumbings[i]);
                }
                break;
            case 2:
                printer.print("Welcome to manual mode! Please, specify store size. From 1 to 100 000 000");
                size = reader.readChoice();
                plumbings = new Plumbing[size];
                for (int i = 0; i < plumbings.length; i++) {
                    printer.print("Next Product: ");
                    plumbings[i] = Filler.fillManual(plumbings[i], reader, printer);
                }
                printer.print("That's all!");
                break;
            default:
                size = 10;
                plumbings = new Plumbing[size];
                for (int i = 0; i < plumbings.length; i++) {
                    plumbings[i] = Filler.fill(plumbings[i]);
                }
                break;
        }

        Table productTable = new Table(plumbings);
        printer.print("Welcome to our store! See our offers below:");
        productTable.print();
        int choice;
        do {
            printer.print("Please, choose what you want to do: 1 - search by firm; 2 - search for look and price lower than your price filter; -1 - for quit");
            choice = reader.readChoice();
            switch (choice) {
                case 1:
                    printer.print("Please type firm name:");
                    String firm = reader.readQuery();
                    Plumbing[] foundItems = productTable.searchByFirm(firm);
                    if (foundItems.length > 0) {
                        Table foundProducts = new Table(foundItems);
                        printer.print("What we found:");
                        foundProducts.print();
                    } else {
                        printer.print("We haven't found anything...");
                    }
                    break;
                case 2:
                    printer.print("Please type wanted look: ");
                    String look = reader.readQuery();
                    printer.print("Please type price filter: ");
                    int price = reader.readChoice();
                    Plumbing[] foundItems2 = productTable.searchByLookAndPrice(look, price);
                    if (foundItems2.length > 0) {
                        Table foundProducts2 = new Table(foundItems2);
                        printer.print("What we found: ");
                        foundProducts2.print();
                    } else {
                        printer.print("We haven't found anything...");
                    }
                    break;
            }
        } while (choice != -1);
        printer.print("Good bye!");
        reader.close();
    }
}
