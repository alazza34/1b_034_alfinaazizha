public class Cylinder extends Circle { // Save as "Cylinder.java"
    private double height; // private variable

    // A.2: Constructor with default color, radius and height
    public Cylinder() {
        super(); // memanggil constructor Circle() default
        this.height = 1.0;
    }

    // Constructor with default radius, color but given height
    public Cylinder(double height) {
        super(); // memanggil constructor Circle() default
        this.height = height;
    }

    // Constructor with default color, but given radius, height
    public Cylinder(double radius, double height) {
        super(radius); // memanggil constructor Circle(radius)
        this.height = height;
    }

    // Constructor with given radius, height, and color
    public Cylinder(double radius, double height, String color) { // A.1 tambahan
        super(radius, color);
        this.height = height;
    }

    // A.2: Getter for height
    public double getHeight() {
        return height;
    }

    // B: Perbaikan getVolume() setelah overriding getArea()
    public double getVolume() {
        return super.getArea() * height;
    }

    // B: Overriding getArea untuk luas permukaan tabung
    @Override
    public double getArea() {
        return 2 * Math.PI * getRadius() * height + 2 * super.getArea();
        // 2π r h + 2π r^2
    }

    // C: Overriding toString
    @Override
    public String toString() {
        return "Cylinder: subclass of " + super.toString() // memanggil toString milik Circle
               + " height=" + height;
    }
}