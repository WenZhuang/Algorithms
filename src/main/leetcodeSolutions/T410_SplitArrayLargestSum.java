package main.leetcodeSolutions.leetcode_solutions;

/**
 * @author wenzhuang
 * @date 2019-10-03 03:23
 */
/**
 * 二分+贪心策略
 * 寻找的变量与索引之间存在单调关系，则可以二分法
 */
public class T410_SplitArrayLargestSum {
    public int splitArray(int[] nums, int m) {
        long min = 0;
        long max = 1;
        long ans = 0;
        for(int i = 0; i < nums.length; i++){
            max += nums[i];
        }
        while(min < max){
            long mid = (max - min) / 2 + min;
            if(guess(nums, mid, m)){
                ans = mid;
                max = mid;
            }else{
                min = mid + 1;
            }
        }
        return (int)ans;
    }

    private boolean guess(int[] nums, long t, int m){
        int count = 0;
        long sum = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > t){
                return false;
            }
            if(sum + nums[i] > t){
                count++;
                sum = nums[i];
            }else{
                sum += nums[i];
            }
        }
        count++;
        return m >= count;
    }
}
