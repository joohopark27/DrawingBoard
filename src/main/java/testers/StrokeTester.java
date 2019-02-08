package main.java.testers;

import main.java.Colors;
import main.java.Drawing;
import main.java.Point;
import main.java.drawable.ShapeGroup;
import main.java.drawable.shape.*;
import main.java.drawable.stroke.*;

import java.io.IOException;

public class StrokeTester {

    private static String filePath = "res/couplands.net's header.jpg";

    public static void main(String[] args) throws IOException {

        Drawing drawing = new Drawing(filePath);

        //add tester code here

        ShapeGroup curves = new ShapeGroup();
        for(int i = 0; i < 999; i ++){

            Stroke curve = new BezierCurve(new Point( 100, 100), new Point(Math.random() * 600 + 10, Math.random() * 180 + 10), new Point(800 - Math.random() * 600, Math.random() * 180 + 10), new Point(800 - Math.random() * 300, Math.random() * 180 + 10));
            curve.setColor((int)Math.round(Math.random() * 0xFFFFFF));
            curves.add(curve);

        }

        drawing.add(curves);

        drawing.show();

    }
}
