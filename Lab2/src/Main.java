import exceptions.EndsOfTheSegmentException;
import exceptions.EquationDoesNotExistException;
import service.ChooseReader;
import service.EquationUtil;

public class Main {

    public static void main(String[] args) {
        ChooseReader chooseReader = new ChooseReader();
        EquationUtil equationUtil = new EquationUtil();
        try {
            chooseReader.chooseReading(equationUtil);
        } catch (EndsOfTheSegmentException | EquationDoesNotExistException exception) {
            System.err.println(exception.getMessage());
        }
    }
}
