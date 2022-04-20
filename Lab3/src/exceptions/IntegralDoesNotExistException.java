package exceptions;

public class IntegralDoesNotExistException extends Exception {
    public IntegralDoesNotExistException() {
        super("Интеграла с таким номером не существует!");
    }
}