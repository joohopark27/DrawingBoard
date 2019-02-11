package main.java.drawable.stroke;

import main.java.DrawingBoard;
import main.java.Point;

import java.util.ArrayList;

public class BezierCurve extends Stroke {

    private Point[] points;
    private final static double SMALL_NUM = 1e-5;

    public BezierCurve(Point p0, Point p1, ArrayList<Point> points){

        this.points = new Point[2 + points.size()];

        this.points[0] = p0;
        this.points[this.points.length - 1] = p1;

        for(int i = 1; i <= points.size(); i++){

            this.points[i] = points.get(i - 1);

        }

    }

    public BezierCurve(Point p0, Point p1, Point p2, Point p3){

        points = new Point[4];

        points[0] = p0;
        points[1] = p1;
        points[2] = p2;
        points[3] = p3;

    }

    public int bionomialCoefficient(int n, int k){

        int c = 1;

        for(int i = k + 1; i <= n; i++){

            c *= i;

        }

        for(int i = 1; i <= n - k; i++){

            c /= i;

        }

        return c;

    }

    public Point getPoint(double t){

        Point point = new Point(0, 0);

        for(int i = 0; i < points.length; i++){

            double mutiplier = bionomialCoefficient(points.length - 1, i) * Math.pow(1 - t, points.length - 1 - i) * Math.pow(t, i);

            point.move(mutiplier * points[i].getX(), mutiplier * points[i].getY());

        }

        return point;

    }

    @Override
    public void drawOn(DrawingBoard db) {

        for(double i = 0; i <= 1; i += SMALL_NUM){

            Point p = getPoint(i);

            drawAtPoint(db, p);

        }

    }

    @Override
    public boolean within(DrawingBoard db) {

        for(Point p: points){

            if(!p.within(db)){
                return false;
            }

        }

        return true;

    }
}
