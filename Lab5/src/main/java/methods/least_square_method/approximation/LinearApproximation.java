package methods.least_square_method.approximation;

import entity.Function;

public class LinearApproximation implements Approximation {

    @Override
    public double[] doApproximation(Function function) {
        int n = function.getPoints().size();
        double summaryX = Approximation.getSummaryOfValuesOfVariable(function.getArrayOfX());
        double summaryY = Approximation.getSummaryOfValuesOfVariable(function.getArrayOfY());
        double summarySquaredX = Approximation.getSummaryOfSquaredValuesOfVariable(function.getArrayOfX());
        double summaryXY = Approximation.getSummaryOfMultipliedVariableValues(function);
        double a = (n * summaryXY - summaryX * summaryY) / (n * summarySquaredX - Math.pow(summaryX, 2));
        double b = (summaryY - a * summaryX) / n;
        return new double[]{a, b};
    }

    @Override
    public double getApproximationExpression(double x, double[] params) {
        return x * params[0] + params[1];
    }

    @Override
    public String toString() {
        return "Линейная функция аппроксимации";
    }
}
