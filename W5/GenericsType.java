public class GenericsType<T> {
    // T = tipe data generik, artinya tipenya ditentukan nanti saat objek dibuat
    // bisa jadi String, Integer, atau tipe apapun sesuai kebutuhan
    private T t;

    // method get() mengembalikan tipe T, sesuai tipe yang ditentukan saat objek dibuat
    public T get() {
        return this.t;
    }

    // method set() menerima parameter bertipe T
    public void set(T t1) {
        this.t = t1;
    }

    public static void main(String args[]) {
        // <String> artinya T diganti String, jadi type hanya bisa menyimpan String
        GenericsType<String> type = new GenericsType<>();
        type.set("Java"); // valid

        // raw type = memakai GenericsType tanpa menentukan tipenya
        // tidak disarankan karena tidak ada pengecekan tipe data
        GenericsType type1 = new GenericsType(); // raw type
        type1.set("Java"); // valid, menyimpan String
        type1.set(10); // valid karena raw type menerima apapun, 10 otomatis jadi Integer (autoboxing)
    }
}
