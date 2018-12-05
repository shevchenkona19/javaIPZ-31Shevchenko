package company;

public class Printer {
    public void print(String s) {
        System.out.println(s);
    }

    public void print(Plumbing p) {
        print(p.toString());
    }

    public void print(Plumbing[] plumbings) {
        print(String.format("%-20s%-20s%-10s%-30s%-15s%-10s%-10s", "Id", "Firm", "Model", "Name", "Look", "Quantity", "Price"));
        for (Plumbing p : plumbings)
            print(p);
    }
}
