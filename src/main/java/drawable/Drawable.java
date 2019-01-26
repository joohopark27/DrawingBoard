package main.java.drawable;

import main.java.DrawingBoard;

public interface Drawable {

	// Draws the object on DrawingBoard db
	void drawOn(DrawingBoard db);
	
	// Returns true if the object falls entirely within DrawingBoard db
	boolean within(DrawingBoard db);

}
