// Kelas representasi restoran, mengelola stok ayam sebagai shared resource
class Resto {

    private int chickenStock = 100; // Stok ayam awal, diakses oleh banyak thread sekaligus

    // Solusi: synchronized ditambahkan agar hanya satu thread yang dapat mengeksekusi method ini dalam satu waktu
    // Mencegah race condition karena pengecekan stok dan pengurangan stok tidak dapat diinterupsi thread lain
    public synchronized void serveCustomer(String cashierName) {

        // Satu thread yang membaca nilai chickenStock pada satu waktu
        if (chickenStock > 0) {

            try { Thread.sleep(10); } catch (InterruptedException e) {}
            // Thread lain tetap menunggu di luar method meskipun thread ini sedang sleep

            chickenStock--; // Pengurangan stok aman, tidak ada thread lain yang dapat menyela

            System.out.println(cashierName + " berhasil menjual 1 ayam. Sisa stok: " + chickenStock);

        } else {
            System.out.println(cashierName + " gagal: Stok Habis!");
        }
    }

    public int getRemainingStock() {
        return chickenStock;
    }
}

public class RestoSimulasiSolusi {
    public static void main(String[] args) throws InterruptedException {

        Resto ayamJuicyLuicyGallagher = new Resto(); // Satu objek restoran, dipakai bersama semua kasir

        Runnable task = () -> {
            for (int i = 0; i < 40; i++) {
                // Ketiga kasir memanggil method yang sama, namun kini mengantri karena synchronized
                ayamJuicyLuicyGallagher.serveCustomer(Thread.currentThread().getName());
            }
        };

        Thread kasir1 = new Thread(task, "Kasir-A");
        Thread kasir2 = new Thread(task, "Kasir-B");
        Thread kasir3 = new Thread(task, "Kasir-C");

        kasir1.start();
        kasir2.start();
        kasir3.start();

        // Menunggu semua kasir selesai sebelum mencetak hasil akhir
        kasir1.join();
        kasir2.join();
        kasir3.join();

        // Dengan synchronized, stok akhir pasti 0 dan tidak pernah negatif
        System.out.println("--- HASIL AKHIR STOK: " + ayamJuicyLuicyGallagher.getRemainingStock() + " ---");
    }
}