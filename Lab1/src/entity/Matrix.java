package entity;

public class Matrix {
    private int size;
    private double[][] matrix;

    public Matrix(int size) {
        this.size = size;
        matrix = new double[size][size + 1];
    }

    public Matrix(int size, double[][] matrix) {
        this.size = size;
        this.matrix = matrix;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public double[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(double[][] matrix) {
        this.matrix = matrix;
    }

    public void setElement(int i, int j, double value) {
        this.matrix[i][j] = value;
    }

    public double getElement(int i, int j) {
        return matrix[i][j];
    }
}
