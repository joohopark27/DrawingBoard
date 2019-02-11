package main.java.drawable.shape;

import main.java.Colors;
import main.java.drawable.Drawable;
import main.java.DrawingBoard;

public abstract class Shape implements Drawable {

    protected int color;
    protected int strokeColor;
    protected boolean isFilled;
    protected boolean strokeFilled;
    boolean inverted;
    protected int strokeSize;

    protected Shape(){

        this(Colors.RED, false);

    }

    protected Shape(Colors color, boolean isFilled){

        this.color = color.getVal();
        this.isFilled = isFilled;
        this.strokeColor = Colors.BLACK.getVal();
        this.strokeSize = 1;
        inverted = false;
        strokeFilled = true;

    }

    public int getColor(){

        return color;

    }

    public void changeColor(Colors color){

        this.color = color.getVal();

    }

    public void changeColor(int color){

        this.color = color;

    }

    public void changeStrokeColor(Colors color){

        this.strokeColor = color.getVal();

    }

    public void changeStrokeColor(int color){

        this.strokeColor = color;

    }

    public void setStrokeSize(int size){

        strokeSize = size;

    }

    public void fill(boolean fill){
        isFilled = fill;
    }

    public void fillStroke(boolean fill){

        this.strokeFilled = fill;

    }

    public void setInverted(boolean inverted){

        this.inverted = inverted;

    }

}
