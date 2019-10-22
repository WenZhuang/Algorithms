package test.the_beauty_of_data_structure_and_algorithm.algorithm.dynamic_programming.example;

import main.the_beauty_of_data_structure_and_algorithm.algorithm.dynamic_programming.example.LongestCommonSubsequence;

/**
 * @author wenzhuang
 * @date 2019-10-20 14:03
 */
public class LongestCommonSubsequenceTest {
    public static void main(String[] args){
        char[] a = "mitcmu".toCharArray();
        char[] b = "mtacnu".toCharArray();
        System.out.println(new LongestCommonSubsequence().longestCommonSubsequence(a, b));
    }
}
