package main.java.drawable;

import main.java.DrawingBoard;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Image implements Drawable{

    private BufferedImage buffImg;

    public Image(String path){

        try{
            buffImg = ImageIO.read(new File(path));
        }catch (IOException e){
            e.printStackTrace();
        }

    }

    @Override
    public void drawOn(DrawingBoard db) {

        for(int y = 0; y < buffImg.getHeight(); y++){
            for(int x = 0; x < buffImg.getWidth(); x++){

                db.getImageArray()[y][x] = buffImg.getRGB(x, y);

            }
        }
    }

    @Override
    public boolean within(DrawingBoard db) {
        return buffImg != null && buffImg.getWidth() <= db.getWidth() && buffImg.getHeight() <= db.getHeight();
    }
}
