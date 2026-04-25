//********************************************************************
// Paint.java
//
//   Represents a type of paint that has a fixed area 
//   covered by a gallon. All measurements are in feet.
//********************************************************************

public class Paint {
    private double coverage; // luas yang bisa dicat per galon

    // Constructor
    public Paint(double c) {
        coverage = c;
    }

    // Menghitung jumlah galon cat yang dibutuhkan
    public double amount(Shape s) {
        System.out.println("Computing amount for " + s);
        return s.area() / coverage; // Diperbaiki dari return 0
        // luas bentuk dibagi coverage = jumlah galon yang dibutuhkan
    }
}