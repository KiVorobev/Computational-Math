package exceptions;

public class ElementDoesNotExistException extends Exception {
    public ElementDoesNotExistException() {
        super("Функции с таким номером не существует!");
    }
}
