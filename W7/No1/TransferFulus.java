// Kelas representasi rekening bank, berisi saldo sebagai shared resource
class Account {
    int balance = 150; // Saldo awal rekening
}

public class TransferFulus {

    // throws InterruptedException karena Thread.sleep() dan join() dapat diinterupsi sistem
    public static void main(String[] args) throws InterruptedException {

        Account acc1 = new Account(); // Rekening 1, saldo awal 150
        Account acc2 = new Account(); // Rekening 2, saldo awal 150

        Thread t1 = new Thread(() -> {

            synchronized (acc1) { // Thread 1 mengunci acc1
                System.out.println("Thread 1: Mengunci acc1, mencoba mengunci acc2");

                // Simulasi jeda proses, wajib try-catch karena InterruptedException adalah checked exception
                try { Thread.sleep(100); } catch (Exception e) {}
                // Saat sleep, Thread 2 sempat mengunci acc2 terlebih dahulu
                // Thread 1 memegang acc1, membutuhkan acc2 yang sudah dipegang Thread 2
                // Thread 2 memegang acc2, membutuhkan acc1 yang sudah dipegang Thread 1 => DEADLOCK

                synchronized (acc2) { // Thread 1 mencoba mengunci acc2, sudah dipegang Thread 2
                    System.out.println("Thread 1: Mengunci acc2, transfer acc1 -> acc2");
                    acc2.balance += acc1.balance;
                }
            }
        });

        Thread t2 = new Thread(() -> {

            // Masalah: urutan kunci terbalik dari Thread 1, mengunci acc2 terlebih dahulu
            synchronized (acc2) { // Thread 2 mengunci acc2
                System.out.println("Thread 2: Mengunci acc2, mencoba mengunci acc1");

                try { Thread.sleep(100); } catch (Exception e) {}
                // Thread 2 memegang acc2, membutuhkan acc1 yang sudah dipegang Thread 1
                // Thread 1 memegang acc1, membutuhkan acc2 yang sudah dipegang Thread 2 => DEADLOCK

                synchronized (acc1) { // Thread 2 mencoba mengunci acc1, sudah dipegang Thread 1
                    System.out.println("Thread 2: Mengunci acc1, transfer acc2 -> acc1");
                    acc1.balance += acc2.balance;
                }
            }
        });

        t1.start();
        t2.start();

        // Menunggu masing-masing thread selesai sebelum lanjut ke baris berikutnya
        t1.join();
        t2.join();

        // Program tidak akan sampai sini sdikarenakan terdapat deadlock
        System.out.println("--- HASIL AKHIR ---");
        System.out.println("Saldo Akhir acc1: " + acc1.balance);
        System.out.println("Saldo Akhir acc2: " + acc2.balance);
    }
}