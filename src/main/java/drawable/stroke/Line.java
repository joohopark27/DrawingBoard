package main.java.drawable.stroke;

import main.java.Colors;
import main.java.DrawingBoard;
import main.java.Point;
import main.java.drawable.Drawable;

public class Line extends Stroke implements Drawable {

    private Point p1, p2;

    public Line(Point p1, Point p2, Colors color){

        this(p1, p2, color, 1);

    }

    public Line(Point p1, Point p2, int color){

        this(p1, p2, color, 1);

    }

    public Line(Point p1, Point p2, Colors color, int stroke){

        this(p1, p2, color.getVal(), stroke);

    }

    public Line(Point p1, Point p2, int color, int stroke){

        super(stroke, color);
        this.p1 = p1;
        this.p2 = p2;

    }

    public void rotate(double angle){

        rotate(new Point((p1.getX() + p2.getX()) / 2, (p1.getY() + p2.getY()) / 2), angle);

    }

    public void rotate(Point p, double angle){

        p1.rotate(p, angle);
        p2.rotate(p, angle);

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

    public double getSlope(){

        if(isVertical()){
            return Double.NaN;
        }

        return (p1.getY() - p2.getY()) / (p1.getX() - p2.getX());

    }

    public double getYIntercept(){

        return p1.getY() - getSlope() * p1.getX();

    }

    public double getLength(){

        return p1.distance(p2);

    }

    public double getX1(){

        return p1.getX();

    }

    public double getY1(){

        return p1.getY();

    }

    public double getX2(){

        return p2.getX();

    }

    public double getY2(){

        return p2.getY();

    }

    public int getColor(){

        return color;

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

                drawAtPoint(db, p2.getX(), y);

            }
        }else {

            double slope = getSlope();

            if(Math.abs(slope) < 1) {
                for (int x = (int) Math.round(p2.getX()); x != Math.round(p1.getX()); x += (p2.getX() > p1.getX()) ? -1 : 1) {

                    drawAtPoint(db, x, p2.getY() + (x - p2.getX()) * slope);

                }
            }else{
                for(int y = (int) Math.round(p2.getY()); y != (int) Math.round(p1.getY()); y += (p2.getY() > p1.getY() ? -1 : 1)){

                    drawAtPoint(db, p2.getX() + ((y - p2.getY()) / slope), y);

                }
            }

        }

    }

    @Override
    public boolean within(DrawingBoard db) {
        return p1.within(db) && p2.within(db);
    }
}
