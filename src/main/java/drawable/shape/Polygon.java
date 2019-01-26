package main.java.drawable.shape;

import main.java.DrawingBoard;
import main.java.Point;
import main.java.drawable.Line;

import java.util.ArrayList;

public class Polygon extends Shape{

    private ArrayList<Point> points;
    private ArrayList<Line> lines;

    private double maxX, maxY, minX, minY;

    public Polygon(){

        super();

        points = new ArrayList<>();
        lines = new ArrayList<>();

    }

    public void add(Point point){

        points.add(point);

    }

    private void findMaxMin(){

        if(points.isEmpty()){
            maxX = -1;
            maxY = -1;
            minX = -1;
            minY = -1;
        }

        for (Point point: points) {
            maxX = (point.getX() > maxX) ? point.getX() : maxX;
            maxY = (point.getY() > maxX) ? point.getY() : maxY;
            minX = (point.getX() < maxX) ? point.getX() : minX;
            minY = (point.getY() < maxX) ? point.getY() : minY;
        }
    }

    public boolean isInside(Point p){

        if(p.getX() > maxX || p.getX() < minX || p.getY() > maxY || p.getY() < minY){
            return false;
        }



    }

    @Override
    public void drawOn(DrawingBoard db) {

        if (points.isEmpty()){
            return;
        }

        Point p1 = points.get(points.size() - 1);
        for(Point p2: points){
            lines.add(new Line(p1, p2, color, 1));
            p1 = p2;
        }
        for(Line line: lines) {
           line.drawOn(db);
        }



    }

    @Override
    public boolean within(DrawingBoard db) {

        for (Point point: points) {
            if(!point.within(db)){
                return false;
            }
        }

        return true;

    }
}
