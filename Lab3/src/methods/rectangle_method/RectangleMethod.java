package methods.rectangle_method;

import exceptions.FunctionDoesNotDefineException;
import exceptions.ImpossibleToBridgeTheGapException;
import integrals.Integral;
import service.LinePainter;

public interface RectangleMethod {

    static int getNumberOfSegments(double leftBorder, double rightBorder, double maxDerivative,
                                   double accuracy) {
        return (int) ((maxDerivative * Math.pow((rightBorder - leftBorder), 2)) / (2 * accuracy));
    }

    static double getStep(double leftBorder, double rightBorder, int numberOfSegments) {
        return (rightBorder - leftBorder) / numberOfSegments;
    }

    static double getFunctionValue(Double functionValue, double x, Integral integral) throws ImpossibleToBridgeTheGapException, FunctionDoesNotDefineException {
        if (functionValue.isNaN() || functionValue.isInfinite()) {
            if (Validator.checkFunctionForDefine(integral, x)) {
                if (Validator.checkFunctionForPossibilityToBridgeTheGap(integral, x)) {
                    System.out.println("Обнаружен устраняемый разрыв 1-го рода");
                    LinePainter.printLine();
                    functionValue = (integral.getFunction(x - 0.00001) + integral.getFunction(x + 0.00001)) / 2.0;
                } else throw new ImpossibleToBridgeTheGapException();
            } else throw new FunctionDoesNotDefineException();
        }
        return functionValue;
    }
}
