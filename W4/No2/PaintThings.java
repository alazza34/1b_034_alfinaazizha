//********************************************************************
// PaintThings.java
// 
//  Computes the amount of paint needed to paint various 
//  things. Uses the amount method of the paint class which 
//  takes any Shape as a parameter. 
//********************************************************************

import java.text.DecimalFormat;

public class PaintThings {
    public static void main(String[] args) {
        final double COVERAGE = 350;
        Paint paint = new Paint(COVERAGE);

        Rectangle deck;
        Sphere bigBall;
        Cylinder tank;
        double deckAmt, ballAmt, tankAmt;

        // Instansiasi 3 objek bentuk sesuai soal
        deck    = new Rectangle(20, 35);    // panjang 20, lebar 35 kaki
        bigBall = new Sphere(15);             // jari-jari 15 kaki
        tank    = new Cylinder(10, 30);    // jari-jari 10, tinggi 30 kaki

        // Hitung jumlah cat yang dibutuhkan masing-masing bentuk
        // amount() menerima Shape apapun, tetapi memanggil area() yang berbeda tergantung tipe objeknya
        deckAmt  = paint.amount(deck);
        ballAmt  = paint.amount(bigBall);
        tankAmt  = paint.amount(tank);

        // Tampilkan hasilnya
        DecimalFormat fmt = new DecimalFormat("0.#");
        System.out.println("\nNumber of gallons of paint needed...");
        System.out.println("Deck     " + fmt.format(deckAmt));
        System.out.println("Big Ball " + fmt.format(ballAmt));
        System.out.println("Tank     " + fmt.format(tankAmt));
    }
}