package methods.rectangle_method;

import exceptions.FunctionDoesNotDefineException;
import exceptions.ImpossibleToBridgeTheGapException;
import integrals.Integral;

public class RightRectangleMethod implements RectangleMethod {

    public static double doMethod(double leftBorder, int numberOfSegments, double step, Integral integral) throws ImpossibleToBridgeTheGapException, FunctionDoesNotDefineException {
        double sum = 0.0;
        for (int i = 1; i <= numberOfSegments; i++) {
            double x = leftBorder + i * step;
            double functionValue = RectangleMethod.getFunctionValue(integral.getFunction(x), x, integral);
            sum += step * functionValue;
        }
        return sum;
    }
}
