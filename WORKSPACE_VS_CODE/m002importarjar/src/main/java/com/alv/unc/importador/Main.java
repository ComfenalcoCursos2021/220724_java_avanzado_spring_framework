package com.alv.unc.importador;

import javax.swing.JFrame;

import org.math.plot.Plot2DPanel;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        double[] x = { 1, 2, 3, 4, 5, 6 };
        double[] y = { 45, 89, 6, 32, 63, 12 };

        // create your PlotPanel (you can use it as a JPanel)
        Plot2DPanel plot = new Plot2DPanel();

        // define the legend position
        plot.addLegend("SOUTH");

        // add a line plot to the PlotPanel
        plot.addLinePlot("my plot", x, y);

        // put the PlotPanel in a JFrame like a JPanel
        JFrame frame = new JFrame("a plot panel");
        frame.setSize(600, 600);
        frame.setContentPane(plot);
        frame.setVisible(true);
    }
}