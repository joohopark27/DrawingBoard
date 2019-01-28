package main.java.drawable;

import main.java.Colors;
import main.java.DrawingBoard;
import main.java.Point;

public class Line implements Drawable {

    private Point p1, p2;

    private int stroke;
    private Colors color;

    public Line(Point p1, Point p2, Colors color){

        this(p1, p2, color, 1);

    }

    public Line(Point p1, Point p2, Colors color, int stroke){

        this.p1 = p1;
        this.p2 = p2;
        this.stroke = stroke;
        this.color = color;

    }

    public boolean intersects(Line anotherLine){

        if(isVertical() || anotherLine.isVertical()){

            if(isVertical() && anotherLine.isVertical()) {
                return p1.getX() == anotherLine.p1.getX();
            }else if(anotherLine.isVertical()){

                double a1 = getSlope();
                double b1 = getYIntercept();

                return isInRangeX(anotherLine.p1.getX()) && anotherLine.isInRangeY(a1 * anotherLine.p1.getX() + b1);

            }else{

                double a2 = anotherLine.getSlope();
                double b2 = anotherLine.getYIntercept();

                return anotherLine.isInRangeY(p1.getX()) && isInRangeY(a2 * p1.getX() + b2);

            }

        }

        double a1 = getSlope();
        double b1 = getYIntercept();
        double a2 = anotherLine.getSlope();
        double b2 = anotherLine.getYIntercept();

        if(a1 == a2){
            if(b1 != b2){
                return false;
            }

            return isInRangeX(anotherLine.p1.getX()) || isInRangeX(anotherLine.p2.getX());
        }

        double intersectionX = (b2 - b1) / (a1 - a2);

        return isInRangeX(intersectionX) && anotherLine.isInRangeX(intersectionX);

    }

    private double getSlope(){

        if(isVertical()){
            return Double.NaN;
        }

        return (p1.getY() - p2.getY()) / (p1.getX() - p2.getX());

    }

    private double getYIntercept(){

        return p1.getY() - getSlope() * p1.getX();

    }

    /**
     * checks if the x coordinate is inside the range
     */
    private boolean isInRangeX(double x){
        return (Math.min(p1.getX(), p2.getX()) <= x && Math.max(p1.getX(), p2.getX()) >= x);
    }

    /**
     * checks if the y coordinate is inside the range
     */
    private boolean isInRangeY(double y){
        return (Math.min(p1.getY(), p2.getY()) <= y && Math.max(p1.getY(), p2.getY()) >= y);
    }


    public boolean isVertical(){
        return p1.getX() == p2.getX();
    }

    public boolean isOnLine(int x, int y){

        if(!isInRangeX(x) || !isInRangeY(y)){
            return false;
        }else if(isVertical()){
            return x == p1.getX();
        }

        return (p1.getY() - y) * (x - p2.getX()) == (y - p2.getY()) * (p1.getX() - x);

    }

    @Override
    public void drawOn(DrawingBoard db) {

        if(Math.round(p1.getX()) == Math.round(p2.getX())){
            for(int y = (int) Math.round(p2.getY()); y != (int) Math.round(p1.getY()); y += (p2.getY() > p1.getY() ? -1 : 1)){

                for(int i = 0; i < stroke; i++) {
                    db.getImageArray()[y][(int) Math.round(p2.getX() + i - stroke / 2)] = color.getVal();
                }
            }
        }else {

            double slope = getSlope();

            if(Math.abs(slope) < 1) {
                for (int x = (int) Math.round(p2.getX()); x != Math.round(p1.getX()); x += (p2.getX() > p1.getX()) ? -1 : 1) {

                    for(int i = 0; i < stroke; i++) {
                        db.getImageArray()[(int) Math.round(p2.getY() + (x - p2.getX()) * slope + i - stroke / 2)][x] = color.getVal();
                    }

                }
            }else{
                for(int y = (int) Math.round(p2.getY()); y != (int) Math.round(p1.getY()); y += (p2.getY() > p1.getY() ? -1 : 1)){

                    for(int i = 0; i < stroke; i++) {
                        db.getImageArray()[y][(int) Math.round(p2.getX() + ((y - p2.getY()) / slope) + i - stroke / 2)] = color.getVal();
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
