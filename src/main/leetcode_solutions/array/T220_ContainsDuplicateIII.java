package main.leetcode_solutions.array;

import java.util.TreeSet;

/**
 * @author wenzhuang
 * @date 2019-10-27 18:30
 */
public class T220_ContainsDuplicateIII {
    /**
     * 解法一：使用红黑树
     * @param nums
     * @param k
     * @param t
     * @return
     */
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums == null || nums.length == 0 || k <= 0){
            return false;
        }
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i <  nums.length; i++) {
            Integer ceiling = set.ceiling(nums[i]);
            if (ceiling != null && ceiling.longValue() - nums[i] <= t){
                return true;
            }
            Integer floor = set.floor(nums[i]);
            if (floor != null && nums[i] - floor.longValue() <= t){
                return true;
            }
            if (i - k >= 0){
                set.remove(nums[i - k]);
            }
            set.add(nums[i]);
        }
        return false;
    }

    //TODO 桶排序
}
