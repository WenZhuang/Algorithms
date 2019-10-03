package main.lintcode_solutions;

/**
 * @author wenzhuang
 * @date 2019-10-03 12:43
 */
public class T366_Fibonacci {
    /**
     * @param n: an integer
     * @return an integer f(n)
     */
    public int fibonacci(int n) {
        // write your code here
        if(n == 1)  return 0;
        if(n == 2)  return 1;
        int f1 = 0, f2 = 1;
        int f = 0;
        for(int i = 3; i <= n; i++){
            f = f1 + f2;
            f1 = f2;
            f2 = f;
        }
        return f;
    }
}
