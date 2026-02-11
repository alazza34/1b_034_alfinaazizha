import java.util.Scanner;

public class DataTypes {
    public static void main(String[] args) {

        //Input banyak test case
        try (Scanner sc = new Scanner(System.in)) {
            //Input banyak test case
            System.out.print("Masukkan banyak T: ");
            int T = sc.nextInt();
            
            //Banyak perulangan
            for (int i = 1; i <= T; i++) {
                
                System.out.print("Masukkan N ke-" + i + ": ");
                
                try {
                    //Membaca sebagai long
                    long n = sc.nextLong();
                    
                    System.out.println(n + " can be fitted in:");
                    
                    //Mengecek rentang byte
                    if (n >= -128 && n <= 127)
                        System.out.println("  * byte");
                    
                    //Mengecek rentang short
                    if (n >= -32768 && n <= 32767)
                        System.out.println("  * short");
                    
                    //Mengecek rentang int
                    if (n >= -2147483648L && n <= 2147483647L)
                        System.out.println("  * int");
                    
                    //Jika bisa masuk long, maka akan masuk long
                    System.out.println("  * long");
                    
                } catch (Exception e) {
                    //Tidak masuk ke manapun
                    System.out.println(sc.next() + " can't be fitted anywhere.");
                }
            }
        }
    }
}
