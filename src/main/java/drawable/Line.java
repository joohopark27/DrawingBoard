package main.java.drawable;

import main.java.DrawingBoard;
import main.java.Point;

public class Line implements Drawable {

    private Point p1, p2;

    private int stroke;
    private int color;

    public Line(Point p1, Point p2, int color){

        this(p1, p2, color, 1);

    }

    public Line(Point p1, Point p2, int color, int stroke){

        this.p1 = p1;
        this.p2 = p2;
        this.stroke = stroke;
        this.color = color;

    }

    public boolean isOnLine(int x, int y){

        if((p1.getX() == x && p1.getY() == y) || (p2.getX() == x && p2.getY() == y)){
            return true;
        }else if((p1.getX() < x ^ p2.getX() > x) || (p1.getY() < y ^ p2.getY() > y)){
            return false;
        }else if(p1.getX() == p2.getX()){
            return x == p1.getX();
        }

        return (p1.getY() - y) * (x - p2.getX()) == (y - p2.getY()) * (p1.getX() - x);

    }

    @Override
    public void drawOn(DrawingBoard db) {

        if(Math.round(p1.getX()) == Math.round(p2.getX())){
            for(int y = (int) Math.round(p2.getY()); y != (int) Math.round(p1.getY()); y += (p2.getY() > p1.getY() ? -1 : 1)){

                for(int i = 0; i < stroke; i++) {
                    db.getImageArray()[y][(int) Math.round(p2.getX() + i - stroke / 2)] = color;
                }
            }
        }else {

            double slope = (p1.getY() - p2.getY()) / (p1.getX() - p2.getX());

            if(Math.abs(slope) < 1) {
                for (int x = (int) Math.round(p2.getX()); x != Math.round(p1.getX()); x += (p2.getX() > p1.getX()) ? -1 : 1) {

                    for(int i = 0; i < stroke; i++) {
                        db.getImageArray()[(int) Math.round(p2.getY() + (x - p2.getX()) * slope + i - stroke / 2)][x] = color;
                    }

                }
            }else{
                for(int y = (int) Math.round(p2.getY()); y != (int) Math.round(p1.getY()); y += (p2.getY() > p1.getY() ? -1 : 1)){

                    for(int i = 0; i < stroke; i++) {
                        db.getImageArray()[y][(int) Math.round(p2.getX() + ((y - p2.getY()) / slope) + i - stroke / 2)] = color;
                    }
                }
            }

        }

    }

    @Override
    public boolean within(DrawingBoard db) {
        return p1.within(db) && p2.within(db);
    }
}
