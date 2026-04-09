import java.util.Scanner;
import java.util.concurrent.atomic.AtomicLong;

public class PenjumlahanParalel {

    // Menggunakan AtomicLong agar aman saat diakses banyak thread
    // Berfungsi sebagai penampung total hasil akhir
    private static AtomicLong totalAkhir = new AtomicLong(0);

    public static void main(String[] args) throws InterruptedException {

        Scanner scanner = new Scanner(System.in);

        // Input jumlah thread
        System.out.print("Masukkan jumlah thread: ");
        int jumlahThread = scanner.nextInt();

        // Input angka akhir
        System.out.print("Masukkan angka akhir: ");
        long angkaAkhir = scanner.nextLong();

        scanner.close();

        // Membagi pekerjaan ke setiap thread (divide and conquer)
        long bagianPerThread = angkaAkhir / jumlahThread;

        // Menyimpan semua thread
        Thread[] threads = new Thread[jumlahThread];

        System.out.println("\n--- Memulai Penjumlahan Paralel ---");

        for (int i = 0; i < jumlahThread; i++) {

            // Menentukan range tiap thread
            long start = (i * bagianPerThread) + 1;
            long end = (i == jumlahThread - 1) ? angkaAkhir : (i + 1) * bagianPerThread;

            // Variabel index thread (harus final untuk lambda)
            int nomorThread = i + 1;

            threads[i] = new Thread(() -> {

                // Menampilkan tugas thread
                System.out.println("Thread-" + nomorThread + " mengerjakan dari " + start + " sampai " + end);

                // Variabel lokal untuk hasil parsial
                long hasilParsial = 0;

                // Proses penjumlahan
                for (long j = start; j <= end; j++) {
                    hasilParsial += j;
                }

                // Menampilkan hasil parsial
                System.out.println("Thread-" + nomorThread + " selesai. Hasil parsial: " + hasilParsial);

                // Menambahkan ke total akhir secara aman (thread-safe)
                totalAkhir.addAndGet(hasilParsial);

                // Dengan AtomicLong, tidak perlu synchronized lagi
            });

            // Menjalankan thread
            threads[i].start();
        }

        // Menunggu semua thread selesai
        for (Thread t : threads) {
            t.join();
        }

        // Menampilkan hasil akhir
        System.out.println("\n--- HASIL AKHIR ---");
        System.out.println("Total penjumlahan 1 sampai " + angkaAkhir + " dengan " + jumlahThread + " thread: " + totalAkhir.get());
    }
}