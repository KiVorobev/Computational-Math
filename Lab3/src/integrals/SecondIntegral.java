package integrals;

public class SecondIntegral implements Integral {

    @Override
    public double getFunction(double x) {
        return Math.sin(x) / x;
    }

    @Override
    public double getDerivative(double x) {
        return (Math.cos(x) / x) - (Math.sin(x) / Math.pow(x, 2));
    }

    @Override
    public String toString() {
        return "sin(x) / x";
    }
}
