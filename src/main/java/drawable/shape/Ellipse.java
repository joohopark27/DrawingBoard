package main.java.drawable.shape;

import main.java.DrawingBoard;
import main.java.Point;

public class Ellipse extends Shape{

    private Point center;
    private double horizontalAxis;
    private double verticalAxis;

    public Ellipse(Point center, double horizontalAxis, double verticalAxis){

        this.center = center;
        this.horizontalAxis = horizontalAxis;
        this.verticalAxis = verticalAxis;

    }

    @Override
    public void drawOn(DrawingBoard db) {

        double b = verticalAxis / 2;
        double a = horizontalAxis / 2;

        for(int x = (int) Math.round(center.getX() - horizontalAxis / 2 - (strokeSize + 1) / 2); x <= center.getX() + horizontalAxis / 2 + (strokeSize + 1) / 2; x++){
            for(int y = (int) Math.round(center.getY() - verticalAxis / 2 - (strokeSize + 1) / 2); y <= center.getY() + verticalAxis / 2 + (strokeSize + 1) / 2; y++){

                if(Math.pow(x - center.getX(), 2) / Math.pow(a + (strokeSize + 1) / 2 + 1, 2) + Math.pow(y - center.getY(), 2) / Math.pow(b + (strokeSize + 1) / 2, 2) <= 1){
                    if(Math.pow(x - center.getX(), 2) / Math.pow(a - strokeSize  / 2 + 1, 2) + Math.pow(y - center.getY(), 2) / Math.pow(b - strokeSize / 2, 2) >= 1){
                        db.getImageArray()[y][x] = strokeColor;
                    }else if(isFilled){
                        db.getImageArray()[y][x] = color;
                    }
                }

            }
        }

    }

    @Override
    public boolean within(DrawingBoard db) {
        return (center.getX() - horizontalAxis / 2 - (strokeSize + 1) / 2 >= 0 && center.getY() - verticalAxis / 2 - (strokeSize + 1) / 2 >= 0)
                && (center.getX() + horizontalAxis / 2 + (strokeSize + 1) / 2 <= db.getImageArray()[0].length && center.getY() + verticalAxis / 2 + (strokeSize + 1) / 2 <= db.getImageArray().length);
    }
}
