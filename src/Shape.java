/**
 * Elliott Yoon
 *
 * Represents a shape
 * 
 * @author Elliott Yoon
 */

public abstract class Shape {
  
  
  // center of the polygon
  private Point center;

  
  /**
   * returns a Point that represents the "center" of the shape.
   * 
   * @return  the center of the bounding rectangle of the shape
   */
  public Point getCenter() {
    return center;
  }
  
  /**
   * sets the input Point as the new center of the polygon
   * 
   * @param  center  the new center of the bounding rectangle of the polygon
   */
  public void setCenter(Point newCenter) {
    center = newCenter;
  }

  
  

  
  /**
   * getter method that returns an array of Points that represents the vertices of the Polygon
   * 
   * @return  points  an array of the vertices
   */
  public abstract Point[] getPoints();
  
  /**
   * getter method that return an array consisting of all the edges of the Polygon
   * 
   * @return  lines  an array of all the edge lines
   */
  public abstract Line[] getLines();
  
  
  
  
  
}