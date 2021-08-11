/**
 * Tester class for the shapes
 * 
 * @author  Elliott Yoon
 */
public class ShapeTester {
  
  public static void main(String args[]) {
    triangleSnow();
    //eqTriangle();
    //hexSnow();
    //rectangle();
  }
  
  // tests the points of an snowflake (triangle)
  public static void triangleSnow() {
    Point p = new Point(0,0);
    EquilateralTriangle t = new EquilateralTriangle(p,4);
    
    System.out.println("Points of a snowflake with base shape triangle: ");
    SnowFlake s = new SnowFlake(t, 4);
    Point[] points = s.getPoints();
    for (int i = 0; i < points.length; i++) { // plot this output in desmos
      System.out.println("(" + String.valueOf(points[i].getX()) + "," + String.valueOf(points[i].getY()) + ")");
    } 
  }
    
  // tests the points of a rectangle
  public static void rectangle() {
    // Initializes a rectangle centered at (1, 1) with width 5 and height 10
    Rectangle a = new Rectangle(new Point(1,1), 5, 10);
    
    // Tests setCenter, setWidth and setHeight methods
    a.setCenter(new Point(2,3));
    a.setWidth(3);
    a.setHeight(6);
    Point[] points = a.getPoints();
    for (int i = 0; i < points.length; i++) { // plot this output in desmos
      System.out.println("(" + String.valueOf(points[i].getX()) + "," + String.valueOf(points[i].getY()) + ")");
    } 
    
    // tests for rotate
    a.rotate(0);
    Point[] points1 = a.getPoints();
    for (int i = 0; i < points1.length; i++) { // plot this output in desmos
      System.out.println("(" + String.valueOf(points1[i].getX()) + "," + String.valueOf(points1[i].getY()) + ")");
    }   
    
  }
    
    


  // tests the points of an equilateral triangle
  public static void eqTriangle() { 
    Point p = new Point(0,0);
    EquilateralTriangle t = new EquilateralTriangle(p,1);
    System.out.println("Points of an equilateral triangle: ");
    for (int i = 0; i < 3; i++) {
      System.out.println("(" + String.valueOf(t.getPoints()[i].getX()) + "," + String.valueOf(t.getPoints()[i].getY()) + ")");
    }
  }
  
  
  // tests the points of a snowflake (hexagon)
  public static void hexSnow() {
    Point p2 = new Point(0, 5);
    NGon n = new NGon(p2, 6, 1);
    System.out.println("Points of a snowflake with base shape hexagon: ");
    SnowFlake s1 = new SnowFlake(n, 3);
    Point[] points1 = s1.getPoints();
    for (int i = 0; i < points1.length; i++) { // plot this output in desmos
      System.out.println("(" + String.valueOf(points1[i].getX()) + "," + String.valueOf(points1[i].getY()) + ")");
    }
  }
}