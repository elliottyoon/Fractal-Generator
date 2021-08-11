This is a small little Java script that can draw out and manipulate various shapes of your liking.

Shapes that can be drawn include: 
* Square
* Rectangle
* Triangle
* Equilateral Triangle
* N-Gon (or Polygon)
* Snowflake
---

![image](https://user-images.githubusercontent.com/33074434/128992036-90857315-862c-4dd9-a009-8e4c8e9df46d.png)

---

**To use**:
1. Open this repository in your working directory
2. Create an instance of the `Shape` object of your liking in a new method of the `ShapeTester` file. Inside this method:
  * Manipulate the shape using the provided class methods if you wish to do so.
  * Create the array `Point[] points` whose elements are the output of your shape's `getPoints()` method. Iterate through each individual point with the following code:
    * `for (int i = 0; i < points.length; i++) { 
          System.out.println("(" + String.valueOf(points[i].getX()) + "," + String.valueOf(points[i].getY()) + ")");
    } `
3. Call the your method from step 2 in the main method of `ShapeTester` to return the plotted points of your shape.
4. Run the `ShapeTester.java` file.
5. Copy paste the output points into a graphing calculator (Desmos is strongly recommended).

Enjoy!

---
Note: this repository supports JavaDoc and the raw HTML documentation files can be found in the `/doc` subfolder.
