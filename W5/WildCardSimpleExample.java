import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;

/**
 * Wildcard Arguments With An Unknown Type
 * @author javaguides.net
 **/
public class WildCardSimpleExample {

    // Collection<?> artinya method ini menerima Collection bertipe apapun
    // tanda ? disebut wildcard = tipe data tidak diketahui/tidak dibatasi
    public static void printCollection(Collection<?> c) {
        // Object e karena tipenya tidak diketahui, semua ditampung sebagai Object
        for (Object e : c) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {

        // Collection bertipe String menggunakan ArrayList
        Collection<String> collection = new ArrayList<>();
        collection.add("ArrayList Collection");
        printCollection(collection);

         // Collection bertipe String menggunakan LinkedList
        Collection<String> collection2 = new LinkedList<>();
        collection2.add("LinkedList Collection");
        printCollection(collection2);

        // Collection bertipe String menggunakan HashSet
        Collection<String> collection3 = new HashSet<>();
        collection3.add("HashSet Collection");
        printCollection(collection3);
    }
}
