package service;

import exceptions.ElementDoesNotExistException;
import storages.ApproximationStorage;
import storages.FunctionStorage;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputReader {
    public static final Scanner scanner = new Scanner(System.in);

    public static int readingChoiceOfFunction() {
        while (true) {
            try {
                System.out.print("Ваш выбор: ");
                int choice = scanner.nextInt();
                FunctionStorage.getFunction(choice);
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
