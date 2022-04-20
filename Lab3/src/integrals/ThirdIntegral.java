package integrals;

public class ThirdIntegral implements Integral {

    @Override
    public double getFunction(double x) {
        return 1 / x;
    }

    @Override
    public double getDerivative(double x) {
        return -(1 / Math.pow(x, 2));
    }

    @Override
    public String toString() {
        return "1 / x";
    }
}
