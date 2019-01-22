package main.java;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;

/**
 * A simplified class for displaying an RGB image in a window.  
 * Displays images stored as 2-dimensional integer arrays.
 * The four bytes of each integer are ARGB, where A is the 
 * alpha channel.
 * @author coupland
 */

public class DrawingBoard extends Component {
	
	int height;				// number of rows in image
	int width;				// number of columns in image
	BufferedImage buffImg;
	int[][] imgArray;			// The image data stored in a rectangular array
	
	
	/**
	 * Creates a new DisplayImage by loading an image from a file.
	 * @param filePath the path of the file to load
	 */
	
	public DrawingBoard(String filePath) {
		try {
			buffImg = ImageIO.read(new File(filePath));
		} catch (IOException e) {
		}
		width = buffImg.getWidth();
		height = buffImg.getHeight();
		imgArray = new int[height][width];
		
		// Copy image data from buffImg to imgArray
		
		for(int i=0; i<height; ++i) {
			buffImg.getRGB(0, i, width, 1, imgArray[i], 0, width);
		}
		
	}
	
	/** 
	 * Creates a blank DisplayImage.
	 * @param width the width of the image in pixels
	 * @param height the height of the image in pixels
	 */
	
	public DrawingBoard(int width, int height) {
		buffImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		imgArray = new int[height][width];
		this.height = height;
		this.width = width;
	}
	
	/**
	 * Returns an array where image data can be read or written in ARGB format
	 * @return the two dimensional integer array where image data is stored
	 */
	
	public int[][] getImageArray() {
		return imgArray;
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
	/**
	 * Displays the image in a window.
	 */
	
	public void setVisible(boolean visible) {
		if(!visible) return;

		JFrame f = new JFrame("Display Image");

		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		// Copy image data from imgArray to buffImg
		for(int i=0; i<height; ++i) {
			buffImg.setRGB(0, i, width, 1, imgArray[i], 0, width);
		}


		f.add(this);
		f.pack();
		f.setVisible(true);
	}
	
	/* 
	 * These methods required by Java AWT
	 */
	
	public void paint(Graphics g) {
		g.drawImage(buffImg, 0, 0, null);
	}
	
	public Dimension getPreferredSize() {
		if (buffImg == null) {
			return new Dimension(100, 100);
		} else {
			return new Dimension(buffImg.getWidth(null), buffImg.getHeight(null));
		}
	}
	

}
