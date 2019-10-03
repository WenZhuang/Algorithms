package main.lintcode_solutions;

import java.util.*;

/**
 * @author wenzhuang
 * @date 2019-10-03 12:42
 */
/**
 * DFS
 */
public class T15_Permutations {
    /**
     * @param nums: A list of integers.
     * @return: A list of permutations.
     */
    public List<List<Integer>> permute(int[] nums) {
        // write your code here
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> item = new ArrayList<>();

        helper(list, item, nums);
        return list;
    }

    private void helper(List<List<Integer>> list, List<Integer> item, int[] nums){
        if(item.size() == nums.length){
            list.add(new ArrayList<Integer>(item));
            return;
        }else{
            for(int i = 0; i < nums.length; i++){
                if(item.contains(nums[i])){
                    continue;
                }else{
                    item.add(nums[i]);
                    helper(list, item, nums);
                    item.remove(item.size()-1);
                }
            }
        }
    }
}
