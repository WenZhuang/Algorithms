package main.the_beauty_of_data_structure_and_algorithm.algorithm.sort.implement;

/**
 * @author wenzhuang
 * @date 2019-10-05 19:36
 */
public class HeapSort {
    public static void sort(int[] a){
        int n = a.length - 1;
        //建堆
        buildHeap(a);
        //排序
        while (n > 0) {
            exch(a, 0, n--);
            sink(a, 0, n);
        }
    }

    private static void buildHeap(int[] a){
        for (int i = a.length / 2 - 1; i >= 0; i--){
            sink(a, i, a.length - 1);
        }
    }

    //TODO
    private static void sink(int[] a, int i, int n){
        while (2 * i + 1 <= n){
            int index = i;
            if (a[2 * i + 1] > a[i]) {
                index = 2 * i + 1;
            }
            if (2 * i + 2 <= n && a[2 * i + 2] > a[i]){
                index = a[2 * i + 2];
            }
        }
    }

    private static void swim(int[] a, int i){
        while (i > 0 && a[(i - 1) / 2] < a[i]){
            exch(a, (i - 1)/ 2, i);
            i = (i - 1) / 2;
        }
    }

    private static void exch(int[] a, int i, int j){
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}
