package main.java.drawable.shape;

import main.java.Point;

public class RightTriangle extends Polygon{

    public RightTriangle(Point p1, Point p2, String orientation){

        Point leftTopBoundary = new Point(Math.min(p1.getX(), p2.getX()), Math.max(p1.getY(), p2.getY()));
        Point rightBottomBoundary = new Point(Math.max(p1.getX(), p2.getX()), Math.min(p1.getY(), p2.getY()));

        add(new Point(rightBottomBoundary.getX(), leftTopBoundary.getY()));
        add(new Point(leftTopBoundary.getX(), leftTopBoundary.getY()));

        switch (orientation.toLowerCase()){
            case "lr":
                add(new Point(rightBottomBoundary.getX(), rightBottomBoundary.getY()));
                break;
            case "ul":
                add(new Point(rightBottomBoundary.getX(), rightBottomBoundary.getY()));
                rotate(180);
                break;
            case "ll":
                add(new Point(leftTopBoundary.getX(), rightBottomBoundary.getY()));
                break;
            case "ur":
                add(new Point(leftTopBoundary.getX(), rightBottomBoundary.getY()));
                rotate(180);
                break;
        }

    }

}
