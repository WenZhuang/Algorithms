package test.the_beauty_of_data_structure_and_algorithm.algorithm.backtracking.example;

import main.the_beauty_of_data_structure_and_algorithm.algorithm.backtracking.example.OneZeroKnapsack;

/**
 * @author wenzhuang
 * @date 2019-10-19 19:28
 */
public class OneZeroKnapsackTest {
    public static void main(String[] args){
        int[] items = {2, 3, 7, 4};
        int cw = new OneZeroKnapsack().oneZeroKnapsack(items, items.length, 15);
        System.out.println(cw);
        int[] values = {2, 4, 3, 6};
        int cw2 = new OneZeroKnapsack().oneZeroKnapsack(items, values, items.length, 15);
        System.out.println(cw2);
    }
}
