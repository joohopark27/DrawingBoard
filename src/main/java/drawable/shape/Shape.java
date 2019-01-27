package main.java.drawable.shape;

import main.java.drawable.Drawable;
import main.java.DrawingBoard;

public abstract class Shape implements Drawable {

    protected int color;
    protected boolean isFilled;

    protected Shape(){

        color = 0xFF0000;
        isFilled = false;

    }

    protected Shape(int color, boolean isFilled){

        this.color = color;
        this.isFilled = isFilled;

    }

    public void changeColor(int color){

        this.color = color;

    }

    public void fill(boolean fill){
        isFilled = fill;
    }

}
