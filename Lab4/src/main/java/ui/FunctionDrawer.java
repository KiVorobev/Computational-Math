package ui;

import entity.Function;
import entity.Point;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XYChart;
import org.knowm.xchart.XYChartBuilder;
import org.knowm.xchart.XYSeries;
import org.knowm.xchart.style.lines.SeriesLines;
import org.knowm.xchart.style.markers.SeriesMarkers;
import org.knowm.xchart.style.theme.GGPlot2Theme;

import java.awt.*;
import java.util.ArrayList;

public class FunctionDrawer {

    public static void getGraphOfFunction(Function function, Function firstApproximation, Function secondApproximation, Point extraPoint) {
        ArrayList<Double> xStartFunctionPoints = function.getArrayOfX();
        ArrayList<Double> yStartFunctionPoints = function.getArrayOfY();

        ArrayList<Double> xFirstApproximationPoints = firstApproximation.getArrayOfX();
        ArrayList<Double> yFirstApproximationPoints = firstApproximation.getArrayOfY();

        ArrayList<Double> xSecondApproximationPoints = secondApproximation.getArrayOfX();
        ArrayList<Double> ySecondApproximationPoints = secondApproximation.getArrayOfY();

        XYChart chart = new XYChartBuilder()
                .width(1024)
                .height(768)
                .title("Approximation")
                .xAxisTitle("X")
                .yAxisTitle("Y")
                .build();
        XYSeries functionDraw = chart.addSeries("Points", xStartFunctionPoints, yStartFunctionPoints);
        functionDraw.setLineStyle(SeriesLines.NONE);
        functionDraw.setMarkerColor(Color.RED);

        XYSeries firstApproximationDraw = chart.addSeries("Approximation", xFirstApproximationPoints, yFirstApproximationPoints);
        firstApproximationDraw.setMarker(SeriesMarkers.NONE);
        firstApproximationDraw.setLineStyle(SeriesLines.DASH_DASH);
        firstApproximationDraw.setLineColor(Color.BLUE);

        XYSeries secondApproximationDraw = chart.addSeries("Approximation without extra point", xSecondApproximationPoints, ySecondApproximationPoints);
        secondApproximationDraw.setMarker(SeriesMarkers.NONE);
        secondApproximationDraw.setLineStyle(SeriesLines.DASH_DASH);
        secondApproximationDraw.setLineColor(Color.MAGENTA);

        XYSeries exclusionPoint = chart.addSeries("Extra point", new double[]{extraPoint.getX()}, new double[]{extraPoint.getY()});
        exclusionPoint.setFillColor(Color.GREEN);

        chart.getStyler().setTheme(new GGPlot2Theme());
        new SwingWrapper(chart).displayChart();
    }
}
