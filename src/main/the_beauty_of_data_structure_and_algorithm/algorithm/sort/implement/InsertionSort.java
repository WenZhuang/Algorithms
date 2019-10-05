package main.the_beauty_of_data_structure_and_algorithm.algorithm.sort.implement;

/**
 * 插入排序
 * @author wenzhuang
 * @date 2019-10-05 18:57
 */
public class InsertionSort {
    public static void sort(int[] a){
        if (a == null || a.length <= 1){
            return;
        }
        for (int i = 1; i < a.length; i++){
            int val = a[i];
            for (int j = i - 1; j >= 0; j--){
                if (a[j] > a[j + 1]) {
                    a[j + 1] = a[j];
                } else {
                    a[j + 1] = val;
                    break;
                }
            }
        }
    }
}
