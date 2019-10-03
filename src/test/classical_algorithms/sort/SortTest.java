package test.classical_algorithms.sort;

import main.classical_algorithms.sort.Sort;

/**
 * @author wenzhuang
 * @date 2019-10-03 15:08
 */
public class SortTest {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Integer[] a = new Integer[10];
        final int N = a.length;
        for(int i = 0; i < N; i++){
            a[i] = (int) (Math.random()*100);
        }
        System.out.println("排序前");
        for(int i = 0; i < N; i++){
            System.out.print(a[i] + " ");
        }
        Sort.BubbleSort(a);
		Sort.selectionSort(a);
		Sort.insertionSort(a);
        System.out.println("\n排序后");
        for(int i = 0; i < N; i++){
            System.out.print(a[i] + " ");
        }
    }
}
