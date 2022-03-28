package service;

import enums.TypeOfWorking;
import exceptions.EndsOfTheSegmentException;
import exceptions.EquationDoesNotExistException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ChooseReader {
    private Scanner scanner = new Scanner(System.in);

    public ChooseReader() {
        System.out.println("Выберите режим работы:\n" +
                "1 - Решение нелинейных уравнений\n" +
                "2 - Решение систем нелинейных уравнений");
        LinePainter.printLine();
    }

    public void chooseReading(EquationUtil util) throws EndsOfTheSegmentException, EquationDoesNotExistException {
        int data;
        while (true) {
            try {
                System.out.print("Ваш выбор: ");
                data = scanner.nextInt();
                LinePainter.printLine();
                TypeOfWorking select;
                if (data == 1) {
                    select = TypeOfWorking.EQUATION;
                } else if (data == 2) {
                    select = TypeOfWorking.EQUATION_SYSTEM;
                } else {
                    System.out.println("Введите 1 или 2!");
                    LinePainter.printLine();
                    continue;
                }
                util.modeSelection(select);
                break;
            } catch (InputMismatchException exception) {
                LinePainter.printLine();
                System.out.println("Введите 1 или 2!");
                LinePainter.printLine();
                scanner.nextLine();
                continue;
            }
        }
    }
}