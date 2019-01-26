package main.java.drawable.shape;

import main.java.Point;

public class Rectangle extends Polygon{

    public Rectangle(Point center, double w, double h){

        this(new Point(center.getX() - w / 2, center.getY() - h / 2), new Point(center.getX() + w / 2, center.getY() + h / 2));

    }

    public Rectangle(Point p1, Point p2){

        super();

        add(p1);
        add(new Point(p1.getX(), p2.getY()));
        add(p2);
        add(new Point(p2.getX(), p1.getY()));

    }

}
