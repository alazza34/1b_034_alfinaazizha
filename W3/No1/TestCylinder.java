public class TestCylinder { // Save as "TestCylinder.java"
    public static void main(String[] args) {
        // Cylinder default
        Cylinder c1 = new Cylinder();
        System.out.println(c1.toString());
        System.out.println("Base area=" + superBaseArea(c1));
        System.out.println("Volume=" + c1.getVolume());

        // Cylinder dengan tinggi 10.0
        Cylinder c2 = new Cylinder(10.0);
        System.out.println(c2.toString());
        System.out.println("Base area=" + superBaseArea(c2));
        System.out.println("Volume=" + c2.getVolume());

        // Cylinder dengan radius 2.0, tinggi 10.0
        Cylinder c3 = new Cylinder(2.0, 10.0);
        System.out.println(c3.toString());
        System.out.println("Base area=" + superBaseArea(c3));
        System.out.println("Volume=" + c3.getVolume());

        // Cylinder dengan radius 3.0, tinggi 5.0, color biru
        Cylinder c4 = new Cylinder(3.0, 5.0, "blue");
        System.out.println(c4.toString());
        System.out.println("Base area=" + superBaseArea(c4));
        System.out.println("Volume=" + c4.getVolume());
    }

    // Method untuk mengambil luas alas Circle (tanpa override Cylinder)
    public static double superBaseArea(Cylinder cyl) {
        return cyl.getVolume() / cyl.getHeight(); // volume / tinggi = luas alas
    }
}