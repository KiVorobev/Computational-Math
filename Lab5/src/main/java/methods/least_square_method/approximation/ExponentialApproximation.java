package methods.least_square_method.approximation;

import entity.Function;

public class ExponentialApproximation implements Approximation {
    @Override
    public double[] doApproximation(Function function) {
        int n = function.getPoints().size();
        double summaryOfMultipliedLnYAndX = Approximation.getSummaryOfMultipliedLnYAndX(function);
        double summaryX = Approximation.getSummaryOfValuesOfVariable(function.getArrayOfX());
        double summaryLnY = Approximation.getSummaryOfLnOfVariable(function.getArrayOfY());
        double summarySquaredX = Approximation.getSummaryOfSquaredValuesOfVariable(function.getArrayOfX());
        double b = Math.exp((n * summaryOfMultipliedLnYAndX - summaryX * summaryLnY) / (n * summarySquaredX - Math.pow(summaryX, 2)));
        double a = Math.exp(1.0 / n * summaryLnY - (Math.log(b) / n) * summaryX);
        return new double[]{a, b};
    }

    @Override
    public double getApproximationExpression(double x, double[] params) {
        return params[0] * Math.pow(params[1], x);
    }

    @Override
    public String toString() {
        return "Показательная функция аппроксимации";
    }
}
