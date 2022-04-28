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

    public static void getGraphOfFunction(Function rungeKuttaFunction, Function analyticSolvingFunction) {
        ArrayList<Double> xRungeKuttaFunctionPoints = rungeKuttaFunction.getArrayOfX();
        ArrayList<Double> yRungeKuttaFunctionPoints = rungeKuttaFunction.getArrayOfY();

        ArrayList<Double> xAnalyticSolvingFunctionPoints = analyticSolvingFunction.getArrayOfX();
        ArrayList<Double> yAnalyticSolvingFunctionPoints = analyticSolvingFunction.getArrayOfY();

        double xStartPoint = rungeKuttaFunction.getPoints().get(0).getX();
        double yStartPoint = rungeKuttaFunction.getPoints().get(0).getY();

        XYChart chart = new XYChartBuilder()
                .width(1260)
                .height(768)
                .title("Approximation")
                .xAxisTitle("X")
                .yAxisTitle("Y")
                .build();

        XYSeries startPointDraw = chart.addSeries("Start point", new double[]{xStartPoint}, new double[]{yStartPoint});
        startPointDraw.setLineStyle(SeriesLines.NONE);

        XYSeries rungeKuttaFunctionDraw = chart.addSeries("Runge Kutta", xRungeKuttaFunctionPoints, yRungeKuttaFunctionPoints);
        rungeKuttaFunctionDraw.setLineStyle(SeriesLines.SOLID);
        rungeKuttaFunctionDraw.setLineColor(Color.ORANGE);
        rungeKuttaFunctionDraw.setMarker(SeriesMarkers.NONE);

        XYSeries analyticSolvingFunctionDraw = chart.addSeries("Analytic Solve", xAnalyticSolvingFunctionPoints, yAnalyticSolvingFunctionPoints);
        analyticSolvingFunctionDraw.setLineStyle(SeriesLines.SOLID);
        analyticSolvingFunctionDraw.setLineColor(Color.GREEN);
        analyticSolvingFunctionDraw.setMarker(SeriesMarkers.NONE);

        chart.getStyler().setTheme(new GGPlot2Theme());
        chart.getStyler().setCursorEnabled(true);
        new SwingWrapper(chart).displayChart();
    }
}
