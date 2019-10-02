package main.leetcode_solutions.leetcode_solutions;


import java.util.*;
/**
 * @author wenzhuang
 * @date 2019-10-03 03:20
 */
/**
 * DFS、Backtracking
 */
public class T216_CombinationSumIII {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> item = new ArrayList<>();
        backtracking(list, item, k, n, 1, 0);
        return list;
    }

    private void backtracking(List<List<Integer>> list, List<Integer> item, int k, int n,int start, int sum){
        if(k == 0){
            if(sum == n){
                list.add(new ArrayList<>(item));
                return;
            }else{
                return;
            }
        }

        for(int i = start; i <= 9; i++){
            sum += i;
            item.add(i);
            k--;
            backtracking(list, item, k, n, i + 1, sum);
            sum -= i;
            item.remove(item.size() - 1);
            k++;
        }
    }
}
