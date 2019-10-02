package main.leetcodeSolutions.leetcode_solutions;

/**
 * @author wenzhuang
 * @date 2019-10-03 03:16
 */
/**
 * 快速幂，二分法
 * 注意处理n为负数的情况, int的范围-2147483648~2147483647
 **/
public class T50Pow {
    public double myPow(double x, int n) {
        long m = (long)n;
        if(m == 0){
            return 1;
        }else if(m > 0){
            return getPow(x, m);
        }else{
            m = -m;
            return 1 / getPow(x, m);
        }
    }

    private double getPow(double x, long n){
        if(n == 1){
            return x;
        }
        double pow = getPow(x, n / 2);
        return (n & 1) == 1 ? x * pow * pow : pow * pow;
    }
}
