package main.leetcode_solutions.dynamic_programming;

/**
 * 通配符匹配
 * 方法1：回溯，TLE超时
 * 方法2：动态规划
 * @author wenzhuang
 * @date 2019-10-20 17:17
 */
public class T44_WildcardMatching {
    boolean match = false;
    public boolean isMatch(String s, String p) {
        match = false;
        char[] ss = s.toCharArray();
        char[] ps = p.toCharArray();
        backtracking(0, 0, ss, ps);
        return match;
    }

    private void backtracking(int i, int j, char[] ss, char[] ps){
        if (match){
            return;
        }
        if (j == ps.length){
            if (i == ss.length){
                match = true;
            }
            return;
        }
        if (ps[j] == '*'){
            for (int k = 0; k <= ss.length - i; k++){
                backtracking(i + k, j + 1, ss, ps);
            }
        }
        if (ps[j] == '?' || (i < ss.length && ss[i] == ps[j])){
            backtracking(i + 1, j + 1, ss, ps);
        }
    }

    //TODO 动态规划解法


}
