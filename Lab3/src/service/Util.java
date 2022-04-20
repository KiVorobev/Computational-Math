package service;

import exceptions.FunctionDoesNotDefineException;
import exceptions.ImpossibleToBridgeTheGapException;
import exceptions.IntegralDoesNotExistException;
import integrals.IntegralStorage;

import methods.rectangle_method.RectangleMethodUtil;

public class Util {

    public static void systemStart() throws IntegralDoesNotExistException, ImpossibleToBridgeTheGapException, FunctionDoesNotDefineException {
        IntegralStorage.printIntegrals(IntegralStorage.getIntegrals());
        LinePainter.printLine();
        int numberOfIntegral = InputReader.readingChoiceOfIntegral();
        double[] bordersOfIntegration = InputReader.readingBordersOfIntegration();
        double accuracy = InputReader.readingAccuracy();
        LinePainter.printLine();
        double[] results = RectangleMethodUtil.getResults(bordersOfIntegration, accuracy, numberOfIntegral);
        System.out.print("Метод средних прямоугольников: ");
        System.out.printf("\u001B[34m" + results[0] + "\u001B[0m\n");
        LinePainter.printLine();
        System.out.print("Метод левых прямоугольников: ");
        System.out.printf("\u001B[34m" + results[1] + "\u001B[0m\n");
        LinePainter.printLine();
        System.out.print("Метод правых прямоугольников: ");
        System.out.printf("\u001B[34m" + results[2] + "\u001B[0m\n");
        LinePainter.printLine();
    }

}
