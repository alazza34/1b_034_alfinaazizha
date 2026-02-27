public class EmployeeTest {
    public static void main(String[] args) {
        Employee[] staff = new Employee[3];

        staff[0] = new Employee("Antonio Rossi", 2000000, 1, 10, 1989);
        staff[1] = new Employee("Maria Bianchi", 2500000, 1, 12, 1991);
        staff[2] = new Employee("Isabel Vidal", 3000000, 1, 11, 1993);

        for (int i = 0; i < 3; i++) {
            staff[i].raiseSalary(5);
        }

        for (int i = 0; i < 3; i++) {
            staff[i].print();
        }

        // PERUBAHAN: tambahan pengujian method compare()
        Employee e1 = new Employee("A", 2000, 1, 1, 2000);
        Employee e2 = new Employee("B", 3000, 1, 1, 2000);
        int hasil = e1.compare(e2);
        System.out.println("\n=== INSTRUKSI 1 (A) ===");
        System.out.println("Hasil compare: " + hasil);
    }
} 

