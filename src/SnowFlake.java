/**
 * Represents a snowflake fractal
 *
 * @author  Elliott Yoon
 */
public class SnowFlake {
    
    // how many levels are in the snowflake
    private int numLevels;
    
    // the base shape of the snowflake
    private NGon base;

    // the points of the fractal 
    private Point[] points;
    
    // the edges of the fractal
    private Line[] lines;

    /**
     * Constructor
     *
     * @param  base  the base polygon of the fractal; must be square, ngon, or eq. triangle
     * @param  numLevels  the number of levels in the fractal
     */
    public SnowFlake(NGon base, int numLevels) {
        this.numLevels = numLevels;
        this.base = base;
    }

    /**
     * returns the number of levels
     *
     * @return  numLevels  the number of levels of the fractal
     */
    public int getNumLevels() {
        return numLevels;
    }

    /**
     * sets the number of levels
     *
     * @param  numLevels  the number of levels of the fractal
     */
    public void setNumLevels(int numLevels) {
        this.numLevels = numLevels;
    }

    /**
     * returns the base 
     *
     * @return  base  the base shape 
     */
    public NGon getBaseShape() {
        return base;
    }

    /**  returns a Point that is the center of the fractal
     *
     * @return  center  the center of the fractal
     */
    public Point getCenter() {
        return base.getCenter();
    }

    /** sets the center of the fractal
     *
     * @param  center  the new center of the fractal
     */
    public void setCenter(Point center) {
        getBaseShape().setCenter(center);
    }
    
    
    
    /** rotates the points of the fractal
      * 
      * @param  angle  how much to rotate the points of the fractal by 
      */
    public void rotate(double angle) {
      for (int i = 0; i < getPoints().length; i++) {
        points[i].rotateAbout(getCenter(), angle);
      }
    }
    
    

    

    /**
     * returns all the points of the fractal
     * 
     * @return  prevPoints  an array of the all the points of the fractal
     */
    public Point[] getPoints() {
        if (getNumLevels() == 0) 
            return getBaseShape().getPoints();
        else {
            // previous list of points
            Point[] prevPoints = new Point[getBaseShape().getPoints().length];
            
            // k = 0
            // copies all the points in the base to the previous list 
            for (int i = 0; i < base.getPoints().length; i++) {
                prevPoints[i] = new Point(getBaseShape().getPoints()[i].getX(), getBaseShape().getPoints()[i].getY());
            }

            // iterates through each level
            for (int k = 1; k <= getNumLevels(); k++) {
                
                // index of the currPoints array
                int j = 0;
                
                // current list of points we will append to
                Point[] currPoints = new Point[base.getNumSides() * (int) Math.pow(4, k)];
                
                // iterates through each line of the current layer
                for (int i = 0; i < prevPoints.length; i++) {

                    // represents 1/3 of the distance between endpoints 
                    double thirdX = (prevPoints[(i+1) % prevPoints.length].getX() - prevPoints[i].getX()) / 3;
                    double thirdY = (prevPoints[(i+1) % prevPoints.length].getY() - prevPoints[i].getY() ) / 3;
                  
                    // adding the first endpoint to our list
                    currPoints[j] = prevPoints[i];
                    j += 1;
   
                    Point p2 = new Point(prevPoints[i].getX() + thirdX,  prevPoints[i].getY() + thirdY);
                    Point p4 = new Point(prevPoints[i].getX() + 2 * thirdX,  prevPoints[i].getY() + 2 * thirdY);
                    
                    // copy of p4; will be the top of the triangle thingy 
                    Point p3 = new Point(p4.getX(), p4.getY());
                    
                    currPoints[j] = p2;
                    j += 1;

                    p3.rotateAbout(p2, - Math.PI / 3);
                    currPoints[j] = p3;
                    j += 1;

                    currPoints[j] = p4; 
                    j += 1;
                }

                prevPoints = new Point[currPoints.length];
                prevPoints = currPoints;
            } 
            
            // copies prev points into points
            points = prevPoints;
            return points;
        }

    }
    
    /**
     * returns all the lines of the fractal by connecting all the points in order
     * 
     * @return  output  the sides of the fractal
     */
    public Line[] getLines() {
      // our output array of the lines
      Line[] output = new Line[getPoints().length];

      // iterates through each point and connects them to get all the edges of the snowflake
      for (int i = 0; i < getPoints().length; i++) {
        output[i] = new Line(getPoints()[i], getPoints()[(i+1) % getPoints().length]); // we have a % here for the case when the point after the last point is actually the first
      }
      
      return output;
    }
}
