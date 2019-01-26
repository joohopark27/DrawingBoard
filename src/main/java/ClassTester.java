package main.java;

import main.java.drawable.Line;
import main.java.drawable.shape.*;

import java.io.IOException;

public class ClassTester {

    private static String filePath = "res/couplands.net's header.jpg";

    public static void main(String[] args) throws IOException {

        Drawing drawing = new Drawing(filePath);

//        Polygon polygon = new Polygon();
//        polygon.changeColor(0x00FF00);
//        polygon.add(new Point(300, 100));
//        polygon.add(new Point(60, 120));
//        polygon.add(new Point(20, 10));
//        polygon.add(new Point(210, 200));
//        polygon.add(new Point(400, 140));
//        drawing.add(polygon);

//        Shape rect = new Rectangle(new Point(100, 80), new Point(310, 210));
//        drawing.add(rect);
//
        Shape square = new Square(new Point(500, 100), 100);
        drawing.add(square);
//
//        Shape circle = new Circle(new Point(400, 150), 75);
//        circle.changeColor(0x00FFFF);
//        drawing.add(circle);

//        drawing.add(new Line(new Point(40, 40), new Point(130, 200), 0xFF00FF, 5));

        drawing.setVisable();

    }

}
