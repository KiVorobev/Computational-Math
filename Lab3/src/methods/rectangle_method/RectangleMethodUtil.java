package methods.rectangle_method;

import exceptions.FunctionDoesNotDefineException;
import exceptions.ImpossibleToBridgeTheGapException;
import exceptions.IntegralDoesNotExistException;
import integrals.Integral;
import integrals.IntegralStorage;

public class RectangleMethodUtil {

    public static double[] getResults(double[] bordersOfIntegration, double accuracy, int numberOfIntegral) throws IntegralDoesNotExistException, FunctionDoesNotDefineException, ImpossibleToBridgeTheGapException {
        Integral integral = IntegralStorage.getIntegral(numberOfIntegral);
        double maxDerivative = getMaxDerivative(bordersOfIntegration[0], bordersOfIntegration[1], integral);
        int numberOfSegments = RectangleMethod.getNumberOfSegments(bordersOfIntegration[0], bordersOfIntegration[1], maxDerivative, accuracy);
        double step = RectangleMethod.getStep(bordersOfIntegration[0], bordersOfIntegration[1], numberOfSegments);
        double middle = MiddleRectangleMethod.doMethod(bordersOfIntegration[0], numberOfSegments, step, integral);
        double left = LeftRectangleMethod.doMethod(bordersOfIntegration[0], numberOfSegments, step, integral);
        double right = RightRectangleMethod.doMethod(bordersOfIntegration[0], numberOfSegments, step, integral);
        return new double[]{middle, left, right};
    }

    private static Double getMaxDerivative(double leftBorder, double rightBorder, Integral integral) throws FunctionDoesNotDefineException, ImpossibleToBridgeTheGapException {
        double leftDerivative = Math.abs(RectangleMethod.getFunctionValue(integral.getDerivative(leftBorder), leftBorder, integral));
        double rightDerivative = Math.abs(RectangleMethod.getFunctionValue(integral.getDerivative(rightBorder), rightBorder, integral));
        return Math.max(leftDerivative, rightDerivative);
    }
}
