//Reviewed by Hashim Asad, 1/29/19
package main.java;

import main.java.drawable.Drawable;
import main.java.drawable.Image;
import main.java.drawable.ShapeGroup;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class Drawing {

    private ShapeGroup mainLayer;
    public DrawingBoard db;

    public Drawing(int width, int height){

        mainLayer = new ShapeGroup();
        System.out.println(width + ", " + height);
        db = new DrawingBoard(width, height);

    }

    public Drawing(String path) throws IOException {

        this(ImageIO.read(new File(path)).getWidth(), ImageIO.read(new File(path)).getHeight());

        add(new Image(path));

    }

    public void add(Drawable drawable){
        mainLayer.add(drawable);
    }

    public void show(){

        mainLayer.drawOn(db);
        db.setVisible(true);

    }

}
