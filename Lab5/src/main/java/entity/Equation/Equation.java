package entity.Equation;

public interface Equation {

    double getDerivative(double x, double y);

    double getAnalyticSolution(double x);
}
