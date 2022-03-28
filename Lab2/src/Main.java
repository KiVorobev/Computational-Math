import exceptions.EndsOfTheSegmentException;
import exceptions.EquationDoesNotExistException;
import service.Util;

public class Main {

    public static void main(String[] args) {
        Util util = new Util();
        try {
            util.systemStart();
        } catch (EndsOfTheSegmentException | EquationDoesNotExistException exception) {
            System.err.println(exception.getMessage());
        }
    }
}
