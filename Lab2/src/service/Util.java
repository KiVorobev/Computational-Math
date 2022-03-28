package service;

import enums.NumberOfEquation;
import enums.TypeOfWorking;
import exceptions.EndsOfTheSegmentException;
import exceptions.EquationDoesNotExistException;
import service.equation_methods.Bisection;
import service.equation_methods.Chord;
import service.equation_system_methods.Newton;
import storages.EquationStorage;
import storages.equation_system_storage.EquationSystemStorageUtil;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Util {
    private static Scanner scanner = new Scanner(System.in);

    private static void printTypesOfWorking() {
        System.out.println("Выберите режим работы:\n" +
                "1 - Решение нелинейных уравнений\n" +
                "2 - Решение систем нелинейных уравнений");
        LinePainter.printLine();
    }

    public static void systemStart() throws EndsOfTheSegmentException, EquationDoesNotExistException {
        printTypesOfWorking();
        TypeOfWorking select = readingTypeOfWorking();
        modeSelection(select);
    }

    private static TypeOfWorking readingTypeOfWorking() {
        while (true) {
            try {
                System.out.print("Ваш выбор: ");
                int choice = scanner.nextInt();
                LinePainter.printLine();
                if (choice == 1) return TypeOfWorking.EQUATION;
                else if (choice == 2) return TypeOfWorking.EQUATION_SYSTEM;
                else {
                    System.out.println("Введите 1 или 2!");
                    LinePainter.printLine();
                    continue;
                }
            } catch (InputMismatchException exception) {
                LinePainter.printLine();
                System.out.println("Введите 1 или 2!");
                LinePainter.printLine();
                scanner.nextLine();
                continue;
            }
        }
    }

    private static void modeSelection(TypeOfWorking type) throws EndsOfTheSegmentException, EquationDoesNotExistException {
        switch (type) {
            case EQUATION:
                solvingTheEquation();
                break;
            case EQUATION_SYSTEM:
                solvingTheEquationSystem();
                break;
        }
    }

    private static void solvingTheEquation() throws EndsOfTheSegmentException, EquationDoesNotExistException {
        EquationStorage.printVariants();
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

    private static void solvingTheEquationSystem() throws EquationDoesNotExistException {
        EquationSystemStorageUtil.printVariants();
        LinePainter.printLine();
        NumberOfEquation number = readingChoiceOfEquationSystem();
        double[] startValues = readingStartValues();
        double eps = readingAccuracy();
        LinePainter.printLine();
        double[] results = Newton.doMethod(number, startValues, eps);
        LinePainter.printLine();
        Newton.printResult(results);
    }

    private static NumberOfEquation readingChoiceOfEquationSystem() {
        while (true) {
            try {
                System.out.print("Ваш выбор: ");
                int choice = scanner.nextInt();
                scanner.nextLine();
                if (choice == 1) return NumberOfEquation.FIRST;
                else if (choice == 2) return NumberOfEquation.SECOND;
                else if (choice == 3) return NumberOfEquation.THIRD;
                else {
                    LinePainter.printLine();
                    System.out.println("Введите целое число от 1 до 3!");
                    LinePainter.printLine();
                    continue;
                }
            } catch (InputMismatchException exception) {
                LinePainter.printLine();
                System.out.println("Введите целое число от 1 до 3!");
                LinePainter.printLine();
                scanner.nextLine();
                continue;
            }
        }
    }

    private static NumberOfEquation readingChoiceOfEquation() {
        while (true) {
            try {
                System.out.print("Ваш выбор: ");
                int choice = scanner.nextInt();
                scanner.nextLine();
                if (choice == 1) return NumberOfEquation.FIRST;
                else if (choice == 2) return NumberOfEquation.SECOND;
                else if (choice == 3) return NumberOfEquation.THIRD;
                else if (choice == 4) return NumberOfEquation.FOURTH;
                else if (choice == 5) return NumberOfEquation.FIFTH;
                else {
                    LinePainter.printLine();
                    System.out.println("Введите целое число от 1 до 5!");
                    LinePainter.printLine();
                    continue;
                }
            } catch (InputMismatchException exception) {
                LinePainter.printLine();
                System.out.println("Введите целое число от 1 до 5!");
                LinePainter.printLine();
                scanner.nextLine();
                continue;
            }
        }
    }

    private static double[] readingStartValues() {
        double startX, startY;
        while (true) {
            try {
                LinePainter.printLine();
                System.out.print("Введите начальное приближение (x): ");
                startX = scanner.nextDouble();
                LinePainter.printLine();
                System.out.print("Введите начальное приближение (y): ");
                startY = scanner.nextDouble();
                break;
            } catch (InputMismatchException exception) {
                LinePainter.printLine();
                System.out.println("Введите число!");
                scanner.nextLine();
            }
        }
        return new double[]{startX, startY};
    }

    private static double readingAccuracy() {
        double eps;
        while (true) {
            try {
                LinePainter.printLine();
                System.out.print("Введите точность: ");
                eps = scanner.nextDouble();
                if (eps >= 1.0 || eps <= 0.0) {
                    System.err.println("Точность должна находится в промежутке (0;1)!");
                    LinePainter.printLine();
                    scanner.nextLine();
                    continue;
                }
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
        System.out.printf("\u001B[34m" + "%.6f\n" + "\u001B[0m", Math.abs(x2 - x1));
    }
}
