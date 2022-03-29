package service.equation_system_methods;

import enums.NumberOfEquation;
import exceptions.EquationDoesNotExistException;
import service.other_methods.Gauss;
import storages.equation_system_storage.EquationSystem;
import storages.equation_system_storage.FirstEquationSystem;
import storages.equation_system_storage.SecondEquationSystem;
import storages.equation_system_storage.ThirdEquationSystem;

import java.util.Arrays;

public class Newton {

    public static double[] doMethod(NumberOfEquation number, double[] startValues, double eps) throws EquationDoesNotExistException {
        double[] unknownsColumn = new double[2];
        EquationSystem system = getSystem(number);
        unknownsColumn[0] = system.getFirstEquation(startValues[0], startValues[1]);
        unknownsColumn[1] = system.getSecondEquation(startValues[0], startValues[1]);
        double[] buffer = {unknownsColumn[0] + 2 * eps, unknownsColumn[1] + 2 * eps}; // + eps + 1 - для того чтобы корректно зайти в цикл
        double[][] jacoby;
        double[] results;
        double[] differences;
        for (int i = 1; Math.abs(unknownsColumn[0] - buffer[0]) > eps && Math.abs(unknownsColumn[1] - buffer[1]) > eps; i++) {
            buffer = Arrays.copyOf(unknownsColumn, unknownsColumn.length);
            jacoby = calculateJacoby(buffer, system);
            results = calculateResults(buffer, system);
            differences = Gauss.getUnknownColumn(jacoby, results);
            unknownsColumn[0] += differences[0];
            unknownsColumn[1] += differences[1];
            printInformationAboutIteration(i, unknownsColumn);
        }
        return unknownsColumn;
    }

    private static double[][] calculateJacoby(double[] unknownsColumn, EquationSystem system) {
        double[][] jacoby = new double[2][2];
        jacoby[0][0] = system.getDerivativeXOfFirstEquation(unknownsColumn[0], unknownsColumn[1]);
        jacoby[0][1] = system.getDerivativeYOfFirstEquation(unknownsColumn[0], unknownsColumn[1]);
        jacoby[1][0] = system.getDerivativeXOfSecondEquation(unknownsColumn[0], unknownsColumn[1]);
        jacoby[1][1] = system.getDerivativeYOfSecondEquation(unknownsColumn[0], unknownsColumn[1]);
        return jacoby;
    }

    private static double[] calculateResults(double[] unknownsColumn, EquationSystem system) {
        double[] results = new double[2];
        results[0] = -system.getFirstEquation(unknownsColumn[0], unknownsColumn[1]);
        results[1] = -system.getSecondEquation(unknownsColumn[0], unknownsColumn[1]);
        return results;
    }

    private static void printInformationAboutIteration(int iteration, double[] unknownsColumn) {
        System.out.println("Итерация[" + iteration + "]: x = " + String.format("%.6f", unknownsColumn[0]) + " y = "
                + String.format("%.6f", unknownsColumn[1]));
    }

    private static EquationSystem getSystem(NumberOfEquation number) throws EquationDoesNotExistException {
        switch (number) {
            case FIRST:
                return new FirstEquationSystem();
            case SECOND:
                return new SecondEquationSystem();
            case THIRD:
                return new ThirdEquationSystem();
            default:
                throw new EquationDoesNotExistException("Системы уравнений с таким номером не существует");
        }
    }

    public static void printResult(double[] results) {
        System.out.println("Результат решения системы методом Ньютона: ");
        System.out.print("x: ");
        System.out.printf("\u001B[34m" + "%.6f\n" + "\u001B[0m", results[0]);
        System.out.print("y: ");
        System.out.printf("\u001B[34m" + "%.6f\n" + "\u001B[0m", results[1]);
    }
}
