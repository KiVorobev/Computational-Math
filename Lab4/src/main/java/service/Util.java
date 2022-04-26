package service;

import exceptions.ElementDoesNotExistException;
import methods.least_square_method.LeastSquareMethodUtil;
import storages.ApproximationStorage;
import storages.FunctionStorage;

public class Util {

    public static void systemStart() throws ElementDoesNotExistException {
        FunctionStorage.printFunctions();
        LinePainter.printLine();
        int numberOfFunction = InputReader.readingChoiceOfFunction();
        LinePainter.printLine();
        ApproximationStorage.printApproximations();
        LinePainter.printLine();
        int numberOfApproximation = InputReader.readingChoiceOfApproximation();
        LinePainter.printLine();
        LeastSquareMethodUtil.calculateAndGetResults(numberOfFunction, numberOfApproximation);
    }
}