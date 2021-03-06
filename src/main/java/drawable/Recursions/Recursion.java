package main.java.drawable.Recursions;

import main.java.drawable.Drawable;
import main.java.drawable.ShapeGroup;

public abstract class Recursion<E extends Drawable> extends ShapeGroup {

    public Recursion(E initialShape, int repetition){

        draw(initialShape, repetition);

    }

    public abstract void draw(E initialShape,int repetition);

}
