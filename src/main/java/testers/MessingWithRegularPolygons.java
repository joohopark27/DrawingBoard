package main.java.testers;

import main.java.Drawing;
import main.java.Point;
import main.java.drawable.shape.Polygon;
import main.java.drawable.shape.RegularPolygon;

import java.io.IOException;

public class MessingWithRegularPolygons {

    private static String filePath = "res/couplands.net's header.jpg";

    public static void main(String[] args) throws IOException {

        Drawing d = new Drawing(filePath);

        Polygon tri = new RegularPolygon(new Point(50, 50), 3, 40 * Math.cos(Math.PI * (1 - 1.0 / 3)) * 2);
        Polygon squ = new RegularPolygon(new Point(150, 50), 4, 40 * Math.cos(Math.PI * (1 - 1.0 / 4)) * 2);
        squ.rotate(45);
        Polygon pent = new RegularPolygon(new Point(250, 50), 5, 40 * Math.cos(Math.PI * (1 - 1.0 / 5)) * 2);
        pent.rotate(90);
        Polygon hex = new RegularPolygon(new Point(350, 50), 6, 40 * Math.cos(Math.PI * (1 - 1.0 / 6)) * 2);
        hex.rotate(30);
        Polygon sevenSide = new RegularPolygon(new Point(450, 50), 7, 40 * Math.cos(Math.PI * (1 - 1.0 / 7)) * 2);
        sevenSide.rotate(777);
        Polygon oct = new RegularPolygon(new Point(550, 50), 8, 40 * Math.cos(Math.PI * (1 - 1.0 / 8)) * 2);
        Polygon nonagon = new RegularPolygon(new Point(650, 50), 9, 40 * Math.cos(Math.PI * (1 - 1.0 / 9)) * 2);

        int n = 12;
        Polygon nGon = new RegularPolygon(new Point(800, 100), n, 95 * Math.cos(Math.PI * (1 - 1.0 / n)) * 2);

        d.add(tri);
        d.add(squ);
        d.add(pent);
        d.add(hex);
        d.add(sevenSide);
        d.add(oct);
        d.add(nonagon);
        d.add(nGon);

        d.setVisable();

    }
}
