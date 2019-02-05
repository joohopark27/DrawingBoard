package main.java.testers;

import main.java.Colors;
import main.java.Drawing;
import main.java.Point;
import main.java.drawable.stroke.Line;
import main.java.drawable.ShapeGroup;
import main.java.drawable.shape.Polygon;

import java.io.IOException;

public class Tester {
    private static String filePath = "res/couplands.net's header.jpg";

    public static void main(String[] args) throws IOException {

        Drawing drawing = new Drawing(filePath);

        //add tester code here
        Polygon polygon = new Polygon();
        polygon.fill(true);
        polygon.changeColor(Colors.GREEN);
        polygon.changeStrokeColor(Colors.WHITE);

        for(int i = 0; i < 90; i++){

            polygon.add(new Point(Math.random() * 800 + 10, Math.random() * 200 + 10));

        }

        ShapeGroup lines = new ShapeGroup();

        for(int x = 400, y = 0; x >= 0; x -= 2, y ++){
            Line line = new Line(new Point(x, 0), new Point(0, y), Colors.YELLOW);
            lines.add(line);
        }

        drawing.add(lines);
        drawing.add(polygon);

        drawing.show();

    }
}
