package main.java.drawable.shape;

import main.java.DrawingBoard;
import main.java.Point;
import main.java.drawable.stroke.Line;

import java.util.ArrayList;

public class Polygon extends Shape{

    private ArrayList<Point> points;
    private ArrayList<Line> lines;

    private double maxX, maxY, minX, minY;

    private final static float BIG_NUM = 1000000;
    final static double SMALL_NUMBER = 1e-5;

    public Polygon(){

        super();

        points = new ArrayList<>();
        lines = new ArrayList<>();

        maxX = -1;
        maxY = -1;
        minX = BIG_NUM;
        minY = BIG_NUM;

    }

    public void add(Point point){

        point.move(0, SMALL_NUMBER);
        points.add(point);

        maxX = Math.max(point.getX(), maxX);
        maxY = Math.max(point.getY(), maxY);
        minX = Math.min(point.getX(), minX);
        minY = Math.min(point.getY(), minY);

    }

    public void rotate(double angle){

        Point center = new Point((maxX + minX) / 2, (minY + maxY) / 2);

        for (Point p: points){

            p.rotate(center, angle);

        }

        findMaxMin();

    }

    public boolean isInside(Point p){

        if(p.getX() > maxX || p.getX() < minX || p.getY() > maxY || p.getY() < minY){
            return false;
        }

        Line ray = new Line(p, new Point(BIG_NUM, p.getY()), color);

        boolean result = false;

        for(Line line: lines){
            if(ray.intersects(line)){
                result = !result;
            }
        }

        return result;

    }

    private void findMaxMin(){

        maxX = -BIG_NUM;
        maxY = -BIG_NUM;
        minX = BIG_NUM;
        minY = BIG_NUM;

        for (Point point: points) {
            maxX = Math.max(point.getX(), maxX);
            maxY = Math.max(point.getY(), maxY);
            minX = Math.min(point.getX(), minX);
            minY = Math.min(point.getY(), minY);
        }
    }

    @Override
    public void drawOn(DrawingBoard db) {

        if (points.isEmpty()){
            return;
        }

        Point p1 = points.get(points.size() - 1);
        for(Point p2: points){
            lines.add(new Line(p1, p2, strokeColor, strokeSize));
            p1 = p2;
        }

        if (isFilled) {
            for (int x = (int) Math.round(minX); x <= maxX; x++) {
                for (int y = (int) Math.round(minY); y <= maxY; y++) {

                    if (isInside(new Point(x, y))) {
                        db.getImageArray()[y][x] = (inverted) ? 0xFFFFFF - db.getImageArray()[y][x] : color;
                    }

                }
            }
        }

        if(strokeFilled) {
            for (Line line : lines) {
                line.drawOn(db);
            }
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
