package main.java.drawable.stroke;

import main.java.DrawingBoard;
import main.java.Point;

public class BezierCurve extends Stroke {

    private Point p0, p1, p2, p3;
    private final static double SMALL_NUM = 1e-5;

    public BezierCurve(Point p0, Point p1, Point p2, Point p3){

        this.p0 = p0;
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;

    }

    @Override
    public void drawOn(DrawingBoard db) {

        for(double i = 0; i <= 1; i += SMALL_NUM){

            Point q1 = findPointBetween(p0, p1, i);
            Point q2 = findPointBetween(p1, p2, i);
            Point q3 = findPointBetween(p2, p3, i);

            Point r1 = findPointBetween(q1, q2, i);
            Point r2 = findPointBetween(q2, q3, i);

            Point point = findPointBetween(r1, r2, i);
            drawAtPoint(db, point.getX(), point.getY());

        }

    }

    private Point findPointBetween(Point p1, Point p2, double percentage){

        return new Point((p2.getX() - p1.getX()) * percentage + p1.getX(), (p2.getY() - p1.getY()) * percentage + p1.getY());

    }

    @Override
    public boolean within(DrawingBoard db) {
        return p0.within(db) && p1.within(db) && p2.within(db) && p3.within(db);
    }
}
