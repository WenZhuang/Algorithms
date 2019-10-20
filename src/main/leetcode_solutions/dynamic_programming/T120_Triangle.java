package main.leetcode_solutions.dynamic_programming;

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
    /**
     * 此处有个哨兵技巧，假设最后一行的下面还有一行全0的数组，这样能解决边界问题的判定
     * @param triangle
     * @return
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        int[] dp = new int[triangle.size() + 1];
        for (int i = triangle.size() - 1; i >= 0; i--){
            for (int j = 0; j < triangle.get(i).size(); j++){
                dp[j] = Math.min(dp[j + 1], dp[j]) + triangle.get(i).get(j);
            }
        }
        return dp[0];
    }
}
