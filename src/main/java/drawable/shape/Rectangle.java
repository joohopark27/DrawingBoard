package main.java.drawable.shape;

import main.java.Point;

public class Rectangle extends Polygon{

    private Point p1, p2;

    public Rectangle(Point center, double w, double h){

        this(new Point(center.getX() - w / 2, center.getY() - h / 2), new Point(center.getX() + w / 2, center.getY() + h / 2));

    }

    public Rectangle(Point p1, Point p2){

        super();

        this.p1 = p1;
        this.p2 = p2;

        add(p1);
        add(new Point(p1.getX(), p2.getY()));
        add(p2);
        add(new Point(p2.getX(), p1.getY()));

    }

    public double getX1(){

        return p1.getX();

    }

    public double getX2(){

        return p2.getX();

    }

    public double getY1(){

        return p1.getY();

    }

    public double getY2(){

        return p2.getY();

    }

}
