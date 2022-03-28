import exceptions.EndsOfTheSegmentException;
import exceptions.EquationDoesNotExistException;
import service.Util;

public class Main {

    public static void main(String[] args) {
        try {
            Util.systemStart();
        } catch (EndsOfTheSegmentException | EquationDoesNotExistException exception) {
            System.err.println(exception.getMessage());
        }
    }
}
