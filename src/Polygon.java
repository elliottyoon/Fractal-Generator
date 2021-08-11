/**
 * Elliott Yoon
 * 
 * Represents an arbitrary polygon object
 * 
 * Inherited methods:
 * setCenter (Override)
 * getNumSides
 * rotate
 * getPoints (Override)
 * getLines (Override)
 * 
 * 
 * @author Elliott Yoon
 */
public class Polygon extends Shape {

  
  // array of the points 
  private Point[] points;

  // array of the sides of the polygon
  private Line[] lines;
  
  // number of sides
  private int numSides;

  
  /**
   * Constructor
   * 
   * @param  points  an array of Points, representing all the vertices of the polygon
   */
  public Polygon (Point... points) {
    this.points = points;

    // initializes numSides
    numSides = points.length;
    
    // initializes lines array
    lines = new Line[numSides];

    // finds the bounding rectangle for the polygon
    double leftEdge = this.points[0].getX(); // x coordinate for the left edge
    double rightEdge = this.points[0].getX(); // x coordinate for the right edge
    double topEdge = this.points[0].getY(); // y coordinage for the top edge
    double bottomEdge = this.points[0].getY(); // y coordinate for the bottom edge

    // iterates through each point of the polygon and compares its x and y values to the bounding edges
    for (int i = 1; i < this.points.length; i++) {
        if (this.points[i].getX() < leftEdge)
               leftEdge = this.points[i].getX();
        if (this.points[i].getX() > rightEdge)
                rightEdge = this.points[i].getX();
        if (this.points[i].getY() < bottomEdge) 
                bottomEdge = this.points[i].getY();
        if (this.points[i].getY() > topEdge)
                topEdge = this.points[i].getY();
    }
    // sets the center of the bounding rectangle
    super.setCenter(new Point((0.5 * (rightEdge + leftEdge)), (0.5 * (topEdge + bottomEdge))));
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
      points[i].setX(points[i].getX() + x_shift);
      points[i].setY(points[i].getY() + y_shift);
    }
    
    // sets the new center
    super.setCenter(newCenter);
  }
  
    /**
     * rotates the polygon about its center and the input angle
     *
     * @param  angle  the angle of rotation in radians
     */
  public void rotate(double angle) {
    // iterates through each point and rotates it about the center
    for (int i = 0; i < getNumSides(); i++) {
      points[i].rotateAbout(getCenter(), angle);
    }
  }
  
  /**
   * getter method that return an array consisting of all the edges of the Polygon
   * 
   * @return  lines  an array of all the edge lines
   */
  @Override
  public Line[] getLines() {
    // iterates through all the vertices and connects them
    for (int i = 0; i < getNumSides()-1; i++) {
      lines[i] = new Line(points[i], points[i+1]);
    }
    // connectes the last vertex to the first
    lines[getNumSides()-1] = new Line(points[getNumSides()-1],points[0]); 
  
    return lines;
  }
  
  /**
   * getter method that returns an array of Points that represents the vertices of the Polygon
   * 
   * @return  points  an array of the vertices
   */
  public Point[] getPoints() {
    return points;
  }
  
  /**
   * setter helper method that sets the points of the array
   * 
   * @param  points  the new array of points to set
   */
  protected void setPoints(Point[] points) {
    this.points = points;
  }
  
  

  

  
  
  
  
  
  
}
