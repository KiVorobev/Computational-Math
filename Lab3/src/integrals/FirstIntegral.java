package integrals;

public class FirstIntegral implements Integral {

    @Override
    public double getFunction(double x) {
        return -0.03 * Math.pow(x, 3) + 0.26 * x - 0.26;
    }

    @Override
    public double getDerivative(double x) {
        return -0.09 * Math.pow(x, 2) + 0.26;
    }

    @Override
    public String toString() {
        return "-0,03x^3 + 0,26x - 0,26";
    }
}
