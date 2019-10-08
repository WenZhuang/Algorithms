package main.leetcode_solutions.search;

public class T69_SqrtX {
    /**
     * 二分法
     * 注意：1）两个整数相乘可能导致int溢出，因此改乘法为除法
     *      2）除法需要注意不能出现除零异常，此处通过提前判断为0的情况来避免
     * @param x
     * @return
     */
    public int mySqrt(int x) {
        if (x <= 1){
            return x;
        }
        int low = 0, high = x;
        while (low <= high){
            int mid = ((high - low) >> 1) + low;
            if (mid <= x / mid && (mid + 1) > x / (mid + 1)){
                return mid;
            } else if (mid > x / mid) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    //TODO 牛顿法 https://leetcode.com/problems/sqrtx/discuss/25198/3-JAVA-solutions-with-explanation

    //TODO 位运算法 https://leetcode.com/problems/sqrtx/discuss/25048/Share-my-O(log-n)-Solution-using-bit-manipulation
}
