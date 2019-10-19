package main.the_beauty_of_data_structure_and_algorithm.algorithm.divide_conquer.example;

/**
 * 求数组逆序对
 * @author wenzhuang
 * @date 2019-10-19 14:02
 */
public class InversionPair {

    int num = 0;

    public int inversionPair(int[] a){
        num = 0;
        mergeSort(a, 0, a.length - 1);
        return num;
    }

    private void mergeSort(int[] a, int low, int high){
        if (low >= high){
            return;
        }
        int mid = ((high - low) >> 1) + low;
        mergeSort(a, low, mid);
        mergeSort(a, mid + 1, high);
        merge(a, low, mid, high);
    }

    private void merge(int[] a, int low, int mid, int high){
        int[] tmp = new int[high - low + 1];
        int i = low, j = mid + 1, index = 0;
        while (i <= mid && j <= high){
            if (a[i] <= a[j]){
                tmp[index++]= a[i++];
            } else {
                tmp[index++] = a[j++];
                num += mid - i + 1;
            }
        }
        while (i <= mid){
            tmp[index++] = a[i++];
        }
        while (j <= high){
            tmp[index++] = a[j++];
        }
        for (int k = 0; k < tmp.length; k++){
            a[k + low] = tmp[k];
        }
    }
}
