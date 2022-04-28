package methods.least_square_method;

import entity.Function;
import exceptions.ElementDoesNotExistException;
import methods.least_square_method.approximation.Approximation;
import storages.ApproximationStorage;

public class LeastSquareMethod {

    public static double[] doMethod(Function function, int numberOfApproximation) throws ElementDoesNotExistException {
        Approximation approximation = ApproximationStorage.getApproximation(numberOfApproximation);
        return approximation.doApproximation(function);
    }
}
