//********************************************************************
// Rectangle.java
//
// Merepresentasikan bentuk persegi panjang.
// Luas = panjang x lebar
//********************************************************************

public class Rectangle extends Shape {
    private double length; // panjang
    private double width;  // lebar

    // Constructor
    public Rectangle(double l, double w) {
        super("Rectangle"); // kirim nama ke Shape
        length = l;
        width = w;
    }

    // Menghitung luas persegi panjang
    public double area() {
        return length * width;
    }

    // Menampilkan info persegi panjang
    public String toString() {
        return super.toString() + " of length " + length + " and width " + width;
    }
}