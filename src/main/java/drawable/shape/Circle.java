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

                double distance = center.distance(new Point(x, y));

                if(distance <= r + (strokeSize + 1) / 2 && distance >= r + strokeSize / 2){

                    db.getImageArray()[y][x] = strokeColor;

                }else if(isFilled && distance < r + strokeSize / 2){

                    db.getImageArray()[y][x] = (inverted) ? 0xFFFFFF - db.getImageArray()[y][x] : color;

                }

            }
        }

    }

    @Override
    public boolean within(DrawingBoard db) {
        return (center.getX() - r >= 0 && center.getY() - r >= 0) && (center.getX() + r <= db.getImageArray()[0].length && center.getY() + r <= db.getImageArray().length);
    }
}
