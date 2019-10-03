package main.classical_algorithms.sort;

/**
 * @author wenzhuang
 * @date 2019-10-03 15:07
 */
public class Sort {
    public static void selectionSort(Comparable[] a) {
        final int N = a.length;
        for (int i = 0; i < N; i++) {
            int min = i;
            for (int j = i; j < N; j++)
                if (less(a[j], a[min])) {
                    min = j;
                }
            exch(a, i, min);
        }
    }

    public static void insertionSort(Comparable[] a) {
        final int N = a.length;
        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j > 0; j--)
                if (less(a[j], a[j - 1])) {
                    exch(a, j, j - 1);
                }
        }
    }

    public static void BubbleSort(Comparable[] a) {
        final int N = a.length;
        for (int i = N - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (less(a[j + 1], a[j])) {
                    exch(a, j, j + 1);
                }
            }
        }
    }

    public static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    public static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}
