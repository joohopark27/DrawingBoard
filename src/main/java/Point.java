package main.java;

public class Point {

    private double x;
    private double y;

    final static double SMALL_NUMBER = 1e-5;

    public Point(double x, double y){

        this.x = x;
        this.y = y + SMALL_NUMBER;

    }

    public double getX(){
        return x;
    }

    public double getY(){
        return y;
    }

    public void move(double x, double y){

        this.x += x;
        this.y += y;

    }

    public double distance(Point p){

        return Math.sqrt(Math.pow(x - p.x, 2) + Math.pow(y - p.y, 2));

    }

    public void rotate(Point center, double angle){

        angle *= Math.PI / 180;

        double xDist = x - center.x;
        double yDist = y - center.y;

        x = xDist * Math.cos(angle) - yDist * Math.sin(angle) + center.x;
        y = yDist * Math.cos(angle) + xDist * Math.sin(angle) + center.y;

    }

    public boolean within(DrawingBoard db){

        return (x >= 0 && x < db.getWidth()) && (y >= 0 && y < db.getHeight());

    }

}
