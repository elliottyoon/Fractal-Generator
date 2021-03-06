/**
 * Elliott Yoon
 * 
 * Represents a point in 2d-space
 * 
 * @author Elliott Yoon
 */
public class Point {
  
  private double x;
  private double y;
  
  /**
   * Constructor
   * 
   * @param  x  the x-coordinate of our point
   * @param  y  the y-coordinate of our point
   */
  public Point(double x, double y) {
    this.x = x; 
    this.y = y;
  }
  
  /**
   * Returns the x-coordinate of the point
   * 
   * @return  the x-coordinate of the point
   */
  public double getX() {
    return x;
  }
  
  /**
   * Sets the x-coordinate of the point
   * 
   * @param  x  the x-coordinate of the point
   */
  public void setX(double x) {
    this.x = x;
  }
  
  /**
   * Returns the y-coordinate of the point
   * 
   * @return  the y-coordinate of the point
   */
  public double getY() {
    return y;
  }
  
  /**
   * Sets the y-coordinate of the point
   * 
   * @param  y  the y-coordinate of the point
   */
  public void setY(double y) {
    this.y = y;
  }
  
  /**
   * Rotates the point about an input point by the input angle
   * 
   * @param  point  the point about which the object point is being rotated
   * @param  angle  the angle (in radians) of rotation 
   */
  public void rotateAbout(Point point, double angle) {
    // x-coordinate of 'this' when treating the input point as the origin
    double shifted_x = this.getX() - point.getX(); 
    // y-coordinate of 'this' when treating the input point as the origin
    double shifted_y = this.getY() - point.getY();
    
    this.setX((shifted_x * Math.cos(angle) - shifted_y * Math.sin(angle)) + point.getX());
    this.setY((shifted_x * Math.sin(angle) + shifted_y * Math.cos(angle)) + point.getY());
  }
  
}
