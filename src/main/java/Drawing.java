package main.java;

public class Drawing {

    private ShapeGroup mainLayer;
    public DrawingBoard db;

    public Drawing(DrawingBoard db){

        mainLayer = new ShapeGroup();
        this.db = db;

    }



    public void setVisable(){

        mainLayer.drawOn(db);
        db.setVisible(true);

    }

}
