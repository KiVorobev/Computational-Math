package integrals;

public class FifthIntegral implements Integral {

    @Override
    public double getFunction(double x) {
        return 4 - Math.pow(x, 2);
    }

    @Override
    public double getDerivative(double x) {
        return -2 * x;
    }

    @Override
    public String toString() {
        return "4 - x^2";
    }
}
