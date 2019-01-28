package main.java.drawable.shape;

import main.java.Colors;
import main.java.drawable.Drawable;
import main.java.DrawingBoard;

public abstract class Shape implements Drawable {

    protected Colors color;
    protected Colors strokeColor;
    protected boolean isFilled;
    protected int strokeSize;

    protected Shape(){

        this(Colors.RED, false);

    }

    protected Shape(Colors color, boolean isFilled){

        this.color = color;
        this.isFilled = isFilled;
        this.strokeColor = Colors.BLACK;
        this.strokeSize = 1;

    }

    public void changeColor(Colors color){

        this.color = color;

    }

    public void changeStrokeColor(Colors color){

        this.strokeColor = color;

    }

    public void fill(boolean fill){
        isFilled = fill;
    }

}
