package company;

import java.util.Random;

public class Filler {

    private static String[] firms = {
            "BOSCH", "SAMSUNG", "APPLE", "MOULINEX", "ACER", "ELECTROLUX", "PANASONIC", "SVEN"
    };

    private static String[] looks = {
            "good", "bad", "okay", "not bad", "very good", "excellent", "brand new", "refubrished"
    };

    private static String[] models = {
            "mk-1", "mk-2", "mk-3", "mk-4", "mk-5", "mk-6", "mk-7"
    };

    private static String[] names = {
            "washer", "vacuum cleaner", "fridge", "mop", "dish washer", "microwave", "tv"
    };

    private static Random generator = new Random();

    public static Plumbing fill(Plumbing plumbing) {
        if (plumbing == null) plumbing = new Plumbing();
        plumbing.setFirm(firms[getRndNumber(firms.length)]);
        plumbing.setId(String.valueOf(getRndNumber(400500)));
        plumbing.setLook(looks[getRndNumber(looks.length)]);
        plumbing.setModel(models[getRndNumber(models.length)]);
        plumbing.setName(names[getRndNumber(names.length)]);
        plumbing.setQuantity(getRndNumber(150));
        plumbing.setPrice(getRndNumber(12000));
        return  plumbing;
    }

    public static Plumbing fillManual(Plumbing plumbing, Reader reader, Printer printer) {
        if (plumbing == null) plumbing = new Plumbing();
        plumbing.setId(String.valueOf(getRndNumber(405040)));
        printer.print("Firm name: ");
        plumbing.setFirm(reader.readQuery(false));
        printer.print("Model name: ");
        plumbing.setModel(reader.readQuery(true));
        printer.print("Name: ");
        plumbing.setName(reader.readQuery(true));
        printer.print("Look: ");
        plumbing.setLook(reader.readQuery(false));
        printer.print("Quantity: ");
        plumbing.setQuantity(reader.readChoice());
        printer.print("Price: ");
        plumbing.setPrice(reader.readChoice());
        return plumbing;
    }

    private static int getRndNumber(int max) {
        return generator.nextInt(max);
    }
}
