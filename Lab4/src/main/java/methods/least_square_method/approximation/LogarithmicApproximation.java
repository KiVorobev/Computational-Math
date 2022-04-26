package methods.least_square_method.approximation;

import entity.Function;

public class LogarithmicApproximation implements Approximation {

    @Override
    public double[] doApproximation(Function function) {
        int n = function.getPoints().size();
        double summaryY = Approximation.getSummaryOfValuesOfVariable(function.getArrayOfY());
        double summarySquaredLnX = Approximation.getSummaryOfSquaredLnOfVariable(function.getArrayOfX());
        double summaryOfMultipliedLnXAndY = Approximation.getSummaryOfMultipliedLnXAndY(function);
        double summaryLnX = Approximation.getSummaryOfLnOfVariable(function.getArrayOfX());
        double a = (summaryY * summarySquaredLnX - summaryOfMultipliedLnXAndY * summaryLnX) / (n * summarySquaredLnX - Math.pow(summaryLnX, 2));
        double b = (n * summaryOfMultipliedLnXAndY - summaryY * summaryLnX) / (n * summarySquaredLnX - Math.pow(summaryLnX, 2));
        return new double[]{a, b};
    }

    @Override
    public double getApproximationExpression(double x, double[] params) {
        return params[0] + params[1] * Math.log(x);
    }

    @Override
    public String toString() {
        return "Логарифмическая функция аппроксимации";
    }
}
