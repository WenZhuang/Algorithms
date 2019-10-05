package main.the_beauty_of_data_structure_and_algorithm.algorithm.sort.implement;

/**
 * 冒泡排序
 * @author wenzhuang
 * @date 2019-10-05 18:55
 */
public class BubbleSort {

    public static void sort(int[] a){
        if (a == null || a.length <= 1) {
            return;
        }
        for (int i = 0; i < a.length; i++){
            //这一趟排序是否有交换操作
            boolean swap = false;
            for (int j = 0; j < a.length - i - 1; j++){
                if (a[j] > a[j + 1]){
                    int tmp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = tmp;
                    swap = true;
                }
            }
            //这一趟排序中没有交换操作，说明已经有序，提前结束排序
            if (!swap){
                break;
            }
        }
    }
}
