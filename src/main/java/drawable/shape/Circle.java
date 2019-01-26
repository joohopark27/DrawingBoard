package main.java.drawable.shape;

import main.java.DrawingBoard;
import main.java.Point;

public class Circle extends Shape {

    private double r;
    private Point center;

    public Circle(Point center, double r){
        this.r = r;
        this.center = center;
    }

    @Override
    public void drawOn(DrawingBoard db) {

        for(int y = (int) Math.round(center.getY() - r); y <= Math.round(center.getY() + r); y++){
            for(int x = (int) Math.round(center.getX() - r); x <= Math.round(center.getX() + r); x++){

                if((center.getX() - x) * (center.getX() - x) + (center.getY() - y) * (center.getY() - y) <= r * r){

                    db.getImageArray()[y][x] = color;

                }

            }
        }

    }

    @Override
    public boolean within(DrawingBoard db) {
        return (center.getX() - r >= 0 && center.getY() - r >= 0) && (center.getX() + r <= db.getImageArray()[0].length && center.getY() + r <= db.getImageArray().length);
    }
}
