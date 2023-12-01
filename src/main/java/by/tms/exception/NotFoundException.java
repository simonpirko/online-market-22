package by.tms.exception;

/*
    @author Ilya Moiseenko on 28.11.23
*/

public class NotFoundException extends RuntimeException {
    public NotFoundException(String message) {
        super(message);
    }
}
