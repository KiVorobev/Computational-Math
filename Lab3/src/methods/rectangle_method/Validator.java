package methods.rectangle_method;

import integrals.Integral;

public class Validator {

    public static boolean checkFunctionForDefine(Integral integral, double x) {
        double left = integral.getFunction(x - 0.00001);
        double right = integral.getFunction(x + 0.00001);
        return !Double.isNaN(left) && !Double.isNaN(right);
    }

    public static boolean checkFunctionForPossibilityToBridgeTheGap(Integral integral, double x) {
        double diffValue = integral.getFunction(x + 0.00001) - integral.getFunction(x - 0.00001);
        return !Double.isNaN(diffValue) && !Double.isInfinite(diffValue) && (diffValue <= 0.00001);
    }
}
