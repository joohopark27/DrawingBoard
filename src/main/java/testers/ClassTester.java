package main.java.testers;

import main.java.Colors;
import main.java.Drawing;
import main.java.Point;
import main.java.drawable.Line;
import main.java.drawable.shape.*;

import java.io.IOException;

public class ClassTester {

    private static String filePath = "res/couplands.net's header.jpg";

    public static void main(String[] args) throws IOException {

        Drawing drawing = new Drawing(filePath);

        Polygon polygon = new Polygon();
        polygon.changeColor(Colors.BLUE);
        polygon.add(new Point(300, 100));
        polygon.add(new Point(60, 120));
        polygon.add(new Point(20, 10));
        polygon.add(new Point(210, 200));
        polygon.add(new Point(400, 140));
        polygon.fill(true);
        drawing.add(polygon);

        Shape rect = new Rectangle(new Point(650, 80), new Point(860, 210));
        rect.fill(true);
        drawing.add(rect);

        Shape square = new Square(new Point(500, 100), 100);
        square.fill(true);
        drawing.add(square);

        Shape circle = new Circle(new Point(500, 150), 75);
        circle.changeColor(Colors.GREEN);
        circle.fill(true);
//        drawing.add(circle);

        drawing.add(new Line(new Point(900, 40), new Point(800, 200), Colors.YELLOW, 5));

        drawing.show();

    }

}
