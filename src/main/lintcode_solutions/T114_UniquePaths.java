package main.lintcode_solutions;

/**
 * @author wenzhuang
 * @date 2019-10-03 12:40
 */
/**
 *  DP
 *  dp[i][j] = dp[i-1][j] + dp[i][j-1]
 **/
public class T114_UniquePaths {
    /**
     * @param n, m: positive integer (1 <= n ,m <= 100)
     * @return an integer
     */
    public int uniquePaths(int m, int n) {
        // write your code here
        int[][] dp = new int[m + 1][n + 1];
        dp[1][1] = 0;
        for(int j = 2; j <= n; j++){
            dp[1][j] = 1;
        }
        for(int i = 1; i <= m; i++){
            dp[i][1] = 1;
        }
        for(int i = 2; i <= m; i++){
            for(int j = 2; j <= n; j++){
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m][n];
    }
}
