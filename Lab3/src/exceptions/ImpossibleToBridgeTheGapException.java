package exceptions;

public class ImpossibleToBridgeTheGapException extends Exception{
    public ImpossibleToBridgeTheGapException() {
        super("На заданном отрезке функция имеет разрыв, который невозможно устранить");
    }
}
