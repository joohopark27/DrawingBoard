package main.java.shape;

import main.java.Drawable;
import main.java.DrawingBoard;

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

    protected void set(DrawingBoard db, int y, int x){

        int[][] img = db.getImageArray();
        img[y][x] = color;

    }

}
