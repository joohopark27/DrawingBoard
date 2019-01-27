package main.java.drawable.shape;

import main.java.DrawingBoard;
import main.java.Point;
import main.java.drawable.Line;

import java.util.ArrayList;

public class Polygon extends Shape{

    private ArrayList<Point> points;
    private ArrayList<Line> lines;

    private double maxX, maxY, minX, minY;

    private float BIG_NUM = 1000000;

    public Polygon(){

        super();

        points = new ArrayList<>();
        lines = new ArrayList<>();

    }

    public void add(Point point){

        points.add(point);

    }

    private void findMaxMin(){

        maxX = -1;
        maxY = -1;
        minX = BIG_NUM;
        minY = BIG_NUM;

        for (Point point: points) {
            maxX = Math.max(point.getX(), maxX);
            maxY = Math.max(point.getY(), maxY);
            minX = Math.min(point.getX(), minX);
            minY = Math.min(point.getY(), minY);
        }
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
//            if(ray.)
        }

        return result;

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

        findMaxMin();

        if (isFilled) {
            for (int x = (int) Math.round(minX); x <= maxX; x++) {
                for (int y = (int) Math.round(minY); y <= maxY; y++) {

                    if (isInside(new Point(x, y))) {
                        db.getImageArray()[y][x] = color;
                    }

                }
            }
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
