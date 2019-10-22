package main.the_beauty_of_data_structure_and_algorithm.algorithm.dynamic_programming.example;

/**
 * @author wenzhuang
 * @date 2019-10-19 19:34
 */
public class KnapsackProblem {

    /**
     * dp[i][j]当装到第i件物品，重量能否到达j
     * dp[i][j] = dp[i - 1][j] | dp[i][j - items[i]]
     * 解为max{dp[n - 1][j]},0<=j<=w
     * @param items
     * @param n
     * @param w
     * @return
     */
    public int simpleOneZeroKnapsack(int[] items, int n, int w){
        int res = 0;
        boolean[][] dp = new boolean[n][w + 1];
        dp[0][0] = true;
        if (items[0] <= w) {
            dp[0][items[0]] = true;
            res = items[0];
        }
        for (int i = 1; i < n; i++){
            for (int j = 1; j <= w; j++){
                dp[i][j] = dp[i - 1][j];
                if (j >= items[i]){
                    dp[i][j] |= dp[i - 1][j - items[i]];
                }
                //取最后一行最大的重量
                if (i == n - 1 && dp[i][j]){
                    res = Math.max(res, j);
                }

            }

        }
        //打印出选择的物品，非必须
        int j = res;
        for (int i = n - 1; i >= 1; i--){
            if (j >= items[i] && dp[i - 1][j - items[i]]){
                System.out.print(items[i] + " ");
                j -= items[i];
            }
        }
        if (j > 0) {
            System.out.print(items[0]);
        }
        System.out.println();
        return res;
    }

    /**
     * 优化空间解法
     * dp[j] = dp[j] | dp[j - items[i]]
     * 解为max{dp[j]},0<=j<=w
     * @param items
     * @param n
     * @param w
     * @return
     */
    public int simpleOneZeroKnapsack2(int[] items, int n, int w){
        int res = 0;
        boolean[] dp = new boolean[w + 1];
        dp[0] = true;
        if (items[0] <= w) {
            dp[items[0]] = true;
            res = items[0];
        }
        for (int i = 1; i < n; i++){
            for (int j = w; j >= items[i]; j--){
                dp[j] |= dp[j - items[i]];
                //取最后一行最大的重量
                if (i == n - 1 && dp[j]){
                    res = Math.max(res, j);
                }
            }
        }
        return res;
    }

    /**
     * 求最大价值的01背包问题
     * dp[i][j]，决策第i件物品后总重量为j时的总价值
     * dp[i][j] = max{dp[i - 1][j], dp[i - 1][j - items[i]] + values[i]}
     * 最终的结果为max{dp[n-1][j]},0<=j<=w
     * @param items
     * @param values
     * @param n
     * @param w
     * @return
     */
    public int oneZeroKnapsack(int[] items, int[] values, int n, int w){
        int res = 0;
        int[][] dp = new int[n][w + 1];
        if (items[0] <= w) {
            dp[0][items[0]] = values[0];
            res = values[0];
        }
        int lw = 0;
        for (int i = 1; i < n; i++){
            for (int j = 0; j <= w; j++){
                dp[i][j] = dp[i - 1][j];
                if (j >= items[i]){
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - items[i]] + values[i]);
                }
                if (i == n - 1){
                    if (dp[i][j] > res){
                        res = dp[i][j];
                        lw = j;
                    }
                }
            }
        }
        //打印出选择的物品，非必须
        int j = lw;
        for (int i = n - 1; i >= 1; i--){
            if (j >= items[i] && dp[i - 1][j - items[i]] > 0){
                j -= items[i];
                System.out.print(items[i] + " ");
            }
        }
        if (j > 0) {
            System.out.print(items[0]);
        }
        System.out.println();
        return res;
    }

    /**
     * 求最大价值的01背包问题，空间优化
     * @param items
     * @param values
     * @param n
     * @param w
     * @return
     */
    public int oneZeroKnapsack2(int[] items, int[] values, int n, int w){
        int res = 0;
        int[] dp = new int[w + 1];
        if (items[0] <= w) {
            dp[items[0]] = values[0];
            res = values[0];
        }
        for (int i = 1; i < n; i++){
            for (int j = w; j >= items[i]; j--){
                dp[j] = Math.max(dp[j], dp[j - items[i]] + values[i]);
                if (i == n - 1){
                    res = Math.max(res, dp[j]);
                }
            }
        }
        return res;
    }
}
