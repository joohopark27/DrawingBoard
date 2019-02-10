package main.java.testers;

import main.java.Colors;
import main.java.Drawing;
import main.java.Point;
import main.java.drawable.Recursions.Recursion;
import main.java.drawable.Recursions.Tree;
import main.java.drawable.stroke.*;

public class RecursionTester {

    public static void main(String[] args) {

        Drawing drawing = new Drawing(1000, 1000);

        Line line = new Line(new Point(500, 900), new Point(500, 600), Colors.SADDLE_BROWN);
        Recursion<Line> tree = new Tree();
        tree.draw(line, 15);
        tree.draw(line, 15);

        drawing.add(tree);

        drawing.show();

    }

}
