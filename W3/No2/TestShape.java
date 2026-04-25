public class TestShape {
    public static void main(String[] args) {

        // Test Shape
        Shape s1 = new Shape();
        System.out.println(s1);
        System.out.println("Color: " + s1.getColor());
        System.out.println("Filled: " + s1.isFilled());

        Shape s2 = new Shape("blue", false);
        System.out.println(s2);
        s2.setColor("red");
        s2.setFilled(true);
        System.out.println("After change: " + s2);

        // Test Circle
        System.out.println("\n=== TEST CIRCLE ===");
        Circle c1 = new Circle(2.5, "red", true);
        System.out.println(c1);
        System.out.println("Area: " + c1.getArea());
        System.out.println("Perimeter: " + c1.getPerimeter());

        // Test Rectangle
        System.out.println("\n=== TEST RECTANGLE ===");
        Rectangle r1 = new Rectangle(2.0, 3.0, "blue", false);
        System.out.println(r1);
        System.out.println("Area: " + r1.getArea());
        System.out.println("Perimeter: " + r1.getPerimeter());

        // Test Square
        System.out.println("\n=== TEST SQUARE ===");
        Square sq1 = new Square(4.0, "yellow", true);
        System.out.println(sq1);
        System.out.println("Area: " + sq1.getArea());
        System.out.println("Perimeter: " + sq1.getPerimeter());

        // Test override setWidth pada Square
        sq1.setWidth(6.0);
        System.out.println("After setWidth(6.0): width=" + sq1.getWidth() + " length=" + sq1.getLength());
    }
}