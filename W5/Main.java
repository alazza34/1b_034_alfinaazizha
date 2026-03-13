// interface dengan Generic <T>, tetapi T dibatasi hanya tipe yang bisa dibandingkan (Comparable)
interface MinMax<T extends Comparable<T>> {
    T max();
}

// MyClass mengimplementasikan interface MinMax
// T extends Comparable<T> artinya T harus mempunyai kemampuan membandingkan nilai
class MyClass<T extends Comparable<T>> implements MinMax<T> {
    // array untuk menyimpan data bertipe T
    T[] vals;

    // constructor menerima array bertipe T
    MyClass(T[] o) {
        vals = o;
    }

    public T max() {
        // anggap elemen pertama sebagai nilai terbesar sementara
        T v = vals[0];
        
        for (int i = 1; i < vals.length; i++) {
            // Menggunakan method compareTo dari interface Comparable
            if (vals[i].compareTo(v) > 0) {
                v = vals[i];
            }
        }
        return v;
    }
}

public class Main {
    public static void main(String[] args) {
        Integer[] inums = {3, 6, 2, 8, 6};
        Character[] chs = {'b', 'r', 'p', 'w'};

        // T diganti Integer, jadi MyClass khusus untuk Integer
        MyClass<Integer> a = new MyClass<>(inums);
        // T diganti Character, jadi MyClass khusus untuk Character
        MyClass<Character> b = new MyClass<>(chs);

        System.out.println("Nilai Integer Terbesar: " + a.max());
        System.out.println("Karakter Terbesar: " + b.max());
    }
}
