import exceptions.FunctionDoesNotDefineException;
import exceptions.ImpossibleToBridgeTheGapException;
import exceptions.IntegralDoesNotExistException;
import service.Util;

public class Main{
    public static void main(String[] args) throws IntegralDoesNotExistException {
        try {
            Util.systemStart();
        } catch (ImpossibleToBridgeTheGapException | FunctionDoesNotDefineException exception) {
            System.out.println(exception.getMessage());
        }
    }
}