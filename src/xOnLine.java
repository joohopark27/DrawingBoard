	/**
	 * Finds the x coordinate of a point on a line given the y coordinate.
	 * @param y y coordinate of the point
	 * @param x1 
	 * @param y1 (x1, y1) is one point on the line
	 * @param x2
	 * @param y2 (x2, y2) is another point on the line
	 * @return
	 */
	
/*
    public static int xOnLine(int y, int x1, int y1, int x2, int y2) {
		if(y2 == y1)  	// horizontal line, slope == 0 
			return x1;	// actually all x values lie on the line
					
		double m = ((double)(x2 - x1))/(y2 - y1);	// slope
		
		int x = (int)(x1 + m*(y - y1) + 0.5);
		return x;
	}
*/