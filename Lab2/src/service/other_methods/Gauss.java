package service.other_methods;

public class Gauss {

    private static double[][] doMethod(double[][] matrix, double[] results) {
        double[][] fullMatrix = addUnknownColumnToMatrix(matrix, results);
        double[][] cloneMatrix = cloneMatrix(fullMatrix);
        for (int k = 0; k < cloneMatrix.length - 1; k++) {
            if (cloneMatrix[0][0] == 0) continue;
            for (int i = k + 1; i < cloneMatrix.length; i++) {
                if (cloneMatrix[i][k] == 0) continue;
                double multiplex = cloneMatrix[i][k];
                for (int j = 0; j < cloneMatrix.length + 1; j++) {
                    cloneMatrix[i][j] -= cloneMatrix[k][j] * (multiplex / cloneMatrix[k][k]);
                }
            }
        }
        return cloneMatrix;
    }

    public static double[] getUnknownColumn(double[][] matrix, double[] results) {
        double[][] triangleMatrix = doMethod(matrix, results);
        double[] unknownColumn = new double[results.length];
        for (int i = triangleMatrix.length - 1; i >= 0; i--) {
            double sum = 0;
            double element = triangleMatrix[i][triangleMatrix.length];
            if (!isNullRow(triangleMatrix[i]) && triangleMatrix[i][i] != 0) {
                for (int j = 0; j < triangleMatrix.length; j++) {
                    if (j != i) sum += unknownColumn[j] * triangleMatrix[i][j];
                }
                unknownColumn[i] = (element - sum) / triangleMatrix[i][i];
            }
        }
        return unknownColumn;
    }

    private static double[][] addUnknownColumnToMatrix(double[][] matrix, double[] result) {
        double[][] resultMatrix = new double[matrix.length][matrix.length + 1];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                resultMatrix[i][j] = matrix[i][j];
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            resultMatrix[i][matrix.length] = result[i];
        }
        return resultMatrix;
    }

    private static double[][] cloneMatrix(double[][] matrix) {
        double[][] resultMatrix = new double[matrix.length][matrix.length + 1];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length + 1; j++) {
                resultMatrix[i][j] = matrix[i][j];
            }
        }
        return resultMatrix;
    }

    private static boolean isNullRow(double[] row) {
        for (double element : row) {
            if (element != 0) return false;
        }
        return true;
    }
}