package main.leetcode_solutions.recursion;

public class T70_ClimbingStairs {
    public int climbStairs(int n) {
        if (n <= 2){
            return n;
        }
        int f = 0, f1 = 2, f2 = 1;
        for (int i = 3; i <= n; i++){
            f = f1 + f2;
            f2 = f1;
            f1 = f;
        }
        return f;
    }
}
