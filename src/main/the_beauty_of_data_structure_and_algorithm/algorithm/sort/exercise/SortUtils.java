package main.the_beauty_of_data_structure_and_algorithm.algorithm.sort.exercise;

/**
 * @author wenzhuang
 * @date 2019-10-05 21:32
 */
public class SortUtils {
    public static int findKthLargestNum(int[] a, int k){
        int l = 0, r = a.length - 1;
        while (l <= r){
            int p = partition(a, l, r);
            if (p + 1 == k) {
                return a[p];
            } else if (p + 1 < k){
                l++;
            } else {
                r--;
            }
        }
        return a[0];
    }

    private static int partition(int[] a, int l, int r){
        if (l >= r) {
            return l;
        }
        int pivot = a[r];
        int i = l, j = l;
        while (j <= r - 1){
            if (a[j] > pivot){
                int tmp = a[j];
                a[j] = a[i];
                a[i++] = tmp;
            }
        }
        a[r] = a[i];
        a[i] = pivot;
        return i;
    }
}
