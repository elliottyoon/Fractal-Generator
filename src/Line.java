/**
 * Elliott Yoon
 * 
 * Represents an arbitrary line in 2D-space
 * 
 * @author Elliott Yoon
 */

public class Line {
  
  // the first endpoint of the line
  private Point point1;
  // the second endpoint of the line
  private Point point2;
  
  /**
   * Constructor
   * 
   * @param  point1  the first endpoint of the line
   * @param  point2  the second endpoint of the line
   */
  public Line(Point point1, Point point2) {
    this.point1 = point1;
    this.point2 = point2;
  }
  
  /**
   * Returns the first endpoint of the line
   * 
   * @return  the first endpoint of the line
   */
  public Point getFirstPoint() {
    return point1;
  }
  
  /**
   * Sets the first endpoint
   * 
   * @param  point1  the first endpoint of the line
   */
  public void setFirstPoint(Point point1) {
    this.point1 = point1;
  }
  
  /**
   * Returns the second endpoint of the line
   * 
   * @return  the second endpoint of the line
   */
  public Point getSecondPoint() {
    return point2;
  }
  
  /**
   * Sets the second endpoint
   * 
   * @param  point2  the second endpoint of the line
   */
  public void setSecondPoint(Point point2) {
    this.point2 = point2;
  }
  
  /**
   * Returns an array of the Line types that make up 'this' line (i.e. only 'this' line itself)
   * 
   * @return  an array consisting of the line itself
   */
  public Line[] getLines() {
    Line[] output = new Line[1]; // the array of lines
    output[0] = this;
    return output;
  }
}