package main.java.drawable.Recursions;

import main.java.Drawing;
import main.java.Point;
import main.java.drawable.stroke.Line;

public class Tree extends Recursion<Line>{

    private double ratio;
    private double minAngle, maxAngle;

    public Tree(Line initialShape, int repetition){

        super(initialShape, repetition);

        ratio = 0.6;
        minAngle = 45;
        maxAngle = 45;

    }

    @Override
    public void draw(Line initialShape, int repetition) {

        if(repetition <= 0){
            return;
        }

        add(initialShape);

        Point startingPoint = new Point(initialShape.getX1(), initialShape.getY1());
        Point endingPoint = new Point(initialShape.getX2(), initialShape.getY2());
        Line leftLine = new Line(new Point(endingPoint.getX(), endingPoint.getY()),
                new Point(endingPoint.getX() + (endingPoint.getX() - startingPoint.getX()) * ratio, endingPoint.getY() + (endingPoint.getY() - startingPoint.getY()) * ratio), initialShape.getColor());
        Line rightLine  = new Line(new Point(endingPoint.getX(), endingPoint.getY()),
                new Point(endingPoint.getX() + (endingPoint.getX() - startingPoint.getX()) * ratio, endingPoint.getY() + (endingPoint.getY() - startingPoint.getY()) * ratio), initialShape.getColor());

        leftLine.rotate(endingPoint, Math.random() * (maxAngle - minAngle) + minAngle);
        rightLine.rotate(endingPoint, -Math.random() * (maxAngle - minAngle) - minAngle);

        draw(leftLine, --repetition);
        draw(rightLine, repetition);

    }
}
