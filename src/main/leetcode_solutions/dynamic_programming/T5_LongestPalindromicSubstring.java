package main.leetcode_solutions.dynamic_programming;

/**
 * 最长回文子串
 * @author wenzhuang
 * @date 2019-10-21 01:16
 */
public class T5_LongestPalindromicSubstring {
    /**
     * 动态规划解法，dp[i][j]从i到j的子串是否回文子串
     * dp[i][j] = dp[i + 1][j - 1] && s[i]==s[j]
     * T(n)=O(n^2)
     * S(n)=O(n^2)
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        String res = "";
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        for (int i = n - 1; i >= 0; i--){
            for (int j = i; j < n; j++){
                dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 2 || dp[i + 1][j - 1]);
                if (dp[i][j] && j - i + 1 > res.length()){
                    res = s.substring(i, j + 1);
                }
            }
        }
        return res;
    }

    //TODO 中心扩展法

    //TODO manacher算法，不要求掌握
}
