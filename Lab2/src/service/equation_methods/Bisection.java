package service.equation_methods;

import enums.NumberOfEquation;
import exceptions.EndsOfTheSegmentException;
import exceptions.EquationDoesNotExistException;
import storages.EquationStorage;

public class Bisection {

    public static double doMethod(double a, double b, double eps, NumberOfEquation equation) throws EndsOfTheSegmentException, EquationDoesNotExistException {
        checkingForSegment(a, b, equation);
        double c;
        while (b - a > eps) {
            c = (b - a) / 2.0 + a;
            if (EquationStorage.getEquation(equation, a) * EquationStorage.getEquation(equation, c) < 0) b = c;
            else a = c;
        }
        return a;
    }

    private static void checkingForSegment(double a, double b, NumberOfEquation equation) throws EndsOfTheSegmentException, EquationDoesNotExistException {
        if (EquationStorage.getEquation(equation, a) * EquationStorage.getEquation(equation, b) > 0) {
            throw new EndsOfTheSegmentException("Концы отрезка имеют одинаковый знак!");
        }
    }

    public static void printResult(double x) {
        System.out.print("Результат решения методом деления пополам: ");
        System.out.printf("\u001B[34m" + "%.6f\n" + "\u001B[0m", x);
    }
}
