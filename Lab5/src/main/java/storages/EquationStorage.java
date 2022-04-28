package storages;

import entity.Equation.Equation;
import entity.Equation.FirstEquation;
import entity.Equation.SecondEquation;
import entity.Equation.ThirdEquation;
import exceptions.ElementDoesNotExistException;

import java.util.HashMap;
import java.util.Map;

public class EquationStorage {
    private static final Map<Integer, Equation> equations;

    static {
        equations = new HashMap<>();
        equations.put(1, new FirstEquation());
        equations.put(2, new SecondEquation());
        equations.put(3, new ThirdEquation());
    }

    public static Map<Integer, Equation> getEquations() {
        return equations;
    }

    public static Equation getEquation(int number) throws ElementDoesNotExistException {
        if (getEquations().containsKey(number)) return getEquations().get(number);
        else throw new ElementDoesNotExistException();
    }

    public static void printEquations() {
        int index = 1;
        for (Equation equation : equations.values()) {
            System.out.println(index++ + ") y' = " + equation.toString());
        }
    }
}
