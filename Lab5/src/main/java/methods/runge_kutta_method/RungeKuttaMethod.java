package methods.runge_kutta_method;

import entity.Equation.Equation;
import entity.Point;

import java.util.ArrayList;
import java.util.List;

public class RungeKuttaMethod {
    public static List<Point> doMethod(double[] borders, double startY, double step, Equation equation) {
        List<Point> points = new ArrayList<>();
        double y = startY;
        points.add(new Point(borders[0], y));
        for (double x = borders[0]; x < borders[1] - step; x += step) {
            double k1 = getK1(x, y, step, equation);
            double k2 = getK2(x, y, step, k1, equation);
            double k3 = getK3(x, y, step, k2, equation);
            double k4 = getK4(x, y, step, k3, equation);
            double dy = getDy(k1, k2, k3, k4);
            y += dy;
            points.add(new Point(x + step, y));
        }
        return points;
    }

    public static double getK1(double x, double y, double step, Equation equation) {
        return step * equation.getDerivative(x, y);
    }

    public static double getK2(double x, double y, double step, double k1, Equation equation) {
        return step * equation.getDerivative(x + step / 2.0, y + k1 / 2.0);
    }

    public static double getK3(double x, double y, double step, double k2, Equation equation) {
        return step * equation.getDerivative(x + step / 2.0, y + k2 / 2.0);
    }

    public static double getK4(double x, double y, double step, double k3, Equation equation) {
        return step * equation.getDerivative(x + step, y + k3);
    }

    public static double getDy(double k1, double k2, double k3, double k4) {
        return (k1 + 2 * k2 + 2 * k3 + k4) / 6.0;
    }

    public static List<Point> getAnalyticSolve(double[] borders, double step, Equation equation) {
        List<Point> points = new ArrayList<>();
        for (double x = borders[0]; x < borders[1]; x += step) {
            points.add(new Point(x, equation.getAnalyticSolution(x)));
        }
        return points;
    }
}
