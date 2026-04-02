package JavaProblems;

import java.util.Arrays;

public class ProblemThree {

    public static void main(String[] args) {

        int[] arr = {12, 4, 3, 1, 9, 657};
        int n = 3; // Mencari elemen terbesar ke-3

        int ans = Arrays.stream(arr)            // mengubah array int[] menjadi IntStream
                .boxed()                        // mengonversi IntStream → Stream<Integer> agar bisa pakai Comparator
                .sorted((a, b) -> Integer.compare(b, a)) 
                .skip(n - 1)
                .findFirst()
                .orElse(0);              // nilai default jika stream kosong

        System.out.println("The 3rd largest element is: " + ans);

    }

}