//********************************************************************
// Cylinder.java
//
// Merepresentasikan bentuk silinder.
// Luas permukaan = PI * radius^2 * height
//********************************************************************

public class Cylinder extends Shape {
    private double radius; // jari-jari
    private double height; // tinggi

    // Constructor
    public Cylinder(double r, double h) {
        super("Cylinder"); // kirim nama ke Shape
        radius = r;
        height = h;
    }

    // Menghitung luas permukaan silinder
    public double area() {
        return Math.PI * radius * radius * height;
    }

    // Menampilkan info silinder
    public String toString() {
        return super.toString() + " of radius " + radius + " and height " + height;
    }
}