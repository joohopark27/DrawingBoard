package main.java.testers;

import main.java.Colors;
import main.java.Drawing;
import main.java.DrawingBoard;
import main.java.Point;
import main.java.drawable.shape.Polygon;

import java.io.IOException;

public class Tester {
    private static String filePath = "res/couplands.net's header.jpg";

    public static void main(String[] args) throws IOException {

        Drawing drawing = new Drawing(filePath);

        //add tester code here
        Polygon polygon = new Polygon();
        polygon.fill(true);
        polygon.changeColor(Colors.YELLOW);

        for(int i = 0; i < 50; i++){

            polygon.add(new Point(Math.random() * 800 + 10, Math.random() * 200 + 10));

        }

        drawing.add(polygon);

        drawing.show();

    }
}
