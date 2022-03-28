package service.equation_methods;

import enums.NumberOfEquation;
import exceptions.EndsOfTheSegmentException;
import exceptions.EquationDoesNotExistException;
import storages.EquationStorage;

public class Chord {

    public static double doMethod(double a, double b, double eps, NumberOfEquation equation) throws EndsOfTheSegmentException, EquationDoesNotExistException {
        checkingForSegment(a, b, equation);
        double buffer;
        double difference = Double.MAX_VALUE;
        double value = 0;
        while (difference > eps) {
            if (EquationStorage.getEquation(equation, a) * EquationStorage.getEquation(equation, getNextValue(a, b, equation)) < 0) {
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
        return value - ((immutableValue - value) / (EquationStorage.getEquation(equation, immutableValue) -
                EquationStorage.getEquation(equation, value))) * EquationStorage.getEquation(equation, value);
    }

    private static void checkingForSegment(double a, double b, NumberOfEquation equation) throws EndsOfTheSegmentException, EquationDoesNotExistException {
        if (EquationStorage.getEquation(equation, a) * EquationStorage.getEquation(equation, b) > 0) {
            throw new EndsOfTheSegmentException("Концы отрезка имеют одинаковый знак!");
        }
    }

    public static void printResult(double x) {
        System.out.print("Результат решения методом хорд: ");
        System.out.printf("\u001B[34m" + "%.6f\n" + "\u001B[0m", x);
    }
}
