package main.leetcode_solutions.dynamic_programming;

/**
 * 找零钱1
 * @author wenzhuang
 * @date 2019-10-20 19:41
 */
public class T322_CoinChange {
    /**
     * dp[i] = min{dp[i] - dp[i - coin] + 1}
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        for (int i = 1; i <= amount; i++){
            dp[i] = i + 1;
            for (int coin : coins){
                if (i >= coin && dp[i - coin] >= 0){
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
            if (dp[i] == i + 1){
                dp[i] = -1;
            }
        }
        return dp[amount];
    }
}
