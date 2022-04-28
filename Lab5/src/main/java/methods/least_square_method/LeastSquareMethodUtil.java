package methods.least_square_method;

import entity.Function;
import entity.Point;
import exceptions.ElementDoesNotExistException;
import storages.ApproximationStorage;

import java.util.ArrayList;
import java.util.List;

public class LeastSquareMethodUtil {

    public static Function getResults(Function function, int numberOfApproximation) throws ElementDoesNotExistException {
        double[] result = LeastSquareMethod.doMethod(function, numberOfApproximation);
        Function functionForChart = getFunctionForChart(function, numberOfApproximation, result);
        return functionForChart;
    }

    private static Function getFunctionForChart(Function startFunction, int numberOfApproximation, double[] params) throws ElementDoesNotExistException {
        List<Point> functionForChart = new ArrayList<>();
        double firstX = startFunction.getArrayOfX().get(0);
        double lastX = startFunction.getArrayOfX().get(startFunction.getPoints().size() - 1);
        double step = (lastX - firstX) / 49.0;
        for (int i = 0; i < 50; i++) {
            double x = firstX + step * i;
            double y = ApproximationStorage.getApproximation(numberOfApproximation).getApproximationExpression(x, params);
            functionForChart.add(new Point(x, y));
        }
        return new Function(functionForChart);
    }
}