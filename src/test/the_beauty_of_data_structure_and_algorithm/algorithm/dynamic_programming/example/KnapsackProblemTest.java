package test.the_beauty_of_data_structure_and_algorithm.algorithm.dynamic_programming.example;


import main.the_beauty_of_data_structure_and_algorithm.algorithm.dynamic_programming.example.KnapsackProblem;

/**
 * @author wenzhuang
 * @date 2019-10-19 20:01
 */
public class KnapsackProblemTest {
    public static void main(String[] args){
        int[] items = {2, 3, 7, 4};
        int cw1 = new KnapsackProblem().simpleOneZeroKnapsack(items, items.length, 15);
        int cw2 = new KnapsackProblem().simpleOneZeroKnapsack2(items, items.length, 15);
        System.out.println(cw1 + " " + cw2);

        int[] values = {2, 4, 3, 6};
        int cw3 = new KnapsackProblem().oneZeroKnapsack(items, values, items.length, 15);
        int cw4 = new KnapsackProblem().oneZeroKnapsack2(items, values, items.length, 15);
        System.out.println(cw3 + " " + cw4);
    }
}
