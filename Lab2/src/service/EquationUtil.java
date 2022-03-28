package service;

import enums.NumberOfEquation;
import enums.TypeOfWorking;
import exceptions.EndsOfTheSegmentException;
import exceptions.EquationDoesNotExistException;
import service.equation_methods.Bisection;
import service.equation_methods.Chord;
import service.equation_system_methods.Newton;

import java.util.InputMismatchException;
import java.util.Scanner;

public class EquationUtil {
    private static Scanner scanner = new Scanner(System.in);

    public void modeSelection(TypeOfWorking type) throws EndsOfTheSegmentException, EquationDoesNotExistException {
        switch (type) {
            case EQUATION:
                getEquation();
                break;
            case EQUATION_SYSTEM:
                getEquationSystem();
                break;
        }
    }

    public static void getEquation() throws EndsOfTheSegmentException, EquationDoesNotExistException {
        EquationStore.printVariantsOfEquations();
        LinePainter.printLine();
        NumberOfEquation number = readingChoiceOfEquation();
        double[] values = readingEndsOfSegment();
        double a = values[0];
        double b = values[1];
        double eps = readingAccuracy();
        LinePainter.printLine();
        double x1 = Bisection.doMethod(a, b, eps, number);
        double x2 = Chord.doMethod(a, b, eps, number);
        Bisection.printResult(x1);
        LinePainter.printLine();
        Chord.printResult(x2);
        LinePainter.printLine();
        printDifferenceOfMethods(x1, x2);
    }

    public static void getEquationSystem() {
        EquationStore.printVariantsOfEquationSystems();
        LinePainter.printLine();
        NumberOfEquation number = readingChoiceOfEquationSystem();
        double startValue = readingStartValue();
        double eps = readingAccuracy();
        LinePainter.printLine();
        double x = Newton.doMethod();
        Newton.printResult(x);
    }

    private static NumberOfEquation readingChoiceOfEquationSystem() {
        NumberOfEquation number;
        while (true) {
            try {
                System.out.print("Ваш выбор: ");
                int choice = scanner.nextInt();
                scanner.nextLine();
                switch (choice) {
                    case 1:
                        number = NumberOfEquation.FIRST;
                        break;
                    case 2:
                        number = NumberOfEquation.SECOND;
                        break;
                    case 3:
                        number = NumberOfEquation.THIRD;
                        break;
                    default:
                        throw new InputMismatchException();
                }
                break;
            } catch (InputMismatchException exception) {
                LinePainter.printLine();
                System.out.println("Введите целое число от 1 до 3!");
                LinePainter.printLine();
                scanner.nextLine();
                continue;
            }
        }
        return number;
    }

    private static NumberOfEquation readingChoiceOfEquation() {
        NumberOfEquation number;
        while (true) {
            try {
                System.out.print("Ваш выбор: ");
                int choice = scanner.nextInt();
                scanner.nextLine();
                switch (choice) {
                    case 1:
                        number = NumberOfEquation.FIRST;
                        break;
                    case 2:
                        number = NumberOfEquation.SECOND;
                        break;
                    case 3:
                        number = NumberOfEquation.THIRD;
                        break;
                    case 4:
                        number = NumberOfEquation.FOURTH;
                        break;
                    case 5:
                        number = NumberOfEquation.FIFTH;
                        break;
                    default:
                        throw new InputMismatchException();
                }
                break;
            } catch (InputMismatchException exception) {
                LinePainter.printLine();
                System.out.println("Введите целое число от 1 до 5!");
                LinePainter.printLine();
                scanner.nextLine();
                continue;
            }
        }
        return number;
    }

    private static double readingStartValue() {
        double startValue;
        while (true) {
            try {
                LinePainter.printLine();
                System.out.print("Введите начальное приближение: ");
                startValue = scanner.nextDouble();
                break;
            } catch (InputMismatchException exception) {
                LinePainter.printLine();
                System.out.println("Введите число!");
                scanner.nextLine();
            }
        }
        return startValue;
    }

    private static double readingAccuracy() {
        double eps;
        while (true) {
            try {
                LinePainter.printLine();
                System.out.print("Введите точность: ");
                eps = scanner.nextDouble();
                break;
            } catch (InputMismatchException exception) {
                LinePainter.printLine();
                System.out.println("Введите число!");
                scanner.nextLine();
            }
        }
        return eps;
    }

    private static double[] readingEndsOfSegment() {
        double a, b;
        while (true) {
            try {
                LinePainter.printLine();
                System.out.print("Введите a (начало отрезка): ");
                a = scanner.nextDouble();
                scanner.nextLine();
                LinePainter.printLine();
                System.out.print("Введите b (конец отрезка): ");
                b = scanner.nextDouble();
                if (b < a) {
                    System.err.println("Конец отрезка должен быть больше начала!");
                    LinePainter.printLine();
                    continue;
                }
                break;
            } catch (InputMismatchException exception) {
                LinePainter.printLine();
                System.out.println("Введите число!");
                scanner.nextLine();
            }
        }
        return new double[]{a, b};
    }

    private static void printDifferenceOfMethods(double x1, double x2) {
        System.out.print("Разница между результатами решения двух методов: ");
        System.out.printf("\u001B[34m" + "%.4f\n" + "\u001B[0m", Math.abs(x2 - x1));
    }
}
