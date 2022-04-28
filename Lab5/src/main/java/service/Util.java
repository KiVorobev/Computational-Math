package service;

import exceptions.ElementDoesNotExistException;
import exceptions.IncorrectInputValueException;
import methods.runge_kutta_method.RungeKuttaMethodUtil;
import storages.ApproximationStorage;
import storages.EquationStorage;

public class Util {

    public static void systemStart() throws ElementDoesNotExistException {
        EquationStorage.printEquations();
        LinePainter.printLine();
        int numberOfEquation = InputReader.readingChoiceOfEquation();
        LinePainter.printLine();
        double[] borders = InputReader.readingBordersOfIntegration();
        double step;
        LinePainter.printLine();
        while (true) {
            try {
                step = InputReader.readingStep();
                LinePainter.printLine();
                if (step > borders[1] - borders[0]) {
                    throw new IncorrectInputValueException("Значение шага не должно превышать длину отрезка");
                }
                break;
            } catch (IncorrectInputValueException incorrectInputValueException) {
                System.out.println(incorrectInputValueException.getMessage());
                LinePainter.printLine();
            }
        }
        double y = InputReader.readingY();
        ApproximationStorage.printApproximations();
        LinePainter.printLine();
        int numberOfApproximation = InputReader.readingChoiceOfApproximation();
        LinePainter.printLine();
        RungeKuttaMethodUtil.calculateAndGetResults(borders, y, step, numberOfEquation, numberOfApproximation);
    }
}