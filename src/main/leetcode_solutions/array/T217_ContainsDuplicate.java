package main.leetcode_solutions.array;

import java.util.*;

/**
 * @author wenzhuang
 * @date 2019-10-27 17:20
 */
public class T217_ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length <= 1){
            return false;
        }
        Set<Integer> set = new HashSet<>();
        for (int num : nums){
            if (set.contains(num)){
                return true;
            }
            set.add(num);
        }
        return false;
    }
}
