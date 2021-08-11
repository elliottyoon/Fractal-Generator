import org.junit.*;
import static org.junit.Assert.*;
import java.util.Iterator;

/* JUnit Tester class 
 * 
 * 
 * 
 * @author  Elliott Yoon
 */
public class Tester {

  // Tests all methods of the Point class
  @Test
  public void testPoint() {

    // Tests constructor and getX/getY methods
    Point a = new Point(12, 43);
    assertEquals("Testing constructor and getX", 12.0, a.getX(), 0.0);
    assertEquals("Testing constructor and getY", 43.0, a.getY(), 0.0);

    // Tests setX/setY methods
    a.setX(1);
    a.setY(2);
    assertEquals("Testing setX", 1.0, a.getX(), 0.0);
    assertEquals("Testing setY", 2.0, a.getY(), 0.0);

    // Tests rotate about method
    // zero case
    a.rotateAbout(new Point(5, 3), 0);
    assertEquals("Testing rotateAbout with 0 deg (x coord)", 1.0, a.getX(), 0.0);
    assertEquals("Testing rotateAbout with 0 deg (y coord)", 2.0, a.getY(), 0.0);
    a.rotateAbout(new Point(1, 2), 100);
    assertEquals("Testing rotateAbout at same point (x coord)", 1.0, a.getX(), 0.0);
    assertEquals("Testing rotateAbout at same point (y coord)", 2.0, a.getY(), 0.0);
    //one/many case
    a.rotateAbout(new Point(0, 0), Math.PI);
    assertEquals("Testing rotateAbout with Pi (x coord)", -1.0, a.getX(), 0.00001);
    assertEquals("Testing rotateAbout with Pi (y coord)", -2.0, a.getY(), 0.00001);
    a.rotateAbout(new Point(1, 2), Math.PI/-2);
    assertEquals("Testing rotateAbout with -pi/2 (x coord)", -3.0, a.getX(), 0.00001);
    assertEquals("Testing rotateAbout with -pi/2 (y coord)", 4.0, a.getY(), 0.00001);
  }
  
  // Tests all methods of the Line class
  @Test
  public void testLine() {
    
    // Initializes a Line with points at (3, 4) and (-3, -5)
    Line a = new Line(new Point(3, 4), new Point(-3, -5));
    
    // Tests constructor and getFirstPoint/getSecondPoint methods
    
    assertTrue("Testing constructor and getFirstPoint", equalPoints(new Point(3, 4), a.getFirstPoint()));
    assertTrue("Testing constructor and getSecondPoint", equalPoints(new Point(-3, -5), a.getSecondPoint()));
    
    // Tests setFirstPoint/setSecondPoint methods
    a.setFirstPoint(new Point(100, 200));
    a.setSecondPoint(new Point(200, 400));
    assertTrue("Testing setFirstPoint", equalPoints(new Point(100, 200), a.getFirstPoint()));
    assertTrue("Testing setSecondPoint", equalPoints(new Point(200, 400), a.getSecondPoint()));
    
    // Tests getLines method
    assertEquals("Testing getLines length", 1, a.getLines().length);
    assertEquals("Testing getLines first (only) element", a, a.getLines()[0]);
  }
  
