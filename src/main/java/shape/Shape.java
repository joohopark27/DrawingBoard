package main.java.shape;

import main.java.Drawable;

public abstract class Shape implements Drawable {

    protected int color;
    protected int weight;

    protected Shape(){

        color = 0xFF0000;
        weight = 3;

    }

    protected Shape(int color, int weight){

        this.color = color;
        this.weight = weight;

    }

    public void changeColor(int color){

        this.color = color;

    }

}
