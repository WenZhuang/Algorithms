package main.leetcode_solutions;

import java.util.*;

/**
 * @author wenzhuang
 * @date 2019-10-03 17:48
 */

/**
 * 思路：先排序数组，枚举第一个元素，对剩下的数组进行双向扫描
 * 关键点：去除重复解
 *      1)枚举的第一个元素与前面的节点相同的跳过
 *      2)第二个元素与前面的元素（不包括第一个元素）相同的，跳过
 *      3)第三个元素与后面的元素相同的，跳过
 * 时间复杂度T(n)= O(n^2) 空间复杂度O(1)
 */
public class T15_3Sum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++){
            // 1)第一个元素有重复的跳过
            if (i > 0 && nums[i] == nums[i - 1]){
                continue;
            }
            int target =  -nums[i];
            int low = i + 1, high = nums.length - 1;
            while (low < high){
                if (nums[low] + nums[high] == target){
                    //2)第二个元素与前面的元素（不包括第一个元素）相同的，跳过
                    if (low > i + 1 && nums[low] == nums[low - 1]){
                        low++;
                        continue;
                    }
                    //3)第三个元素与后面的元素相同的，跳过
                    if (high < nums.length - 1 && nums[high] == nums[high + 1]){
                        high--;
                        continue;
                    }
                    res.add(Arrays.asList(nums[i], nums[low], nums[high]));
                    low++;
                    high--;
                } else if (nums[low] + nums[high] < target) {
                    low++;
                } else {
                    high--;
                }
            }
        }
        return res;
    }

}
