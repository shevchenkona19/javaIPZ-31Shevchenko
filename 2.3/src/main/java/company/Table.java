package company;

public class Table {
    private Plumbing[] plumbings;
    private Printer printer;

    public Table(Plumbing[] plumbings) {
        this.plumbings = plumbings;
        this.printer = new Printer();
    }

    public void print() {
        printer.print(plumbings);
    }

    public Plumbing[] searchByFirm(String firm) throws NothingFoundException {
        Plumbing[] foundTemp = new Plumbing[plumbings.length];
        int index = 0;
        for (Plumbing plumbing : plumbings) {
            if (plumbing.getFirm().toLowerCase().startsWith(firm.toLowerCase())) {
                foundTemp[index] = plumbing;
                index++;
            }
        }
        if (index != 0) {
            Plumbing[] foundFinal = new Plumbing[index];
            if (index + 1 >= 0) System.arraycopy(foundTemp, 0, foundFinal, 0, index);
            return foundFinal;
        } else {
            throw new NothingFoundException("No such firm");
        }
    }

    public Plumbing[] searchByLookAndPrice(String look, int price) throws NothingFoundException {
        Plumbing[] foundTemp = new Plumbing[plumbings.length];
        int index = 0;
        for (Plumbing plumbing : plumbings) {
            if (plumbing.getLook().equalsIgnoreCase(look) && plumbing.getPrice() < price) {
                foundTemp[index] = plumbing;
                index++;
            }
        }
        if (index != 0) {
            Plumbing[] foundFinal = new Plumbing[index];
            System.arraycopy(foundTemp, 0, foundFinal, 0, index);
            return foundFinal;
        } else {
            throw new NothingFoundException("Nothing was found by your criteria");
        }
    }
}