  // Tests all methods of the Rectangle class
  @Test
  public void testRectangle() {
    
    // Initializes a rectangle centered at (1, 1) with width 5 and height 10
    Rectangle a = new Rectangle(new Point(1,1), 5, 10);
    
    // Tests constructor, getCenter, getWidth and getHeight methods
    assertTrue("Testing constructor and getCenter for Rectangle", equalPoints(new Point(1, 1), a.getCenter()));
    assertEquals("Testing constructor and getWidth for Rectangle", 5, a.getWidth(), 0.0);
    assertEquals("Testing constructor and getHeight for Rectangle", 10, a.getHeight(), 0.0);
    
    // Tests setCenter, setWidth and setHeight methods
    a.setCenter(new Point(2,3));
    a.setWidth(3);
    a.setHeight(6);
    assertTrue("Testing constructor and setCenter for Rectangle", equalPoints(new Point(2, 3), a.getCenter()));
    assertEquals("Testing constructor and setWidth for Rectangle", 3, a.getWidth(), 0.0);
    assertEquals("Testing constructor and setHeight for Rectangle", 6, a.getHeight(), 0.0);
    
    // Tests getPoints and getLines methods
    Point[] expectedPoints = {
      new Point(-1.5 + 2, 3 + 3),
      new Point(1.5 + 2, 3 + 3),
      new Point(1.5 + 2, -3 + 3),
      new Point(-1.5 + 2, -3 + 3)
    };
    assertTrue("Testing getPoints for Rectangle", equalPointSets(expectedPoints, a.getPoints()));

    Line[] expectedLines = {
      new Line(new Point(1.5 + 2, 3 + 3), new Point(1.5 + 2, -3 + 3)),
      new Line(new Point(1.5 + 2, -3 + 3), new Point(-1.5 + 2, -3 + 3)),
      new Line(new Point(-1.5 + 2, -3 + 3), new Point(-1.5 + 2, 3 + 3)),
      new Line(new Point(-1.5 + 2, 3 + 3), new Point(1.5 + 2, 3 + 3))
    };
    assertTrue("Testing getLines for Rectangle", equalLineSets(expectedLines,a.getLines()));
  }
  
