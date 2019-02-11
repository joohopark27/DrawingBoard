package main.java.drawable.Recursions;

import main.java.Colors;
import main.java.Point;
import main.java.drawable.shape.Rectangle;

public class SierpinskiCarpet extends Recursion<Rectangle> {

    @Override
    public void draw(Rectangle initialShape, int repetition) {

        if(repetition <= 0){

            return;

        }

        add(initialShape);

        Point topLeft = new Point(initialShape.getX1() + (initialShape.getX2() - initialShape.getX1()) / 3, initialShape.getY1() + (initialShape.getY2() - initialShape.getY1()) / 3);
        Point topRight = new Point(initialShape.getX1() + (initialShape.getX2() - initialShape.getX1()) * 2 / 3, initialShape.getY1() + (initialShape.getY2() - initialShape.getY1()) / 3);
        Point bottomLeft = new Point(initialShape.getX1() + (initialShape.getX2() - initialShape.getX1()) / 3, initialShape.getY1() + (initialShape.getY2() - initialShape.getY1()) * 2 / 3);
        Point bottomRight = new Point(initialShape.getX1() + (initialShape.getX2() - initialShape.getX1()) * 2 / 3, initialShape.getY1() + (initialShape.getY2() - initialShape.getY1()) * 2 / 3);

        Rectangle middleRectangle = new Rectangle(topLeft, bottomRight);
        middleRectangle.changeColor(Colors.BLACK);
        middleRectangle.fill(true);
        add(middleRectangle);

        Rectangle[] rectangle = new Rectangle[8];

        rectangle[0] = new Rectangle(new Point(initialShape.getX1(), initialShape.getY1()), topLeft);
        rectangle[1] = new Rectangle(new Point(topRight.getX(), initialShape.getY1()), topLeft);
        rectangle[2] = new Rectangle(new Point(initialShape.getX2(), initialShape.getY1()), topRight);
        rectangle[3] = new Rectangle(new Point(initialShape.getX1(), bottomLeft.getY()), topLeft);
        rectangle[4] = new Rectangle(new Point(initialShape.getX2(), bottomRight.getY()), topRight);
        rectangle[5] = new Rectangle(new Point(initialShape.getX1(), initialShape.getY2()), bottomLeft);
        rectangle[6] = new Rectangle(new Point(bottomRight.getX(), initialShape.getY2()), bottomLeft);
        rectangle[7] = new Rectangle(new Point(initialShape.getX2(), initialShape.getY2()), bottomRight);

        repetition--;

        for (Rectangle rect: rectangle) {

            rect.changeColor(initialShape.getColor());
            rect.fill(true);
            rect.fillStroke(false);

            draw(rect, repetition);

        }

    }
}
