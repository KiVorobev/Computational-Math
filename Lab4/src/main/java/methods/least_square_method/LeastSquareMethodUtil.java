package methods.least_square_method;

import entity.Function;
import entity.Point;
import exceptions.ElementDoesNotExistException;
import service.LinePainter;
import storages.ApproximationStorage;
import storages.FunctionStorage;
import ui.FunctionDrawer;

import java.util.ArrayList;
import java.util.List;

public class LeastSquareMethodUtil {

    public static void calculateAndGetResults(int numberOfFunction, int numberOfApproximation) throws ElementDoesNotExistException {
        Function startFunction = FunctionStorage.getFunction(numberOfFunction);
        double[] firstResult = LeastSquareMethod.doMethod(startFunction, numberOfApproximation);
        printResultHeader(1);
        printResult(firstResult);
        LinePainter.printLine();
        Point extraPoint = getExtraPoint(startFunction.getPoints(), firstResult);
        Function functionWithoutExtraPoint = getFunctionWithoutExtraPoint(startFunction.getPoints(), extraPoint);
        double[] secondResult = LeastSquareMethod.doMethod(functionWithoutExtraPoint, numberOfApproximation);
        printResultHeader(2);
        printResult(secondResult);
        Function firstFunction = getFunctionForChart(startFunction, numberOfApproximation, firstResult);
        Function secondFunction = getFunctionForChart(startFunction, numberOfApproximation, secondResult);
        FunctionDrawer.getGraphOfFunction(startFunction, firstFunction, secondFunction, extraPoint);
    }

    private static Point getExtraPoint(List<Point> list, double[] result) {
        Point extraPoint = null;
        double maxDistance = -1.0;
        for (Point point : list) {
            double distance = Math.abs(point.getY() - (point.getX() * result[0] + result[1]));
            if (distance > maxDistance) {
                extraPoint = new Point(point.getX(), point.getY());
                maxDistance = distance;
            }
        }
        return extraPoint;
    }

    private static Function getFunctionWithoutExtraPoint(List<Point> list, Point extraPoint) {
        List<Point> newList = new ArrayList<>();
        for (Point point : list) {
            if (!(point.getX() == extraPoint.getX() && point.getY() == extraPoint.getY())) {
                newList.add(point);
            }
        }
        return new Function(newList);
    }

    private static Function getFunctionForChart(Function startFunction, int numberOfApproximation, double[] params) throws ElementDoesNotExistException {
        List<Point> functionForChart = new ArrayList<>();
        double firstX = startFunction.getArrayOfX().get(0);
        double lastX = startFunction.getArrayOfX().get(startFunction.getPoints().size() - 1);
        double step = (lastX - firstX) / 99.0;
        for (int i = 0; i < 100; i++) {
            double x = firstX + step * i;
            double y = ApproximationStorage.getApproximation(numberOfApproximation).getApproximationExpression(x, params);
            functionForChart.add(new Point(x, y));
        }
        return new Function(functionForChart);
    }

    private static void printResult(double[] result) {
        char letter = 'a';
        for (int i = 0; i < result.length; i++, letter++) {
            System.out.println(letter + ": " + result[i]);
        }
    }

    private static void printResultHeader(int index) {
        System.out.println("Результат " + index + ":");
    }
}
