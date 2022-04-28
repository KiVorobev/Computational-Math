package storages;

import exceptions.ElementDoesNotExistException;
import methods.least_square_method.approximation.Approximation;
import methods.least_square_method.approximation.ExponentialApproximation;
import methods.least_square_method.approximation.LinearApproximation;
import methods.least_square_method.approximation.LogarithmicApproximation;

import java.util.HashMap;
import java.util.Map;

public class ApproximationStorage {

    private static final Map<Integer, Approximation> approximations;

    static {
        approximations = new HashMap<>();
        approximations.put(1, new LinearApproximation());
        approximations.put(2, new LogarithmicApproximation());
        approximations.put(3, new ExponentialApproximation());
    }

    public static Map<Integer, Approximation> getApproximations() {
        return approximations;
    }

    public static Approximation getApproximation(int number) throws ElementDoesNotExistException {
        if (getApproximations().containsKey(number)) return getApproximations().get(number);
        else throw new ElementDoesNotExistException();
    }

    public static void printApproximations() {
        int index = 1;
        for (Approximation approximation : approximations.values()) {
            System.out.println(index++ + ") " + approximation.toString());
        }
    }
}
