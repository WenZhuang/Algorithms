package main.the_beauty_of_data_structure_and_algorithm.data_structure.array.implement;

/**
 * 数组工具类
 * @author wenzhuang
 * @date 2019-10-02 18:09
 */
public class ArrayUtils {

    /**
     * 合并两个有序数组
     * @param a
     * @param b
     * @return
     */
    public static int[] mergeSortedTwoArrays(int[] a, int[] b){
        int m = a.length;
        int n = b.length;
        int[] nArray = new int[m + n];

        int i = 0, j = 0, index = 0;
        while (i < m && j < n){
            if (a[i] <= b[j]){
                nArray[index++] = a[i++];
            } else {
                nArray[index++] = b[j++];
            }
        }
        while (i < m){
            nArray[index++] = a[i++];
        }
        while (j < n){
            nArray[index++] = b[j++];
        }
        return nArray;
    }
}
