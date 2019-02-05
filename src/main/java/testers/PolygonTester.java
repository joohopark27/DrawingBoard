package main.java.testers;

import main.java.Colors;
import main.java.Drawing;
import main.java.Point;
import main.java.drawable.stroke.Line;
import main.java.drawable.shape.*;

import java.io.IOException;

public class PolygonTester {

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

        Polygon rect = new Rectangle(new Point(650, 50), new Point(860, 110));
        rect.fill(true);
        rect.rotate(20);
        drawing.add(rect);

        Shape square = new Square(new Point(500, 100), 100);
        square.fill(true);
        drawing.add(square);

        Shape circle = new Circle(new Point(550, 150), 75);
        circle.changeColor(Colors.GREEN);
        circle.fill(true);
        drawing.add(circle);

        drawing.add(new Line(new Point(900, 40), new Point(800, 200), Colors.YELLOW, 5));

        drawing.show();

    }

}
