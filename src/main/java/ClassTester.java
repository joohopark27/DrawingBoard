package main.java;

import main.java.drawable.Line;
import main.java.drawable.shape.*;

import java.io.IOException;

public class ClassTester {

    private static String filePath = "res/couplands.net's header.jpg";

    public static void main(String[] args) throws IOException {

        Drawing drawing = new Drawing(filePath);

//        testing1(drawing);
        testingPolygons(drawing);

        drawing.setVisable();

    }

    private static void testingPolygons(Drawing d){

        Polygon tri = new RegularPolygon(new Point(50, 50), 3, 40 * Math.cos(Math.PI * (1 - 1 / 3)) * 2);
        Polygon squ = new RegularPolygon(new Point(150, 50), 4, 40 * Math.cos(Math.PI * (1 - 1 / 4)) * 2);
        Polygon pent = new RegularPolygon(new Point(250, 50), 5, 40 * Math.cos(Math.PI * (1 - 1 / 5)) * 2);
        Polygon hex = new RegularPolygon(new Point(350, 50), 6, 40 * Math.cos(Math.PI * (1 - 1 / 6)) * 2);
        Polygon sevenSide = new RegularPolygon(new Point(450, 50), 7, 40 * Math.cos(Math.PI * (1 - 1 / 7)) * 2);
        Polygon oct = new RegularPolygon(new Point(550, 50), 8, 40 * Math.cos(Math.PI * (1 - 1 / 8)) * 2);
        Polygon nonagon = new RegularPolygon(new Point(650, 50), 9, 40 * Math.cos(Math.PI * (1 - 1 / 9)) * 2);

        d.add(tri);
        d.add(squ);
        d.add(pent);
        d.add(hex);
        d.add(sevenSide);
        d.add(oct);
        d.add(nonagon);

    }

    private static void testing1(Drawing d){

        Polygon polygon = new Polygon();
        polygon.changeColor(0x00FF00);
        polygon.add(new Point(300, 100));
        polygon.add(new Point(60, 120));
        polygon.add(new Point(20, 10));
        polygon.add(new Point(210, 200));
        polygon.add(new Point(400, 140));
        d.add(polygon);

        Shape rect = new Rectangle(new Point(650, 80), new Point(860, 210));
        d.add(rect);

        Shape square = new Square(new Point(500, 100), 100);
        d.add(square);

        Shape circle = new Circle(new Point(400, 150), 75);
        circle.changeColor(0x00FFFF);
        d.add(circle);

        d.add(new Line(new Point(900, 40), new Point(800, 200), 0xFF00FF, 5));

    }

}
