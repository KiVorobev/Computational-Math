package integrals;

public class FourthIntegral implements Integral {

    @Override
    public double getFunction(double x) {
        return Math.log(x);
    }

    @Override
    public double getDerivative(double x) {
        return (1.0 / x);
    }

    @Override
    public String toString() {
        return "ln(x)";
    }
}
