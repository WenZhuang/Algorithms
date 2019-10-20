package main.leetcode_solutions.dynamic_programming;

/**
 * 最长回文子序列
 * @author wenzhuang
 * @date 2019-10-21 01:42
 */
public class T516_LongestPalindromicSubsequence {
    /**
     * dp[i][j]子串s(i,j)的最长回文子序列，最终解dp[0][n-1];
     * dp[i][j] = dp[i+1][j-1]+2,s[i]==s[j]
     * dp[i][j] = max{dp[i+1][j],dp[i][j-1]},s[i]!=s[j]
     * @param s
     * @return
     */
    public int longestPalindromeSubseq(String s) {
        if (s == null || s.length() == 0){
            return 0;
        }
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int i = n - 1; i >= 0; i--){
            dp[i][i] = 1;
            for (int j = i + 1; j < n; j++){
                if (s.charAt(i) == s.charAt(j)){
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][n - 1];
    }
}
