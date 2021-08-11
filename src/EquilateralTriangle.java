/**
 * Equilateral Triangle
 *
 * @author  Elliott Yoon
 */
public class EquilateralTriangle extends NGon {
    
    /**
     * Constructor
     *
     * @param  center  the center of the triangle
     * @param  sideLength  the length of the sides
     */
    public EquilateralTriangle(Point center, double sideLength) {
        super(center, 3, sideLength);
    }
}
