/**
 * The Circle class models a circle with a radius and color.
 */
public class Circle { // Save as "Circle.java"
    // private instance variable, not accessible from outside this class
    private double radius;
    private String color; // A.1: variable color ditambahkan

    // Constructors (overloaded)
    /** Constructs a Circle instance with default value for radius and color */
    public Circle() { // 1st (default) constructor
        radius = 1.0;
        color = "red";
    }

    /** Constructs a Circle instance with the given radius and default color */
    public Circle(double r) { // 2nd constructor
        radius = r;
        color = "red";
    }

    /** A.1: Constructs a Circle instance with given radius and color */
    public Circle(double r, String c) { // new constructor
        radius = r;
        color = c;
    }

    /** Returns the radius */
    public double getRadius() {
        return radius;
    }

    /** Sets the radius */
    public void setRadius(double r) {
        radius = r;
    }

    /** A.1: Getter for color */
    public String getColor() {
        return color;
    }

    /** A.1: Setter for color */
    public void setColor(String c) {
        color = c;
    }

    /** Returns the area of this Circle instance */
    public double getArea() {
        return radius * radius * Math.PI;
    }

    /** Returns a self-descriptive string of this instance */
    public String toString() {
        return "Circle[radius=" + radius + " color=" + color + "]";
    }
}