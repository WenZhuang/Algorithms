package test.the_beauty_of_data_structure_and_algorithm.data_structure.heap;

import main.the_beauty_of_data_structure_and_algorithm.data_structure.heap.exercise.HeapUtils;

import java.util.Arrays;
import java.util.List;

/**
 * @author wenzhuang
 * @date 2019-10-07 23:23
 */
public class HeapUtilsTest {
    public static void main(String[] args){
        test_mergeKSortedArray();
        test_topK();
    }

    public static void test_mergeKSortedArray(){
        System.out.println("test_mergeKSortedArray");
        int[] a = {1,4,7};
        int[] b = {2,5,8,11};
        int[] c = {3,6,9,10,12};
        HeapUtils utils = new HeapUtils();
        int[] arr = utils.mergeKSortedArray(new int[][]{a, b, c});
        for (int x : arr) {
            System.out.print(x + ",");
        }
        System.out.println();
    }

    public static void test_topK(){
        System.out.println("test_topK");
        List<Integer> a = Arrays.asList(1,4,7,3,6,9,10,12,2,5,8,11);
        HeapUtils utils = new HeapUtils();
        List<Integer> topk = utils.topK(a, 5);
        for (Integer i: topk) {
            System.out.print(i + ",");
        }
        System.out.println();
    }
}
