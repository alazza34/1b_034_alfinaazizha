public class GenericsTypeOld {
    // Object = tipe data paling umum di Java, artinya variabel t bisa menyimpan data apapun (String, Integer, Double, dll)
    private Object t;

    // method untuk mengambil data yang tersimpan
    public Object get() {
        return t;
    }

    // method untuk menyimpan data
    public void set(Object t) {
        // this.t merujuk ke variabel t milik class, bukan parameter t
        this.t = t;
    }

    public static void main(String args[]) {
            GenericsTypeOld type = new GenericsTypeOld();
            type.set("Java");
            // type casting: memaksa Object menjadi String
            String str = (String) type.get(); // type casting, error prone and can cause ClassCastException
        }
}
