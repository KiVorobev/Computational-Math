package service;

import entity.Matrix;

public class Gauss {
    private static int coefficient = 1;

    public Gauss() {
    }

    public Matrix gaussMethod(Matrix matrix) {
        Matrix triangleMatrix = Util.cloneMatrix(matrix);
        for (int i = 0; i < triangleMatrix.getSize(); i++) {
            triangleMatrix = swapRows(triangleMatrix, i);
            triangleMatrix = nullingColumn(triangleMatrix, i);
        }
        Util.validateMatrix(triangleMatrix);
        return triangleMatrix;
    }

    public Matrix swapRows(Matrix matrix, int numberOfRow) {
        Matrix cloneMatrix = Util.cloneMatrix(matrix);
        double[][] cloneMatrixArray = cloneMatrix.getMatrix();
        int row = numberOfRow;
        double[] bufferRow;
        double element = cloneMatrixArray[numberOfRow][numberOfRow];
        if (element == 0) {
            while (element == 0 && row != matrix.getSize() - 1) {
                bufferRow = cloneMatrixArray[numberOfRow];
                cloneMatrixArray[numberOfRow] = cloneMatrixArray[row + 1];
                cloneMatrixArray[row + 1] = bufferRow;
                element = cloneMatrixArray[numberOfRow][numberOfRow];
                ++row;
            }
        }
        return cloneMatrix;
    }

    private Matrix nullingColumn(Matrix matrix, int numberOfColumn) {
        Matrix cloneMatrix = Util.cloneMatrix(matrix);
        double[][] cloneMatrixArray = cloneMatrix.getMatrix();
        for (int i = numberOfColumn + 1; i < cloneMatrix.getSize(); i++) {
            if (cloneMatrixArray[numberOfColumn][numberOfColumn] == 0) break;
            double multiplier = cloneMatrixArray[i][numberOfColumn] / cloneMatrixArray[numberOfColumn][numberOfColumn];
            for (int j = 0; j < cloneMatrix.getSize() + 1; j++) {
                cloneMatrixArray[i][j] = cloneMatrixArray[i][j] - cloneMatrixArray[numberOfColumn][j] * multiplier;
            }
        }
        return cloneMatrix;
    }

    public double findDeterminant(Matrix matrix) {
        double determinant = 1;
        for (int i = 0; i < matrix.getSize(); i++) {
            determinant *= matrix.getMatrix()[i][i];
        }
        if (determinant == 0) Math.abs(determinant);
        return determinant;
    }
}
