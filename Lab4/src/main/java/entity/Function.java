package entity;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Function {
    private List<Point> points;

    public Function(List<Point> pointList) {
        points = pointList;
    }

    public void printPoints() {
        ArrayList<Double> xArray = getArrayOfX();
        ArrayList<Double> yArray = getArrayOfY();
        printLineOfVariable("x", xArray);
        printLineOfVariable("y", yArray);
    }

    public ArrayList<Double> getArrayOfX() {
        ArrayList<Double> xArray = new ArrayList<>();
        for (Point points : getPoints()) {
            xArray.add(points.getX());
        }
        return xArray;
    }

    public ArrayList<Double> getArrayOfY() {
        ArrayList<Double> yArray = new ArrayList<>();
        for (Point points : getPoints()) {
            yArray.add(points.getY());
        }
        return yArray;
    }

    private void printLineOfVariable(String headerValue, ArrayList<Double> array) {
        System.out.print(headerValue + " | ");
        for (Double variable : array) {
            System.out.print(variable + " | ");
        }
        System.out.println();
    }
}
