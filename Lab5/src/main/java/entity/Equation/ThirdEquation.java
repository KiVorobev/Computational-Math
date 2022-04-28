package entity.Equation;

public class ThirdEquation implements Equation {

    @Override
    public double getDerivative(double x, double y) {
        return Math.exp(x - y);
    }

    @Override
    public double getAnalyticSolution(double x) {
        return Math.log(Math.exp(x));
    }

    @Override
    public String toString() {
        return "e^(x - y)";
    }
}
