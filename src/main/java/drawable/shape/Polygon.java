package main.java.drawable.shape;

import main.java.DrawingBoard;
import main.java.Point;

import java.util.ArrayList;

public class Polygon extends Shape{

    private ArrayList<Point> points;

    public Polygon(){

        super();

        points = new ArrayList<>();

    }

    public void add(Point point){

        points.add(point);

    }

    /**
     * Finds the x coordinate of a point on a line given the y coordinate.
     * @param y y coordinate of the point
     * @param x1
     * @param y1 (x1, y1) is one point on the line
     * @param x2
     * @param y2 (x2, y2) is another point on the line
     * @return
     */
    public static int xOnLine(int y, int x1, int y1, int x2, int y2) {
		if(y2 == y1)  	// horizontal line, slope == 0
			return x1;	// actually all x values lie on the line

		double m = ((double)(x2 - x1))/(y2 - y1);	// slope

		int x = (int)(x1 + m*(y - y1) + 0.5);
		return x;
	}

    @Override
    public void drawOn(DrawingBoard db) {

        if (points.isEmpty()){
            return;
        }

        int[][] imgArray = db.getImageArray();

        Point lastPoint = points.get(points.size() - 1);

        for (Point point: points) {

            if(Math.round(point.getX()) == Math.round(point.getY())){
                for(int y = (int) Math.round(lastPoint.getY()); y != (int) Math.round(point.getY()); y += (lastPoint.getY() > point.getY() ? -1 : 1)){

                    imgArray[y][(int) Math.round(lastPoint.getX())] = color;

                }
            }else {

                double slope = (point.getY() - lastPoint.getY()) / (point.getX() - lastPoint.getX());

                if(Math.abs(slope) < 1) {
                    for (int x = (int) Math.round(lastPoint.getX()); x != Math.round(point.getX()); x += (lastPoint.getX() > point.getX()) ? -1 : 1) {

                        imgArray[(int) Math.round(lastPoint.getY() + (x - lastPoint.getX()) * slope)][x] = color;

                    }
                }else{
                    for(int y = (int) Math.round(lastPoint.getY()); y != (int) Math.round(point.getY()); y += (lastPoint.getY() > point.getY() ? -1 : 1)){

                        imgArray[y][(int) Math.round(lastPoint.getX() + ((y - lastPoint.getY()) / slope))] = color;

                    }
                }

            }
            lastPoint = point;

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
