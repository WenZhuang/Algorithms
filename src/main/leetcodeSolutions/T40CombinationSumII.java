package main.leetcodeSolutions;

import java.util.*;

/**
 * @author wenzhuang
 * @date 2019-10-03 03:12
 */
public class T40CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> list  = new ArrayList<List<Integer>>();
        List<Integer> item = new ArrayList<>();
        if(candidates == null || candidates.length == 0 || target < 0){
            return list;
        }
        Arrays.sort(candidates);
        backtracking(list, item, candidates, target, 0, 0);
        return list;
    }

    private void backtracking(List<List<Integer>> list, List<Integer> item, int[] candidates, int target, int start, int sum){
        if(sum == target){
            list.add(new ArrayList<>(item));
            return;
        }
        if(sum > target){
            return;
        }
        for(int i = start; i < candidates.length; i++){
            if(i > start && candidates[i] == candidates[i-1]){
                continue;
            }
            sum += candidates[i];
            item.add(candidates[i]);
            backtracking(list, item, candidates, target, i+1, sum);
            sum -= candidates[i];
            item.remove(item.size()-1);
        }
    }
}
