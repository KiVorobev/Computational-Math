package storages.equation_system_storage;

public abstract class EquationSystem {

    public abstract double getFirstEquation(double x, double y);

    public abstract double getSecondEquation(double x, double y);

    public abstract double getDerivativeXOfFirstEquation(double x, double y);

    public abstract double getDerivativeXOfSecondEquation(double x, double y);

    public abstract double getDerivativeYOfFirstEquation(double x, double y);

    public abstract double getDerivativeYOfSecondEquation(double x, double y);
}
