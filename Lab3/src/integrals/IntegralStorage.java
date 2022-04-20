package integrals;

import exceptions.IntegralDoesNotExistException;

import java.util.HashMap;
import java.util.Map;

public class IntegralStorage {
    private static final Map<Integer, Integral> integrals;

    static {
        integrals = new HashMap<>();
        integrals.put(1, new FirstIntegral());
        integrals.put(2, new SecondIntegral());
        integrals.put(3, new ThirdIntegral());
        integrals.put(4, new FourthIntegral());
        integrals.put(5, new FifthIntegral());
    }

    public static Map<Integer, Integral> getIntegrals() {
        return integrals;
    }

    public static Integral getIntegral(int number) throws IntegralDoesNotExistException {
        if (getIntegrals().containsKey(number)) return integrals.get(number);
        else throw new IntegralDoesNotExistException();
    }

    public static void printIntegrals(Map<Integer, Integral> store) {
        int index = 1;
        for (Integral integral : store.values()) {
            System.out.println(index + ") " + integral.toString());
            index++;
        }
    }
}
