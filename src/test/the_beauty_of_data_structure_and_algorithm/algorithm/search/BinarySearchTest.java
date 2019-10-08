package test.the_beauty_of_data_structure_and_algorithm.algorithm.search;

import main.the_beauty_of_data_structure_and_algorithm.algorithm.search.BinarySearch;

public class BinarySearchTest {
    public static void main(String[] args){
        binarySearchTest();
    }

    private static void binarySearchTest(){
        int[] a = {1,3,5,7,9};
        System.out.println(BinarySearch.binarySearch(a, 3));
        System.out.println(BinarySearch.binarySearch2(a, 9));

        int[] b = {1,3,3,3,3,5,7};
        System.out.println(BinarySearch.searchFirstEqual(b,3));
        System.out.println(BinarySearch.searchLastEqual(b, 3));
        System.out.println(BinarySearch.searchFirstGreaterEqual(b,7));
        System.out.println(BinarySearch.searchLastLessEqual(b, 2));
    }


}
