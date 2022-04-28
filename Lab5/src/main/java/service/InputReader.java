package service;

import exceptions.ElementDoesNotExistException;
import exceptions.IncorrectInputValueException;
import storages.ApproximationStorage;
import storages.EquationStorage;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputReader {
    public static final Scanner scanner = new Scanner(System.in);

    public static int readingChoiceOfEquation() {
        while (true) {
            try {
                System.out.print("Ваш выбор: ");
                int choice = scanner.nextInt();
                EquationStorage.getEquation(choice);
                return choice;
            } catch (InputMismatchException inputMismatchException) {
                LinePainter.printLine();
                System.out.println("Введите целое число!");
                scanner.nextLine();
                LinePainter.printLine();
            } catch (ElementDoesNotExistException elementDoesNotExistException) {
                LinePainter.printLine();
                System.out.println(elementDoesNotExistException.getMessage());
                LinePainter.printLine();
            }
        }
    }

    public static double[] readingBordersOfIntegration() {
        double a, b;
        while (true) {
            try {
                System.out.print("Введите левую границу: ");
                a = scanner.nextDouble();
                scanner.nextLine();
                LinePainter.printLine();
                System.out.print("Введите правую границу: ");
                b = scanner.nextDouble();
                if (b <= a) {
                    throw new IncorrectInputValueException("Значение правой границы должно превышать значение левой границы!");
                }
                break;
            } catch (InputMismatchException exception) {
                LinePainter.printLine();
                System.out.println("Введите число!");
                scanner.nextLine();
                LinePainter.printLine();
            } catch (IncorrectInputValueException incorrectInputValue) {
                LinePainter.printLine();
                System.out.println(incorrectInputValue.getMessage());
                LinePainter.printLine();
            }
        }
        return new double[]{a, b};
    }

    public static double readingStep() {
        double step;
        while (true) {
            try {
                System.out.print("Введите шаг: ");
                step = scanner.nextDouble();
                if (step <= 0.0) {
                    throw new IncorrectInputValueException("Значение шага должно быть больше 0!");
                }
                break;
            } catch (InputMismatchException exception) {
                LinePainter.printLine();
                System.out.println("Введите число!");
                scanner.nextLine();
                LinePainter.printLine();
            } catch (IncorrectInputValueException incorrectInputValue) {
                LinePainter.printLine();
                System.out.println(incorrectInputValue.getMessage());
                LinePainter.printLine();
            }
        }
        return step;
    }

    public static double readingY() {
        double y;
        while (true) {
            try {
                System.out.print("Введите начальное значение y: ");
                y = scanner.nextDouble();
                LinePainter.printLine();
                return y;
            } catch (InputMismatchException exception) {
                LinePainter.printLine();
                System.out.println("Введите число!");
                scanner.nextLine();
                LinePainter.printLine();
            }
        }
    }

    public static int readingChoiceOfApproximation() {
        while (true) {
            try {
                System.out.print("Ваш выбор: ");
                int choice = scanner.nextInt();
                ApproximationStorage.getApproximation(choice);
                return choice;
            } catch (InputMismatchException inputMismatchException) {
                LinePainter.printLine();
                System.out.println("Введите целое число!");
                LinePainter.printLine();
                scanner.nextLine();
            } catch (ElementDoesNotExistException elementDoesNotExistException) {
                LinePainter.printLine();
                System.out.println(elementDoesNotExistException.getMessage());
                LinePainter.printLine();
            }
        }
    }
}
