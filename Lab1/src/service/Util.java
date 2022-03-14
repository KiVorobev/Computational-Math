package service;

import entity.Matrix;
import enums.TypeOfWorking;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Util {
    private Scanner scanner = new Scanner(System.in);
    private static final String LINE = "-------------------------------------------";

    public Matrix createMatrix() throws FileNotFoundException {
        ChooseReader chooseReader = new ChooseReader();
        int userChoose = 0;
        while (userChoose == 0) {
            System.out.print("Ваш выбор: ");
            String choose = scanner.nextLine().trim();
            userChoose = chooseReader.chooseReading(choose);
            if (userChoose == 0) {
                System.out.println(LINE + "\nВыберите цифру 1, 2 или 3!\n" + LINE);
            }
        }
        Matrix matrix = null;
        if (userChoose == 1) matrix = userInput();
        if (userChoose == 2) matrix = fileReading();
        if (userChoose == 3) matrix = generationRandom();
        return matrix;
    }

    public int setMatrixSize() {
        int size;
        while (true) {
            try {
                System.out.print(LINE + "\nВведите размерность матрицы (от 2 до 20): ");
                String value = scanner.nextLine();
                size = Integer.parseInt(value);
                if (size < 2 || size > 20) {
                    System.out.println(LINE + "\nВведите число от 2 до 20!");
                    continue;
                }
                break;
            } catch (NumberFormatException exception) {
                System.out.println(LINE + "\nВведите целое число!");
            }
        }
        return size;
    }

    public Matrix fileReading() throws FileNotFoundException {
        File file;
        while (true) {
            System.out.print(LINE + "\nВведите название файла: ");
            String filename = "resources/" + scanner.nextLine();
            file = new File(filename);
            if (!file.exists() || !file.isFile()) {
                System.out.println(LINE + "\nФайл не найден! Попробуйте еще раз.");
            } else {
                break;
            }
        }
        Scanner matrixScanner = new Scanner(file);
        int size = matrixScanner.nextInt();
        return new Matrix(size, readMatrix(matrixScanner, size, TypeOfWorking.READ_FROM_FILE));
    }

    public Matrix userInput() {
        int size = setMatrixSize();
        System.out.println("Введите данные матрицы:");
        return new Matrix(size, readMatrix(scanner, size, TypeOfWorking.USER_INPUT));
    }

    private Matrix generationRandom() {
        int size = setMatrixSize();
        double[][] matrix = new double[size][size + 1];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size + 1; j++) {
                matrix[i][j] = Math.random() * 10;
            }
        }
        Matrix newMatrix = new Matrix(size, matrix);
        validateMatrix(newMatrix);
        return newMatrix;
    }

    public void printMatrix(Matrix matrix) {
        for (int i = 0; i < matrix.getSize(); i++) {
            for (int j = 0; j < matrix.getSize() + 1; j++) {
                if (j == matrix.getSize()) {
                    System.out.printf("| %.4f", matrix.getElement(i, j));
                } else {
                    System.out.printf("%.4f ", matrix.getElement(i, j));
                }
            }
            System.out.println();
        }
    }

    private double[][] readMatrix(Scanner scanner, int size, TypeOfWorking type) {
        double[][] matrix = new double[size][size + 1];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size + 1; j++) {
                if (type == TypeOfWorking.USER_INPUT)
                    System.out.print("[" + (i + 1) + "][" + (j + 1) + "]: ");
                try {
                    while (true) {
                        try {
                            matrix[i][j] = scanner.nextDouble();
                            break;
                        } catch (NumberFormatException numberFormatException) {
                            System.out.println("Введите число!");
                        } catch (NoSuchElementException noSuchElementException) {
                            System.out.println(LINE + "\nВ файле хранится некорректная матрица! Попробуйте еще раз.");
                            System.exit(1);
                        }
                    }
                } catch (InputMismatchException exception) {
                    System.out.println("Нужно ввести число!");
                }
            }
        }
        return matrix;
    }

    public static void validateMatrix(Matrix matrix) {
        for (int i = 0; i < matrix.getSize(); i++) {
            for (int j = 0; j < matrix.getSize() + 1; j++) {
                if (Math.abs(matrix.getElement(i, j)) < 0.0001) {
                    matrix.setElement(i, j, Math.abs(matrix.getElement(i, j)));
                }
            }
        }
    }

    public static Matrix cloneMatrix(Matrix matrix) {
        Matrix newMatrix = new Matrix(matrix.getSize());
        int size = matrix.getSize();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size + 1; j++) {
                newMatrix.setElement(i, j, matrix.getElement(i, j));
            }
        }
        return newMatrix;
    }

    public double[] getResults(Matrix matrix) {
        double[] results = new double[matrix.getSize()];
        for (int i = 0; i < matrix.getSize(); i++) {
            results[matrix.getSize() - i - 1] = getResult(matrix, results, matrix.getSize() - i - 1);
        }
        return results;
    }

    public double getResult(Matrix matrix, double[] results, int i) {
        double result = matrix.getMatrix()[i][matrix.getSize()];
        for (int k = 0; k < matrix.getSize(); k++) {
            if (k != i) {
                result = result - matrix.getMatrix()[i][k] * results[k];
            }
        }
        result = result / matrix.getMatrix()[i][i];
        return result;
    }

    public double[] getResiduals(Matrix matrix, double[] result) {
        double[] residuals = new double[matrix.getSize()];
        for (int i = 0; i < matrix.getSize(); i++) {
            residuals[i] = matrix.getMatrix()[i][matrix.getSize()];
            for (int j = 0; j < matrix.getSize(); j++) {
                residuals[i] = residuals[i] - matrix.getMatrix()[i][j] * result[j];
            }
        }
        return residuals;
    }
}
