package main.java.testers;

import main.java.Colors;
import main.java.Drawing;
import main.java.Point;
import main.java.drawable.shape.RightTriangle;

import java.io.IOException;

public class TriangleTester {

    private static String filePath = "res/couplands.net's header.jpg";

    public static void main(String[] args) throws IOException {

        Drawing drawing = new Drawing(filePath);

        //add tester code here
        RightTriangle triangleUL = new RightTriangle(new Point(10, 90), new Point(90, 10), "UL");
        triangleUL.changeColor(Colors.YELLOW);
        triangleUL.fill(true);
        drawing.add(triangleUL);

        RightTriangle triangleUR = new RightTriangle(new Point(110, 90), new Point(190, 10), "UR");
        triangleUR.changeColor(Colors.YELLOW);
        triangleUR.fill(true);
        drawing.add(triangleUR);

        RightTriangle triangleLR = new RightTriangle(new Point(210, 90), new Point(290, 10), "LR");
        triangleLR.changeColor(Colors.YELLOW);
        triangleLR.fill(true);
        drawing.add(triangleLR);

        RightTriangle triangleLL = new RightTriangle(new Point(310, 90), new Point(390, 10), "LL");
        triangleLL.changeColor(Colors.YELLOW);
        triangleLL.fill(true);
        drawing.add(triangleLL);

        drawing.show();

    }
}
