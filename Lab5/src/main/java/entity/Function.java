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

    public void printPoints() {
        System.out.println("   x   |   y   ");
        System.out.println("-------|-------");
        for (Point point : points) {
            System.out.printf("\u001B[34m" + "%.4f" + "\u001B[0m", point.getX());
            System.out.print(" | ");
            System.out.printf("\u001B[34m" + "%.4f\n" + "\u001B[0m", point.getY());

        }
    }
}
