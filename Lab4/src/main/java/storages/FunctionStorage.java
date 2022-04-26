package storages;


import entity.Function;
import entity.Point;
import exceptions.ElementDoesNotExistException;

import java.util.*;

public class FunctionStorage {
    private static final Map<Integer, Function> functions;

    static {
        functions = new HashMap<>();
        functions.put(1, new Function(Arrays.asList(
                new Point(1.2, 1.1),
                new Point(2.3, 3.8),
                new Point(3.5, 6.5),
                new Point(4.8, 10.2),
                new Point(6, 13.1),
                new Point(7.1, 16.3),
                new Point(8.5, 20.1)
        )));
        functions.put(2, new Function(Arrays.asList(
                new Point(1.1, 3.5),
                new Point(2.3, 4.1),
                new Point(3.7, 5.2),
                new Point(4.5, 6.9),
                new Point(5.4, 8.3),
                new Point(6.8, 14.8),
                new Point(7.5, 21.2)
        )));
        functions.put(3, new Function(Arrays.asList(
                new Point(1.3, 3.3),
                new Point(2.7, 4.7),
                new Point(3.9, 5.8),
                new Point(5.1, 7.4),
                new Point(5.9, 9.3),
                new Point(6.8, 15.8),
                new Point(7.9, 22.2)
        )));
    }

    public static Map<Integer, Function> getFunctions() {
        return functions;
    }

    public static Function getFunction(int number) throws ElementDoesNotExistException {
        if (getFunctions().containsKey(number)) return getFunctions().get(number);
        else throw new ElementDoesNotExistException();
    }

    public static void printFunctions() {
        int index = 1;
        for (Function function : functions.values()) {
            System.out.println("Функция " + index++);
            function.printPoints();
        }
    }
}