  // Tests Polygon class
  @Test
  public void testPolygon() {
    
    // Tests constructor and getPoints method
    Point[] pointsA = new Point[]{new Point(1, 1), new Point(2, 0), new Point(0, 2)};
    Point[] pointsB = new Point[]{new Point(0, 0), new Point(1, 0), new Point(1, 1), new Point(0, 1)};
    Polygon a = new Polygon(pointsA);
    Polygon b = new Polygon(pointsB);
    
    assertTrue("Testing constructor and getPoints for Polygon", pointsA == a.getPoints());
    assertTrue("Testing constructor and getPoints for Polygon", pointsB == b.getPoints());
    
    // Tests setCenter and getCenter methods
    //minX - end case, maxX - middle case, minY - middle case, maxY - end case
    assertTrue("Testing setCenter method for Polygon (initial value)", equalPoints(new Point(1, 1), a.getCenter()));
    pointsA = new Point[]{new Point(2, 0), new Point(0, 2), new Point(1, 1)};
    a = new Polygon(pointsA);
    //minX - middle case, maxX - front case, minY - front case, maxY - end case
    assertTrue("Testing setCenter method for Polygon (initial value)", equalPoints(new Point(1, 1), a.getCenter()));
    pointsA = new Point[]{new Point(0, 2), new Point(1, 1), new Point(2, 0)};
    a = new Polygon(pointsA);
    //minX - front case, maxX - end case, minY - end case, maxY - front case
    assertTrue("Testing setCenter method for Polygon (initial value)", equalPoints(new Point(1, 1), a.getCenter()));
    // additional case
    assertTrue("Testing setCenter method for Polygon (initial value)", equalPoints(new Point(0.5, 0.5), b.getCenter()));
    
    a.setCenter(new Point(2, 2));
    b.setCenter(new Point(1, 4));
    assertTrue("Testing setCenter method for Polygon", equalPoints(new Point(2, 2), a.getCenter()));
    assertTrue("Testing setCenter method for Polygon", equalPoints(new Point(1, 4), b.getCenter()));
    
    // Tests rotate
    pointsA = new Point[]{new Point(0, 0), new Point(2, 0), new Point(0, 2)};
    a = new Polygon(pointsA);
    a.setCenter(new Point(2, 2));
    a.rotate(0); // Zero case
    b.rotate(0); // Zero case
    Point[] rotatedPointsA = a.getPoints();
    Point[] rotatedPointsB = b.getPoints();
    assertTrue("Testing rotate for Polygon (zero rotation)", equalPoints(new Point(0 + 1, 0 + 1), rotatedPointsA[0]));
    assertTrue("Testing rotate for Polygon (zero rotation)", equalPoints(new Point(2 + 1, 0 + 1), rotatedPointsA[1]));
    assertTrue("Testing rotate for Polygon (zero rotation)", equalPoints(new Point(0 + 1, 2 + 1), rotatedPointsA[2]));
    assertTrue("Testing rotate for Polygon (zero rotation)", equalPoints(new Point(0 + 0.5, 0 + 3.5), rotatedPointsB[0]));
    assertTrue("Testing rotate for Polygon (zero rotation)", equalPoints(new Point(1 + 0.5, 0 + 3.5), rotatedPointsB[1]));
    assertTrue("Testing rotate for Polygon (zero rotation)", equalPoints(new Point(1 + 0.5, 1 + 3.5), rotatedPointsB[2]));
    assertTrue("Testing rotate for Polygon (zero rotation)", equalPoints(new Point(0 + 0.5, 1 + 3.5), rotatedPointsB[3]));
    
    a.rotate(Math.PI);
    b.rotate(Math.PI);
    rotatedPointsA = a.getPoints();
    rotatedPointsB = b.getPoints();
    assertTrue("Testing rotate for Polygon (180 rotation)", equalPoints(new Point(2 + 1, 2 + 1), rotatedPointsA[0]));
    assertTrue("Testing rotate for Polygon (180 rotation)", equalPoints(new Point(0 + 1, 2 + 1), rotatedPointsA[1]));
    assertTrue("Testing rotate for Polygon (180 rotation)", equalPoints(new Point(2 + 1, 0 + 1), rotatedPointsA[2]));
    assertTrue("Testing rotate for Polygon (180 rotation)", equalPoints(new Point(1 + 0.5, 1 + 3.5), rotatedPointsB[0]));
    assertTrue("Testing rotate for Polygon (180 rotation)", equalPoints(new Point(0 + 0.5, 1 + 3.5), rotatedPointsB[1]));
    assertTrue("Testing rotate for Polygon (180 rotation)", equalPoints(new Point(0 + 0.5, 0 + 3.5), rotatedPointsB[2]));
    assertTrue("Testing rotate for Polygon (180 rotation)", equalPoints(new Point(1 + 0.5, 0 + 3.5), rotatedPointsB[3]));
    
    a.rotate(Math.PI/-2);
    b.rotate(Math.PI/-2);
    rotatedPointsA = a.getPoints();
    rotatedPointsB = b.getPoints();
    assertTrue("Testing rotate for Polygon (-90 rotation)", equalPoints(new Point(2 + 1, 0 + 1), rotatedPointsA[0]));
    assertTrue("Testing rotate for Polygon (-90 rotation)", equalPoints(new Point(2 + 1, 2 + 1), rotatedPointsA[1]));
    assertTrue("Testing rotate for Polygon (-90 rotation)", equalPoints(new Point(0 + 1, 0 + 1), rotatedPointsA[2]));
    assertTrue("Testing rotate for Polygon (-90 rotation)", equalPoints(new Point(1 + 0.5, 0 + 3.5), rotatedPointsB[0]));
    assertTrue("Testing rotate for Polygon (-90 rotation)", equalPoints(new Point(1 + 0.5, 1 + 3.5), rotatedPointsB[1]));
    assertTrue("Testing rotate for Polygon (-90 rotation)", equalPoints(new Point(0 + 0.5, 1 + 3.5), rotatedPointsB[2]));
    assertTrue("Testing rotate for Polygon (-90 rotation)", equalPoints(new Point(0 + 0.5, 0 + 3.5), rotatedPointsB[3]));
    
    // Tests Lines
    Line[] expectedLinesA = {
      new Line(new Point(2 + 1, 0 + 1), new Point(2 + 1, 2 + 1)),
      new Line(new Point(2 + 1, 2 + 1), new Point(0 + 1, 0 + 1)),
      new Line(new Point(0 + 1, 0 + 1), new Point(2 + 1, 0 + 1))
    };
    Line[] expectedLinesB = {
      new Line(new Point(1 + 0.5, 0 + 3.5), new Point(1 + 0.5, 1 + 3.5)),
      new Line(new Point(1 + 0.5, 1 + 3.5), new Point(0 + 0.5, 1 + 3.5)),
      new Line(new Point(0 + 0.5, 1 + 3.5), new Point(0 + 0.5, 0 + 3.5)),
      new Line(new Point(0 + 0.5, 0 + 3.5), new Point(1 + 0.5, 0 + 3.5))
    };
      
    assertTrue("Testing getLines for Polygon", equalLineSets(expectedLinesA, a.getLines()));
    assertTrue("Testing getLines for Polygon", equalLineSets(expectedLinesB, b.getLines()));
  }
  
