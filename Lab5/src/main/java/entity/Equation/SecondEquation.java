package entity.Equation;

public class SecondEquation implements Equation {

    @Override
    public double getDerivative(double x, double y) {
        return y * (Math.pow(x, 2) + 1);
    }

    @Override
    public double getAnalyticSolution(double x) {
        return Math.exp(((Math.pow(x, 3)) / 3) + x);
    }

    @Override
    public String toString() {
        return "y * (x^2 + 1)";
    }
}
