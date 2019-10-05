package main.the_beauty_of_data_structure_and_algorithm.algorithm.sort.implement;

/**
 * 选择排序
 * @author wenzhuang
 * @date 2019-10-05 18:57
 */
public class SelectionSort {
    public static void sort(int[] a){
        for (int i = 0; i < a.length; i++){
            int min = i;
            for (int j = i + 1; j < a.length; j++){
                if (a[j] < a[min]){
                    min = j;
                }
            }
            if (min != i) {
                int tmp = a[i];
                a[i] = a[min];
                a[min] = tmp;
            }
        }
    }
}
