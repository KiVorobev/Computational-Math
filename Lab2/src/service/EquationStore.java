package service;

import enums.NumberOfEquation;
import exceptions.EquationDoesNotExistException;

public class EquationStore {

    public static double getEquation(NumberOfEquation equation, double x) throws EquationDoesNotExistException {
        switch (equation) {
            case FIRST:
                return getFirstEquation(x);
            case SECOND:
                return getSecondEquation(x);
            case THIRD:
                return getThirdEquation(x);
            case FOURTH:
                return getFourthEquation(x);
            case FIFTH:
                return getFifthEquation(x);
            default:
                throw new EquationDoesNotExistException("Equation with this number does not exist");
        }
    }

    private static double getFirstEquation(double x) {
        return Math.pow(Math.E, -x) - (1.0 / 2.0 * Math.pow(Math.sin(x), 2));
    }

    private static double getSecondEquation(double x) {
        return Math.pow(x, 3) - 0.2 * (Math.pow(x, 2)) + 0.5 * x + 1.5;
    }

    private static double getThirdEquation(double x) {
        return Math.tan(0.55 * x + 0.1) - Math.pow(x, 2);
    }

    private static double getFourthEquation(double x) {
        return (1 + Math.pow(x, 2)) * Math.pow(Math.E, -x) + Math.sin(x);
    }

    private static double getFifthEquation(double x) {
        return 4 * Math.sin(x) + 1 - x;
    }

    public static void printVariantsOfEquations() {
        System.out.println("Выберите уравнение для решения:\n" +
                "1) e^(-x) - 1/2 * sin^2(x) = 0\n" +
                "2) х^3 – 0,2x^2 + 0,5x + 1,5 = 0\n" +
                "3) tg(0,55x + 0,1) - x^2 = 0\n" +
                "4) (1 + x^2) * e^(-x) + sin(x) = 0\n" +
                "5) 4 sin(x) + 1 - x = 0");
    }

    public static void printVariantsOfEquationSystems() {
        System.out.println("Выберите систему уравнений для решения:\n ");
    }
}
