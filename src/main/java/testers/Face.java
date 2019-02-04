package main.java.testers;

import main.java.Colors;
import main.java.Drawing;
import main.java.Point;
import main.java.drawable.*;
import main.java.drawable.shape.*;

import java.io.IOException;

public class Face {

    private static String filePath = "res/couplands.net's header.jpg";

    public static void main(String[] args) throws IOException {

        Drawing drawing = new Drawing(filePath);

        Shape base = new Ellipse(new Point(100, 100), 150, 150);
        base.fill(true);
        base.changeColor(Colors.YELLOW);
        drawing.add(base);

        Shape leftEye = new Ellipse(new Point(70, 60), 30, 10);
        leftEye.fill(true);
        leftEye.changeColor(Colors.BLACK);
        drawing.add(leftEye);

        Shape rightEye = new Ellipse(new Point(130, 60), 30, 10);
        rightEye.fill(true);
        rightEye.changeColor(Colors.BLACK);
        drawing.add(rightEye);

        Shape mouth = new Ellipse(new Point(100, 130), 70, 20);
        mouth.setStrokeSize(5);
        drawing.add(mouth);

        drawing.show();

    }

}
