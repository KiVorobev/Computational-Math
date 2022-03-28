package service.equation_methods;

import enums.NumberOfEquation;
import exceptions.EndsOfTheSegmentException;
import exceptions.EquationDoesNotExistException;
import service.EquationStore;

public class Chord {

    public static double doMethod(double a, double b, double eps, NumberOfEquation equation) throws EndsOfTheSegmentException, EquationDoesNotExistException {
        checkingForSegment(a, b, equation);
        double buffer;
        double difference = Double.MAX_VALUE;
        double value = 0;
        while (difference > eps) {
            if (EquationStore.getEquation(equation, a) * EquationStore.getEquation(equation, getNextValue(a, b, equation)) < 0) {
                buffer = b;
                b = getNextValue(a, b, equation);
                difference = Math.abs(buffer - b);
                value = b;
            } else {
                buffer = a;
                a = getNextValue(a, b, equation);
                difference = Math.abs(buffer - a);
                value = a;
            }
        }
        return value;
    }

    private static double getNextValue(double value, double immutableValue, NumberOfEquation equation) throws EquationDoesNotExistException {
        return value - ((immutableValue - value) / (EquationStore.getEquation(equation, immutableValue) -
                EquationStore.getEquation(equation, value))) * EquationStore.getEquation(equation, value);
    }

    private static void checkingForSegment(double a, double b, NumberOfEquation equation) throws EndsOfTheSegmentException, EquationDoesNotExistException {
        if (EquationStore.getEquation(equation, a) * EquationStore.getEquation(equation, b) > 0) {
            throw new EndsOfTheSegmentException("Ends of the segment have the same sign!");
        }
    }

    public static void printResult(double x) {
        System.out.print("Результат решения методом хорд: ");
        System.out.printf("\u001B[34m" + "%.4f\n" + "\u001B[0m", x);
    }
}
