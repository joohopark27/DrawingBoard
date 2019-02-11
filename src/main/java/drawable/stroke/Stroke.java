package main.java.drawable.stroke;

import main.java.Colors;
import main.java.DrawingBoard;
import main.java.Point;
import main.java.drawable.Drawable;

public abstract class Stroke implements Drawable {

    protected int stroke;
    protected int color;

    public Stroke(int stroke, int color){

        this.stroke = stroke;
        this.color = color;

    }

    public Stroke(){

        this(1, Colors.BLACK.getVal());

    }

    public void setColor(int color){

        this.color = color;

    }

    public void setStroke(int stroke){

        this.stroke = stroke;

    }

    protected void drawAtPoint(DrawingBoard db, Point p){

        drawAtPoint(db, p.getX(), p.getY());

    }

    protected void drawAtPoint(DrawingBoard db, double x0, double y0){

        if((int)y0 < db.getImageArray().length && (int)y0 > 0 && (int)x0 < db.getImageArray()[(int)y0].length && (int)x0 > 0) {
            db.getImageArray()[(int) y0][(int) x0] = color;
        }

        for(int y = (int) Math.round(y0 - (stroke + 1 / 2)); y <= Math.round(y0 + stroke / 2); y++){
            for(int x = (int) Math.round(x0 - (stroke + 1 / 2)); x <= Math.round(x0 + stroke / 2); x++){

                if(Math.pow(y0 - y, 2) + Math.pow(x0 - x, 2) <= stroke * stroke / 4) {
                    db.getImageArray()[y][x] = color;
                }

            }
        }

    }

}
