package main.leetcode_solutions.contest.week163;

public class T1262_GreatestSumDivisibleByThree {
    /**
     * 需要观察一下输入数据的特征：1<=nums[i]<=10000
     * 设sum = sum{nums[i]}
     * if sum % 3 == 0, return sum
     * if sum % 3 == 1, return sum - min{最小的模3为1的数，最小的两个模3为2的数之和}
     * if sum % 3 == 2, return sum - min{最小的模3为2的数，最小的两个模3为1的数之和}
     * 因此，需要求出数组中模3为1的最小两个数，模3为2的最小两个数
     *
     * 正确性需要通过数学证明：
     * 反证法，假如存在三个数的和取模为1，则三个数中至少有一个数取模为1或两个数取模为2，三数之和不会比上述两种情况更小
     * @param nums
     * @return
     */
    public int maxSumDivThree(int[] nums) {
        int leftOne1 = 10000, leftOne2 = 10000, leftTwo1 = 10000, leftTwo2 = 10000, sum = 0;
        for (int num : nums){
            sum += num;
            if (num % 3 == 1){
                if (num <= leftOne1){
                    leftOne2 = leftOne1;
                    leftOne1 = num;
                } else if (num < leftOne2) {
                    leftOne2 = num;
                }
            } else if (num % 3 == 2){
                if (num <= leftTwo1){
                    leftTwo2 = leftTwo1;
                    leftTwo1 = num;
                } else if (num < leftTwo2) {
                    leftTwo2 = num;
                }
            }
        }
        int res = 0;
        if (sum % 3 == 0) {
            res = sum;
        }
        if (sum % 3 == 1) {
            res =  sum - Math.min(leftOne1, leftTwo1 + leftTwo2);
        }
        if (sum % 3 == 2) {
            res = sum - Math.min(leftTwo1, leftOne1 + leftOne2);
        }
        return res;
    }

    //TODO 反证法
}
