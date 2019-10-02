package main.leetcodeSolutions.leetcode_solutions;


import java.util.*;
/**
 * @author wenzhuang
 * @date 2019-10-03 03:18
 */
/**
 *  https://leetcode.com/problems/triangle
 *  Dynamic Programming
 *  dp[i][j] = triangle[i][j] + min{triangle[i+1][j], triangle[i+1][j+1]}
 */
public class T120_Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int m = triangle.get(n - 1).size();
        int[][] dp = new int[n][m];
        for(int j = 0; j < m; j++){
            dp[n - 1][j] = triangle.get(n - 1).get(j);
        }
        for(int i = n - 2; i >= 0; i--){
            for(int j = 0; j < triangle.get(i).size(); j++){
                dp[i][j] = triangle.get(i).get(j) + Math.min(dp[i + 1][j], dp[i + 1][j + 1]);
            }
        }

        return dp[0][0];
    }
}
