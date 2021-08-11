/**
 * Elliott Yoon
 *
 * Represents an arbitrary triangle object
 *
 * Inherited methods:
 * getCenter
 * setCenter
 * rotate
 * getPoints
 * getLines
 *
 * @author Elliott Yoon
 */

public class Triangle extends Polygon{
    
    /**
     * Constructor
     *
     * @param  point1  the first vertex of the triangle
     * @param  point2  the second vertex of the triangle
     * @param  point3  the third vertex of the triangle
     */
    public Triangle(Point point1, Point point2, Point point3) {
        super(new Point[]{point1, point2, point3});
        // reassigning the center of the triangle to that adhering to the formula
        double x1 = point1.getX(); // x coordinate for the first vertex point
        double y1 = point1.getY(); // y coordinate for the first vertex point
        double x2 = point2.getX(); // x coordinate for the second vertex point
        double y2 = point2.getY(); // y coordinate for the second vertex point
        double x3 = x2;
        double y3 = y2;
        double x4 = point3.getX(); // x coordinate for the third vertex point
        double y4 = point3.getY(); // y coordinate for the third vertex point
        getCenter().setX(((x1*y2 - y1*x2)*(x3-x4) - (x1-x2)*(x3*y4-y3*x4))/((x1-x2)*(y3-y4)-(y1-y2)*(x3-x4)));
        getCenter().setY(((x1*y2 - y1*x2)*(y3-y4) - (y1-y2)*(x3*y4-y3*x4))/((x1-x2)*(y3-y4)-(y1-y2)*(x3-x4)));
    }
}

