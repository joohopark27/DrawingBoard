package main.java.drawable.shape;

import main.java.Point;

public class RegularPolygon extends Polygon{

    public RegularPolygon(Point center, int n, double l){

        super();

        double distFromCenter = l / 2 / Math.cos((1 - 1 / n) * Math.PI);

        for(int i = 0; i < n; i++){

            double angle = 2 * Math.PI / n * i;
            add(new Point(center.getX() + Math.cos(angle) * distFromCenter, center.getY() + Math.sin(angle) * distFromCenter));

        }

        fill(true);

    }

}
