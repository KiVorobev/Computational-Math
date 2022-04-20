package exceptions;

public class FunctionDoesNotDefineException extends Exception {
    public FunctionDoesNotDefineException() {
        super("Функция не определена на данном отрезке");
    }
}
