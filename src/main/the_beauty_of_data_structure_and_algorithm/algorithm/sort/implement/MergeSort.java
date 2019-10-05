package main.the_beauty_of_data_structure_and_algorithm.algorithm.sort.implement;

/**
 * @author wenzhuang
 * @date 2019-10-05 19:35
 */
public class MergeSort {

    public static void sort(int[] a){
        sort(a, 0, a.length - 1);
    }

    private static void sort(int[] a, int l, int r){
        if (l >= r) {
            return;
        }
        int mid = ((r - l) >> 1) + l;
        sort(a, l, mid);
        sort(a, mid + 1, r);
        merge(a, l, mid, r);
    }

    private static void merge(int[] a, int l, int mid, int r){
        int[] tmp = new int[r - l + 1];
        int i = l, j = mid + 1, index = 0;
        while (i <= mid && j <= r){
            if (a[i] <= a[j]){
                tmp[index++] = a[i++];
            } else {
                tmp[index++] = a[j++];
            }
        }

        while (i <= mid){
            tmp[index++] = a[i++];
        }
        while (j <= r){
            tmp[index++] = a[j++];
        }

        for (int k = 0; k < tmp.length; k++) {
            a[k + l] = tmp[k];
        }
    }

    //TODO 应用：求逆序对
}
