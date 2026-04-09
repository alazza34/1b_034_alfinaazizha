// Kelas representasi restoran, mengelola stok ayam sebagai shared resource
class Resto {

    private int chickenStock = 100; // Stok ayam awal, diakses oleh banyak thread sekaligus

    // Masalah: method ini tidak thread-safe
    // Banyak thread dapat masuk ke method ini secara bersamaan
    public void serveCustomer(String cashierName) {

        // Masalah: pengecekan stok dan pengurangan stok bukan operasi atomik
        // Thread A mengecek stok > 0, lalu Thread B juga mengecek sebelum Thread A sempat mengurangi
        // Keduanya lolos pengecekan padahal stok tinggal 1 sehingga stok bisa jadi negatif
        if (chickenStock > 0) {

            try { Thread.sleep(10); } catch (InterruptedException e) {}
            // Jeda 10ms memperparah race condition, karena thread lain sempat masuk di antara if dan chickenStock--

            chickenStock--; // Pengurangan stok tidak aman, bisa diakses secara bersamaan oleh thread lain

            System.out.println(cashierName + " berhasil menjual 1 ayam. Sisa stok: " + chickenStock);

        } else {
            System.out.println(cashierName + " gagal: Stok Habis!");
        }
    }

    public int getRemainingStock() {
        return chickenStock;
    }
}

public class RestoSimulasi {
    public static void main(String[] args) throws InterruptedException {

        Resto ayamJuicyLuicyGallagher = new Resto(); // Satu objek restoran, dipakai bersama semua kasir

        // Satu task yang sama dijalankan oleh semua kasir
        Runnable task = () -> {
            for (int i = 0; i < 40; i++) {
                // Setiap kasir mencoba melayani 40 pelanggan
                // Total percobaan: 3 kasir x 40 = 120, padahal hanya terdapat 100 stok ayam
                ayamJuicyLuicyGallagher.serveCustomer(Thread.currentThread().getName());
            }
        };

        Thread kasir1 = new Thread(task, "Kasir-A"); // Kasir A menjalankan task yang sama
        Thread kasir2 = new Thread(task, "Kasir-B"); // Kasir B menjalankan task yang sama
        Thread kasir3 = new Thread(task, "Kasir-C"); // Kasir C menjalankan task yang sama

        kasir1.start();
        kasir2.start();
        kasir3.start();

        // Menunggu semua kasir selesai sebelum mencetak hasil akhir
        kasir1.join();
        kasir2.join();
        kasir3.join();

        // Karena race condition, hasil akhir stok bisa negatif atau tidak konsisten
        System.out.println("--- HASIL AKHIR STOK: " + ayamJuicyLuicyGallagher.getRemainingStock() + " ---");
    }
}