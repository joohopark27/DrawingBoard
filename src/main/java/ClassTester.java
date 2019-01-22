package main.java;

import main.java.shape.Polygon;

public class ClassTester {

    private static String filePath = "res/couplands.net's header.jpg";

    public static void main(String[] args) {

        DrawingBoard board = new DrawingBoard(filePath);
        //new DrawingBoard(100, 100).setVisible(true);

        Polygon polygon = new Polygon();
        polygon.add(new Point(100, 100));
        polygon.add(new Point(110, 100));
        polygon.add(new Point(234, 12));
        polygon.add(new Point(24, 40));
        polygon.drawOn(board);

    }

}
