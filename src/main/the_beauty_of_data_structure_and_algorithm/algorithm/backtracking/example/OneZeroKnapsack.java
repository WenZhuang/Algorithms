package main.the_beauty_of_data_structure_and_algorithm.algorithm.backtracking.example;

/**
 * @author wenzhuang
 * @date 2019-10-19 19:19
 */
public class OneZeroKnapsack {
    int res = 0;
    public int oneZeroKnapsack(int[] items, int n, int w){
        res = 0;
        backtracking(0, 0, items, n, w);
        return res;
    }

    private void backtracking(int i, int cw, int[] items, int n, int w){
        if (cw == w || i == n){
           res = Math.max(res, cw);
           return;
        }
        backtracking(i + 1, cw, items, n, w);
        if (cw + items[i] <= w) {
            backtracking(i + 1, cw + items[i], items, n, w);
        }
    }

    public int oneZeroKnapsack(int[] items, int[] values, int n, int w){
        res = 0;
        backtracking(0, 0, 0, items, values, n, w);
        return res;
    }

    private void backtracking(int i, int cw, int cv, int[] items, int[] values, int n, int w){
        if (cw == w || i == n){
            res = Math.max(res, cv);
            return;
        }
        backtracking(i + 1, cw, cv, items, values, n, w);
        if (cw + items[i] <= w) {
            backtracking(i + 1, cw + items[i], cv + values[i], items, values, n, w);
        }
    }
}
