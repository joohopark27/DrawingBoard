package main.java.testers;

import main.java.Colors;
import main.java.Drawing;
import main.java.Point;
import main.java.drawable.Recursions.*;
import main.java.drawable.shape.Rectangle;
import main.java.drawable.shape.Square;
import main.java.drawable.stroke.*;

public class RecursionTester {

    public static void main(String[] args) {

        Drawing drawing = new Drawing(1000, 1000);

//        Line line = new Line(new Point(500, 500), new Point(500, 300), Colors.GREEN);
//        Recursion<Line> tree = new Tree();
//        tree.draw(line, 15);
//
//        drawing.add(tree);

        Rectangle rt = new Rectangle(new Point(100, 100), new Point(900, 600));
        rt.changeColor(Colors.CYAN);
        rt.fill(true);

        SierpinskiCarpet carpet = new SierpinskiCarpet();
        carpet.draw(rt, 5);

        drawing.add(carpet);

        drawing.show();

    }

}