  // Tests NGon Class
  @Test
  public void testNGon() {
    
    // Initializes a NGon centered at (1, 1) with side length 3 and 6 sides
    NGon a = new NGon(new Point(1, 1), 6, 3);
    
    // Tests constructor, getCenter, getNumSides, getSideLength methods
    assertTrue("Testing constructor and getCenter for NGon", equalPoints(new Point(1, 1), a.getCenter()));
    assertEquals("Testing constructor and getNumSides for NGon", 6, a.getNumSides());
    assertEquals("Testing constructor and getSideLength for NGon", 3, a.getSideLength(), 0);
    
    // Tests setCenter and setSideLength methods
    a.setCenter(new Point(2,3));
    a.setSideLength(4);
    assertTrue("Testing constructor and setCenter for NGon", equalPoints(new Point(2, 3), a.getCenter()));
    assertEquals("Testing constructor and setSideLength for NGon", 4, a.getSideLength(), 0);
    
    // Tests getPoints and getLines methods (radius for this shape is 4)
    Point[] expectedPoints = {
      new Point(2 - 4 * Math.cos((0) * Math.PI * 2 / 6), 3 - 4 * Math.sin((0) * Math.PI * 2 / 6)),
      new Point(2 - 4 * Math.cos((1) * Math.PI * 2 / 6), 3 - 4 * Math.sin((1) * Math.PI * 2 / 6)),
      new Point(2 - 4 * Math.cos((2) * Math.PI * 2 / 6), 3 - 4 * Math.sin((2) * Math.PI * 2 / 6)),
      new Point(2 - 4 * Math.cos((3) * Math.PI * 2 / 6), 3 - 4 * Math.sin((3) * Math.PI * 2 / 6)),
      new Point(2 - 4 * Math.cos((4) * Math.PI * 2 / 6), 3 - 4 * Math.sin((4) * Math.PI * 2 / 6)),
      new Point(2 - 4 * Math.cos((5) * Math.PI * 2 / 6), 3 - 4 * Math.sin((5) * Math.PI * 2 / 6))
    };
    assertTrue("Testing getPoints for NGon", equalPointSets(expectedPoints, a.getPoints()));

    Line[] expectedLines = {
      new Line(expectedPoints[0], expectedPoints[1]),
      new Line(expectedPoints[1], expectedPoints[2]),
      new Line(expectedPoints[2], expectedPoints[3]),
      new Line(expectedPoints[3], expectedPoints[4]),
      new Line(expectedPoints[4], expectedPoints[5]),
      new Line(expectedPoints[5], expectedPoints[0])
    };
    assertTrue("Testing getLines for NGon", equalLineSets(expectedLines, a.getLines()));
    Point[] points = a.getPoints();
    
    
  }
  
  // Tests Square class
  @Test
  public void testSquare() {
    // Test constructor
    Square a = new Square(new Point(2, 3), 4);
    Point[] expectedPoints = {
      new Point(2 + 2, 3 + 2),
      new Point(2 - 2, 3 + 2),
      new Point(2 - 2, 3 - 2),
      new Point(2 + 2, 3 - 2)
    };
    assertTrue("Testing constructor for Square", equalPointSets(expectedPoints, a.getPoints()));
    
    // All methods are inherrited and have been tested above (see NGon and Polygon)
  }
  
  //Tests Triangle
  @Test
  public void testTriangle() {
    // Tests constructor
    Triangle a = new Triangle(new Point(0, 0), new Point(10, 0), new Point(0, 5));
    assertTrue("Testing constructor for Triangle", equalPointSets(new Point[]{new Point(0, 0), new Point(10, 0), new Point(0, 5)}, a.getPoints()));
    
    // All remaining methods are inherited from polygon and have been tested above
  }
  
