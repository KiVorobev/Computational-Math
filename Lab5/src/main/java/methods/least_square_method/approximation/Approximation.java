package methods.least_square_method.approximation;

import entity.Function;
import entity.Point;

import java.util.ArrayList;

public interface Approximation {

    double[] doApproximation(Function function);

    double getApproximationExpression(double x, double[] params);

    static double getSummaryOfLnOfVariable(ArrayList<Double> list) {
        double summary = 0.0;
        for (double value : list) {
            summary += Math.log(value);
        }
        return summary;
    }

    static double getSummaryOfSquaredLnOfVariable(ArrayList<Double> list) {
        double summary = 0.0;
        for (double value : list) {
            summary += Math.pow(Math.log(value), 2);
        }
        return summary;
    }

    static double getSummaryOfMultipliedLnXAndY(Function function) {
        double summary = 0.0;
        for (Point point : function.getPoints()) {
            summary += point.getY() * Math.log(point.getX());
        }
        return summary;
    }

    static double getSummaryOfMultipliedLnYAndX(Function function) {
        double summary = 0.0;
        for (Point point : function.getPoints()) {
            summary += point.getX() * Math.log(point.getY());
        }
        return summary;
    }

    static double getSummaryOfValuesOfVariable(ArrayList<Double> list) {
        double summary = 0.0;
        for (double value : list) {
            summary += value;
        }
        return summary;
    }

    static double getSummaryOfSquaredValuesOfVariable(ArrayList<Double> list) {
        double summary = 0.0;
        for (double value : list) {
            summary += Math.pow(value, 2);
        }
        return summary;
    }

    static double getSummaryOfMultipliedVariableValues(Function function) {
        double summary = 0.0;
        for (Point point : function.getPoints()) {
            summary += point.getX() * point.getY();
        }
        return summary;
    }
}
