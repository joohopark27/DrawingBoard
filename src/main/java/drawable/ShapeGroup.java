package main.java.drawable;

import main.java.DrawingBoard;
import main.java.drawable.Drawable;

import java.util.ArrayList;

public class ShapeGroup implements Drawable {

    private ArrayList<Drawable> drawables;

    public ShapeGroup(){

        drawables = new ArrayList<>();

    }

    public void add(Drawable drawable){
        drawables.add(drawable);
    }

    public void remove(){

        drawables.remove(drawables.size() - 1);

    }

    @Override
    public void drawOn(DrawingBoard db) {

        for(Drawable drawable: drawables) {

            if(drawable.within(db)){
                drawable.drawOn(db);
            }

        }

    }

    @Override
    public boolean within(DrawingBoard db) {
        return true;
    }
}
