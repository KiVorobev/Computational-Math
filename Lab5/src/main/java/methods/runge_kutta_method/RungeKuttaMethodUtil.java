package methods.runge_kutta_method;

import entity.Equation.Equation;
import entity.Function;
import exceptions.ElementDoesNotExistException;
import methods.least_square_method.LeastSquareMethodUtil;
import storages.EquationStorage;
import ui.FunctionDrawer;

public class RungeKuttaMethodUtil {
    public static void calculateAndGetResults(double[] borders, double y, double step, int numberOfEquation, int numberOfApproximation) throws ElementDoesNotExistException {
        Equation equation = EquationStorage.getEquation(numberOfEquation);
        Function result = new Function(RungeKuttaMethod.doMethod(borders, y, step, equation));
        result.printPoints();
        Function functionForChart = LeastSquareMethodUtil.getResults(result, numberOfApproximation);
        Function analyticSolve = new Function(RungeKuttaMethod.getAnalyticSolve(borders, step, equation));
        Function analyticForChart = LeastSquareMethodUtil.getResults(analyticSolve, numberOfApproximation);
        FunctionDrawer.getGraphOfFunction(functionForChart, analyticForChart);
    }
}
