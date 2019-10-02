package main.leetcode_solutions.leetcode_solutions;

import java.util.*;

/**
 * @author wenzhuang
 * @date 2019-10-03 03:14
 */
/**
 * 求全排列
 * 回溯，dfs
 * 每次交换第一个数与后面每个数字
 **/
public class T46Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        dfs(nums, list, 0);
        return list;
    }

    private void dfs(int[] nums, List<List<Integer>> list, int index){
        if(index == nums.length - 1){
            List<Integer> item = new ArrayList<>();
            for(int num : nums){
                item.add(num);
            }
            list.add(item);
            return;
        }

        for(int i = index; i < nums.length; i++){
            exch(nums, index, i);
            dfs(nums, list, index + 1);
            exch(nums, index, i);
        }
    }

    private void exch(int nums[], int a, int b){
        int t = nums[a];
        nums[a] = nums[b];
        nums[b] = t;
    }
}
