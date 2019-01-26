package main.java;

public class Point {

    private double x;
    private double y;

    public Point(double x, double y){

        this.x = x;
        this.y = y;

    }

    public double getX(){
        return x;
    }

    public double getY(){
        return y;
    }

    public boolean within(DrawingBoard db){

        return (x >= 0 && x < db.getWidth()) && (y >= 0 && y < db.getHeight());

    }

}