  // Tests EquilateralTriangle class
  @Test
  public void testEquilateralTriangle() {
    // Test constructor 
    EquilateralTriangle a = new EquilateralTriangle(new Point(0,0), 2);
    Point[] expectedPoints = {
      new Point(-1.0, -0.577350269189626),
      new Point(1.0, -0.577350269189626),
      new Point(0, 1.1547005383792512),
    };
    assertTrue("Testing constructor for EquilateralTriangle", equalPointSets(expectedPoints, a.getPoints()));
    
    // All methods are inherrited and have been tested above (see NGon and Polygon)
  }
  
  //Tests SnowFlake
  @Test
  public void testSnowFlake() {
    // Test constructor, getBaseShape, getNumLevels, and getCenter methods
    NGon baseShape = new NGon(new Point(1, 2), 1, 3);
    SnowFlake a = new SnowFlake(baseShape, 3);
    assertEquals("Testing constructor and getBaseShape for SnowFlake", baseShape, a.getBaseShape());
    assertEquals("Testing constructor and getNumLevels for SnowFlake", 3, a.getNumLevels());
    assertTrue("Testing constructor and getCenter for SnowFlake", equalPoints(new Point(1, 2), a.getCenter()));
    
    // Test setCenter and setNumLevels methods
    a.setNumLevels(0);
    //a.setCenter(new Point(1, 1));
    assertEquals("Testing constructor and setNumLevels for SnowFlake", 0, a.getNumLevels());
    
    
    // Test getPoints
    // zero case
    double radius = 1 / (2 * Math.sin(Math.PI / 3));
    Point[] expectedPoints = {
      new Point(1 + radius * Math.sin((0) * Math.PI * 2 / 3), 1 - radius * Math.cos((0) * Math.PI * 2 / 3)),
      new Point(1 + radius * Math.sin((1) * Math.PI * 2 / 3), 1 - radius * Math.cos((1) * Math.PI * 2 / 3)),
      new Point(1 + radius * Math.sin((2) * Math.PI * 2 / 3), 1 - radius * Math.cos((2) * Math.PI * 2 / 3)),
    };
    //assertTrue("Testing getPoints for SnowFlake", equalPointSets(expectedPoints, a.getPoints()));
    
  }
  
  
  /***
    * 
    * 
    * 
    * Helper methods
    * 
    * 
    * 
    *
    */
  
  // checks for equality of points
  private boolean equalPoints(Point point1, Point point2) {
    // accounts for rounding error
    double error = Math.pow(10, -10);
    return (point1.getX() <= point2.getX() + error && point1.getX() >= point2.getX() - error && point1.getY() <= point2.getY() + error && point1.getY() >= point2.getY() - error);
  }
  
  // tests whether the points of two Point[] contain equivalent points (in any order)
  private boolean equalPointSets(Point[] points1, Point[] points2) {
    
    if(points1.length != points2.length) {
      return false;
    }
    for(int i = 0; i < points1.length; i++) {
      if(!pointInList(points2, points1[i]))
        return false;
    }
    return true;
  }
  
  // returns whether a point is in a set of points
  private boolean pointInList(Point[] list, Point point) {
    for(int i = 0; i < list.length; i++) {
      if(equalPoints(point, list[i]))
        return true;
    }
    return false;
  }
  
  // tests whether the lines of two Line[] contain equivalent lines (in any order)
  private boolean equalLineSets(Line[] list1, Line[] list2) {
    
    if(list1.length != list2.length) {
      return false;
    }
    for(int i = 0; i < list1.length; i++) {
      if(!lineInList(list2, list1[i]))
        return false;
    }
    return true;
  }
  
  // returns whether a line is in a set of lines
  private boolean lineInList(Line[] list, Line line) {
    for(int i = 0; i < list.length; i++) {
      if(equalLines(line, list[i]))
        return true;
    }
    return false;
  }
  
  // tests whether the points of two lines are equal
  private boolean equalLines(Line line1, Line line2) {
    return equalPoints(line1.getFirstPoint(), line2.getFirstPoint()) && equalPoints(line1.getSecondPoint(), line2.getSecondPoint());
  }
  
  
  
}