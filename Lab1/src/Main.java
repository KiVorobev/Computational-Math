import entity.Matrix;
import service.Gauss;
import service.Util;

import java.io.FileNotFoundException;

public class Main {
    private static final String LINE = "-------------------------------------------";

    public static void main(String[] args) throws FileNotFoundException {
        Util util = new Util();
        Gauss gauss = new Gauss();
        Matrix matrix = util.createMatrix();
        System.out.println(LINE + "\nВведенная расширенная матрица:");
        util.printMatrix(matrix);
        Matrix triangleMatrix = gauss.gaussMethod(matrix);
        double determinant = gauss.findDeterminant(triangleMatrix);
        System.out.print(LINE + "\nОпределитель данной матрицы: ");
        System.out.printf("\u001B[34m" + "%.4f\n" + "\u001B[0m", determinant);
        if (determinant != 0) {
            System.out.println(LINE + "\nМатрица, приведенная к треугольному виду:");
            util.printMatrix(triangleMatrix);
            System.out.println(LINE + "\nКорни уравнения:");
            double[] results = util.getResults(triangleMatrix);
            for (int i = 0; i < triangleMatrix.getSize(); i++) {
                System.out.printf("x[" + (i + 1) + "]: " + "%.4f\n", results[i]);
            }
            System.out.println(LINE + "\nНевязки:");
            double[] residuals = util.getResiduals(matrix, results);
            for (int i = 0; i < triangleMatrix.getSize(); i++) {
                System.out.println("r[" + (i + 1) + "]: " + residuals[i]);
            }
        } else
            System.out.println(LINE + "\u001B[31m" + "\nМатрицу невозможно привести к треугольному виду!" + "\u001B[0m");
    }
}
