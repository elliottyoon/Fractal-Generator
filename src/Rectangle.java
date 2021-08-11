/**
 * Elliott Yoon
 * 
 * Class to represent rectangles
*
 * Inherited methods:
 * setCenter
 * getCenter
 * getPoints
 * getLines
 * rotate
 *
 * @author Elliott Yoon
 */

public class Rectangle extends Polygon {
   
    // the height of the rectangle
    private double height;

    // the width of the rectangle
    private double width;

    /**
     * Constructor
     *
     * @param  center  a Point that represents the center of the rectangle
     * @param  height  the height of the rectangle
     * @param  width  the width of the rectangle
     */
    public Rectangle(Point center, double width, double height) {
        super(new Point[]{new Point(center.getX() - (width / 2),center.getY() + (height / 2)), new Point(center.getX() + (width / 2), center.getY() + (height / 2)), new Point(center.getX() + (width / 2), center.getY() - (height / 2)), new Point(center.getX() - (width / 2), center.getY() - (height / 2))}); 
        this.height = height;
        this.width = width;
    }

    /**
     * getter method that returns the width of the rectangle
     *
     * @return  width  the width of the rectangle
     */
    public double getWidth() {
        return this.width;
    }

    /**
     * getter method that returns the height of the rectangle
     *
     * @return  height  the height of the rectangle
     */
    public double getHeight() {
        return this.height;
    }

    /** 
     * setter method that sets the new width of the rectangle
     *
     * @param  width  the new width of the rectangle
     */
    public void setWidth(double width) {
        this.width = width;
        setPoints(new Point[]{new Point(getCenter().getX() - (width / 2),getCenter().getY() + (height / 2)), new Point(getCenter().getX() + (width / 2), getCenter().getY() + (height / 2)), new Point(getCenter().getX() + (width / 2), getCenter().getY() - (height / 2)), new Point(getCenter().getX() - (width / 2), getCenter().getY() - (height / 2))});
    }

    /**
     * setter method taht sets the new height of the rectangle
     *
     * @param  height  the new height of the rectangle
     */
    public void setHeight(double height) {
        this.height = height;
        setPoints(new Point[]{new Point(getCenter().getX() - (width / 2),getCenter().getY() + (height / 2)), new Point(getCenter().getX() + (width / 2), getCenter().getY() + (height / 2)), new Point(getCenter().getX() + (width / 2), getCenter().getY() - (height / 2)), new Point(getCenter().getX() - (width / 2), getCenter().getY() - (height / 2))});

    }
}
