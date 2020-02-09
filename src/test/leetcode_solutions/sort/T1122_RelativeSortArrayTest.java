package test.leetcode_solutions.sort;

import main.leetcode_solutions.sort.T1122_RelativeSortArray;

/**
 * @author wenzhuang
 * @date 2020/2/9 9:57 PM
 */
public class T1122_RelativeSortArrayTest {
    public static void main(String[] args){
        T1122_RelativeSortArray relativeSortArray = new T1122_RelativeSortArray();
        int[] arr1 = {2,21,43,38,0,42,33,7,24,13,12,27,12,24,5,23,29,48,30,31};
        int[] arr2 = {2,42,38,0,43,21};
        relativeSortArray.relativeSortArray(arr1, arr2);
    }
}
