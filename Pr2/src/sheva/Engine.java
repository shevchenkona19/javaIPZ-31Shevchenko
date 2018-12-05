package sheva;

public class Engine {
    private Utils utils;

    public Engine() {
        utils = new Utils();
    }

    public void start() {
        StringWorker worker;
        String s = utils.readText();
        utils.print("до:");
        utils.print(s);
        worker = new StringWorker(s);
        worker.reworkText();
        utils.print("после:");
        utils.print(worker.toString());
    }
}
