public class Commission extends Hourly {
    private double totalSales;       // total penjualan
    private double commissionRate;   // persentase komisi (desimal)

    // CONSTRUCTOR - 6 parameter
    public Commission(String eName, String eAddress, String ePhone,
                      String socSecNumber, double rate, double commRate) {
        super(eName, eAddress, ePhone, socSecNumber, rate);
        // ↑ 5 parameter pertama dikirim ke Hourly

        commissionRate = commRate;  // parameter ke-6 disimpan sendiri
        totalSales = 0;             // awalnya belum ada penjualan
    }

    // METHOD addSales - menambah total penjualan
    public void addSales(double sales) {
        totalSales += sales;  // tambahkan ke total yang sudah ada
    }

    // OVERRIDE pay() - gaji jam + komisi
    public double pay() {
        double payment = super.pay();
        // ↑ super.pay() memanggil pay() milik Hourly
        //   = payRate × hoursWorked, dan hoursWorked otomatis direset ke 0

        payment += totalSales * commissionRate;  // tambah komisi
        totalSales = 0;  // reset setelah dibayar
        return payment;
    }

    // OVERRIDE toString() - tampilkan info + total sales
    public String toString() {
        String result = super.toString();  // ambil info dari Hourly
        result += "\nTotal Sales: " + totalSales;
        return result;
    }
}