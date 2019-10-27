package main.leetcode_solutions.array;

import java.util.*;

/**
 * @author wenzhuang
 * @date 2019-10-27 17:38
 */
public class T219_ContainsDuplicateII {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums == null || nums.length <= 1 || k <= 0){
            return false;
        }
        Set<Integer> set = new HashSet<>(k);
        for (int i = 0; i < nums.length; i++){
            if (set.contains(nums[i])){
                return true;
            }
            if (i - k >= 0){
                set.remove(nums[i - k]);
            }
            set.add(nums[i]);
        }
        return false;
    }
}
