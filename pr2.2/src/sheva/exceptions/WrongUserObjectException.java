package sheva.exceptions;

public class WrongUserObjectException extends Exception {
    @Override
    public String getMessage() {
        return "Wrong user object!";
    }


}
