package sheva.exceptions;

public class ArrayLengthException extends Exception {
    @Override
    public String getMessage() {
        return "'From' array is longer then 'To' array";
    }
}
