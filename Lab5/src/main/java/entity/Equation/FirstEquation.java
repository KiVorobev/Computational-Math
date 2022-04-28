package entity.Equation;

public class FirstEquation implements Equation {

    @Override
    public double getDerivative(double x, double y) {
        return - 2 * y;
    }

    @Override
    public double getAnalyticSolution(double x) {
        return Math.exp(- 2 * x);
    }

    @Override
    public String toString() {
        return "- 2 * y";
    }
}
