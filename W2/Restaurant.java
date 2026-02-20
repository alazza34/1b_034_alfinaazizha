public class Restaurant {

    private final String[] nama_makanan;
    private final double[] harga_makanan;
    private final int[] stok;
    private int id = 0;

    public Restaurant() {
        nama_makanan = new String[10];
        harga_makanan = new double[10];
        stok = new int[10];
    }

    public void tambahMenuMakanan(String nama, double harga, int stok) {
        if (stok < 0) {
            System.out.println("Stok tidak boleh negatif!");
            return;
        }

        nama_makanan[id] = nama;
        harga_makanan[id] = harga;
        this.stok[id] = stok;
        id++;
    }

    public int getStok(int index) {
        return stok[index];
    }

    public void setStok(int index, int stokBaru) {
        if (stokBaru >= 0) {
            stok[index] = stokBaru;
        } else {
            System.out.println("Stok tidak boleh negatif!");
        }
    }

    public void tampilMenuMakanan() {
        for (int i = 0; i < id; i++) {
            if (stok[i] > 0) {
                System.out.println(
                        nama_makanan[i] + " [" + stok[i] + "] \tRp. " + harga_makanan[i]
                );
            }
        }
    }

    public void pesanMenu(String nama, int jumlah) {
        for (int i = 0; i < id; i++) {
            if (nama_makanan[i].equalsIgnoreCase(nama)) {

                if (stok[i] >= jumlah) {
                    stok[i] -= jumlah;
                    System.out.println("Pesanan berhasil!");
                } else {
                    System.out.println("Pesanan ditolak, stok tidak mencukupi!");
                }
                return;
            }
        }

        System.out.println("Menu tidak ditemukan!");
    }
}
