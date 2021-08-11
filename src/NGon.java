/**
 * Elliott Yoon
 *
 * Represents a regular polygon
 * 
 * Inherited methods:
 * getCenter
 * setCenter (override)
 * getNumSides
 * rotate (override)
 * getPoints (override)
 * getLines (override)
 * 
 * @author Elliott Yoon
 */

public class NGon extends Shape {

    // array of the points 
    private Point[] points;
  
    // array of the sides of the polygon
    private Line[] lines;
  

    // length of each side
    private double sideLength;
    
    // number of sides
    private int numSides;

    /**
     * Constructor
     *
     * @param  center  the center of the polygon
     * @param  numSides  the number of sides
     * @param  sideLength  the length of the sides
     */
    public NGon(Point center, int numSides, double sideLength) {
        super.setCenter(center);
        this.numSides = numSides;
        this.sideLength = sideLength;    
        points = new Point[numSides];
        lines = new Line[numSides];
    }
    
    /**
     * getter method that returns the number of sides of the polygon
     *
     * @return  numSides  the number of sides of the polygon  
     */
    public int getNumSides() {
      return this.numSides;
    }
    
    
    
    /**
     * sets the input Point as the new center of the polygon
     * 
     * @param  center  the new center of the bounding rectangle of the polygon
     */
    @Override
    public void setCenter(Point newCenter) {
      // how much we need to shift our points' x-components
      double x_shift = newCenter.getX() - getCenter().getX();
      
      // how much we need to shift our points' y-components
      double y_shift = newCenter.getY() - getCenter().getY();
      
      // iterates through each vertex and shifts it to be in line with the new center
      for (int i = 0; i < getNumSides(); i++) {
        getPoints()[i].setX(points[i].getX() + x_shift);
        getPoints()[i].setY(points[i].getY() + y_shift);
      }
      
      // sets the new center
      super.setCenter(newCenter);
    }


    /**
     * Getter method that returns the length of each side of the polygon
     *
     * @return  sideLength  the side length
     */
    public double getSideLength() {
        return this.sideLength;
    }
    
    /**
     * Setter method that sets the length of each side of the polygon
     * 
     * @param  sideLength  the new length of each side
     */
    public void setSideLength(double sideLength) {
      this.sideLength = sideLength;
    }
  
  /**
   * Returns the array of the vertices of the polygon
   * 
   * @return  points  the vertices of the polygon
   */
  @Override
  public Point[] getPoints() {
    double apothem = (getSideLength() / (2 * Math.tan(Math.PI / getNumSides()))); // the distance from the center to the midpoint of a side
    double angle = (Math.PI * (getNumSides() - 2) / getNumSides());
    
    Point midSide = new Point(getCenter().getX(), getCenter().getY() - apothem); // the midpoint of our first side
    points[0] = new Point(midSide.getX() - (getSideLength() / 2), midSide.getY()); // first point
    points[1] = new Point(points[0].getX() + getSideLength(), midSide.getY()); // second point
    
   // rotates previous point about the center by the interior angle to get the next point
    for (int i = 2; i < getNumSides(); i++) {
      Point temp = new Point(2 * points[i-1].getX() - points[i-2].getX(), 2 * points[i-1].getY() - points[i-2].getY());
      temp.rotateAbout(points[i-1], Math.PI - angle);
      points[i] = temp;
    }
    return points;
                 
  }
    /**
     * rotates the polygon about its center and the input angle
     *
     * @param  angle  the angle of rotation in radians
     */
  public void rotate(double angle) {
    getLines();  // updates the points and lines in case of a side length change
    // iterates through each point and rotates it about the center
    for (int i = 0; i < getNumSides(); i++) {
      points[i].rotateAbout(getCenter(), angle);
    }
  }
  
  
  /**
   * Returns an array of the edges of the polygon
   * 
   * @return  lines  the edges of the polygon
   */
  @Override
  public Line[] getLines() {
    //  makes sure our points are up to date
    getPoints();
    
    // iterates through each point and connects the point i to the point i+1
    for (int i = 0; i < getNumSides() - 1; i++) {
      lines[i] = new Line(points[i], points[i+1]);
    }
    lines[getNumSides() - 1] = new Line(points[getNumSides() - 1], points[0]); // connects last point to the first
    return lines;
  }
  
  

    


}
