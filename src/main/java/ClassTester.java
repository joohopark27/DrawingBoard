package main.java;

import main.java.shape.*;

public class ClassTester {

    private static String filePath = "res/couplands.net's header.jpg";

    public static void main(String[] args) {

        DrawingBoard board = new DrawingBoard(filePath);
        //new DrawingBoard(100, 100).setVisible(true);

        Polygon polygon = new Polygon();
        polygon.add(new Point(300, 100));
        polygon.add(new Point(110, 100));
        polygon.add(new Point(110, 200));
        polygon.add(new Point(300, 200));
        polygon.changeColor(0x00FF00);
        polygon.drawOn(board);

        Shape rect = new Rectangle(new Point(100, 80), new Point(310, 210));
        rect.drawOn(board);

        Shape square = new Square(new Point(500, 100), 100);
        square.drawOn(board);

        Shape circle = new Circle(new Point(400, 150), 75);
        circle.changeColor(0x00FFFF);
        circle.drawOn(board);

        board.setVisible(true);

    }

}
