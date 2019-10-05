package main.the_beauty_of_data_structure_and_algorithm.algorithm.sort.implement;

/**
 * @author wenzhuang
 * @date 2019-10-05 19:36
 */
public class QuickSort {

    public static void sort(int[] a){
        sort(a, 0, a.length - 1);
    }

    private static void sort(int[] a, int l, int r){
        if (l >= r) {
            return;
        }
        int p = partition(a, l, r);
        sort(a, l, p - 1);
        sort(a, r, p + 1);
    }

    /**
     * 单向切分解法
     * @param a
     * @param l
     * @param r
     * @return
     */
    private static int partition(int[] a, int l, int r){
        int pivot = a[r];
        int i = 0, j = 0;
        while (j <= r - 1){
            if (a[j] < pivot){
                int tmp = a[j];
                a[j] = a[i];
                a[i++] = tmp;
            }
            j++;
        }
        a[r] = a[i];
        a[i] = pivot;
        return i;
    }

    /**
     * 双向切分解法：见sedgewick-algorithms解法
     * @param a
     * @param l
     * @param r
     * @return
     */
    private static int partition2(int[] a, int l, int r){
        int pivot = a[l];
        int i = l, j = r + 1;
        while (true){
            while (a[++i] < pivot){
                if (i == r) {break;
                }
            };
            while (a[--j] > pivot){
                if (j == l){
                    break;
                }
            };
            if (i >= j){
                break;
            }
            int tmp = a[i];
            a[i] = a[j];
            a[j] = tmp;
        }
        a[l] = a[j];
        a[j] = pivot;
        return j;
    }

}
