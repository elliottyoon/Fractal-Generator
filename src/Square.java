/**
 * Elliott Yoon
 *
 * Class that represents a square
 *
 * Inherited fields:
 * height
 * width
 * center
 * points
 * numSidesv
 * 
 * Inherited methods:
 * setCenter
 * getCenter
 * getPoints
 * getLines
 * rotate
 * getNumSides
 *
 * 
 * @author Elliott Yoon
 */
public class Square extends NGon {
    

    /**
     * Constructor
     *
     * @param  center  the center of the square
     * @param  length  the length of the sides of the square
     */
    public Square(Point center, double length) {
        super(center, 4, length);

    }

    /**
     * Returns the width (or sidelength) of the square
     *
     * @return  width  the width of the square
     */
    public double getWidth() {
        return getSideLength();
    }

    /**
     * Returns the height (or side length) of the square
     *
     * @return  height  the height of the square
     */
    public double getHeight() {
        return getSideLength();
    }

    /**
     * Sets the width of the square
     *
     * @param  width  the new height (and side length) of the square
     */
    public void setWidth(double width) {
        setSideLength(width);
    }

    /**
     * Sets the height of the square
     *
     * @param  height  the new height (and side length) of the square
     */
    public void setHeight(double height) {
        setSideLength(height);
    }    

}
