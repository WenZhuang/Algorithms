package main.the_beauty_of_data_structure_and_algorithm.algorithm.dynamic_programming.example;

/**
 * 最长公共子序列
 * @author wenzhuang
 * @date 2019-10-20 13:47
 */
public class LongestCommonSubsequence {

    public int longestCommonSubsequence(char[] a, char[] b){
        int m = a.length, n = b.length;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++){
            for (int j = 1; j <= n; j++){
                if (a[i - 1] == b[j - 1]){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }
}
