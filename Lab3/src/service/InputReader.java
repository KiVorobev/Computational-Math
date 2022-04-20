package service;

import exceptions.IncorrectInputValueException;
import exceptions.IntegralDoesNotExistException;
import integrals.IntegralStorage;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputReader {
    private static final Scanner scanner = new Scanner(System.in);

    public static int readingChoiceOfIntegral() {
        while (true) {
            try {
                System.out.print("Ваш выбор: ");
                int choice = scanner.nextInt();
                IntegralStorage.getIntegral(choice);
                return choice;
            } catch (InputMismatchException inputMismatchException) {
                LinePainter.printLine();
                System.out.println("Введите целое число!");
                LinePainter.printLine();
                scanner.nextLine();
            } catch (IntegralDoesNotExistException integralDoesNotExistException) {
                LinePainter.printLine();
                System.out.println(integralDoesNotExistException.getMessage());
                LinePainter.printLine();
            }
        }
    }

    public static double[] readingBordersOfIntegration() {
        double a, b;
        while (true) {
            try {
                LinePainter.printLine();
                System.out.print("Введите левую границу интегрирования: ");
                a = scanner.nextDouble();
                scanner.nextLine();
                LinePainter.printLine();
                System.out.print("Введите правую границу интегрирования: ");
                b = scanner.nextDouble();
                if (b <= a) {
                    throw new IncorrectInputValueException("Значение правой границы должно превышать значение левой границы!");
                }
                break;
            } catch (InputMismatchException exception) {
                LinePainter.printLine();
                System.out.println("Введите число!");
                scanner.nextLine();
            } catch (IncorrectInputValueException incorrectInputValue) {
                LinePainter.printLine();
                System.out.println(incorrectInputValue.getMessage());
            }
        }
        return new double[]{a, b};
    }

    public static double readingAccuracy() {
        double eps;
        while (true) {
            try {
                LinePainter.printLine();
                System.out.print("Введите точность: ");
                eps = scanner.nextDouble();
                if (eps <= 0.0 || eps >= 1.0) {
                    throw new IncorrectInputValueException("Точность должна находится в промежутке (0;1)!");
                }
                break;
            } catch (InputMismatchException exception) {
                LinePainter.printLine();
                System.out.println("Введите число!");
                scanner.nextLine();
            } catch (IncorrectInputValueException incorrectInputValue) {
                LinePainter.printLine();
                System.out.println(incorrectInputValue.getMessage());
            }
        }
        return eps;
    }
}