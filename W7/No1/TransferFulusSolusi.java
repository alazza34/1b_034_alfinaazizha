class Account {
    int balance = 150;
}

public class TransferFulusSolusi {
    public static void main(String[] args) throws InterruptedException {

        Account acc1 = new Account();
        Account acc2 = new Account();

        Thread t1 = new Thread(() -> {

            // Urutan kunci: acc1 terlebih dahulu, baru acc2
            synchronized (acc1) {
                System.out.println("Thread 1: Mengunci acc1, mencoba mengunci acc2!");

                try { Thread.sleep(100); } catch (Exception e) {}

                synchronized (acc2) {
                    System.out.println("Thread 1: Mengunci acc2, transfer acc1 -> acc2");
                    acc2.balance += acc1.balance;
                }
            }
        });

        Thread t2 = new Thread(() -> {

            // SOLUSI: urutan kunci disamakan dengan Thread 1, acc1 terlebih dahulu baru acc2
            // Thread 2 menunggu Thread 1 melepas acc1 sebelum dapat masuk
            synchronized (acc1) {
                System.out.println("Thread 2: Mengunci acc1, mencoba mengunci acc2!");

                try { Thread.sleep(100); } catch (Exception e) {}

                synchronized (acc2) {
                    System.out.println("Thread 2: Mengunci acc2, transfer acc2 -> acc1");
                    acc1.balance += acc2.balance;
                }
            }
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println("--- HASIL AKHIR ---");
        System.out.println("Saldo Akhir acc1: " + acc1.balance);
        System.out.println("Saldo Akhir acc2: " + acc2.balance);
    }
}