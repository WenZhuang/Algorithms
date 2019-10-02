package test.the_beauty_of_data_structure_and_algorithm.data_structure.array.implement;

import main.the_beauty_of_data_structure_and_algorithm.data_structure.array.implement.ArrayList;
import main.the_beauty_of_data_structure_and_algorithm.data_structure.array.implement.ArrayUtils;

/**
 * @author wenzhuang
 * @date 2019-10-02 18:16
 */
public class ArrayUtilsTest {
    public static void main(String[] args){
        arrayListTest();
    }

    private static void arrayListTest(){
        int[] arr1 = new int[15];
        for (int i = 0; i < 15; i++) {
            arr1[i] = 2 * i;
            System.out.print(arr1[i] + ",");
        }
        System.out.println();

        int[] arr2 = new int[21];
        for (int i = 0; i < 21; i++) {
            arr2[i] = i;
            System.out.print(arr2[i] + ",");
        }
        System.out.println();
        int[] arr = ArrayUtils.mergeSortedTwoArrays(arr1, arr2);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ",");
        }
    }
}
