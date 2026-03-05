//********************************************************************
// Shape.java
//
// Abstract class yang merepresentasikan bentuk geometri secara umum.
// Semua class turunan WAJIB mengimplementasikan method area().
//********************************************************************

public abstract class Shape {
    protected String shapeName; // nama bentuk

    // Constructor - menerima nama bentuk
    public Shape(String name) {
        shapeName = name;
    }

    // Method abstract - wajib di-override oleh class turunan
    public abstract double area();

    // Mengembalikan nama bentuk
    public String toString() {
        return shapeName;
    }
}