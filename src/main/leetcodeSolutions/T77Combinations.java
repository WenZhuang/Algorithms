package main.leetcodeSolutions.leetcode_solutions;


import java.util.*;
/**
 * @author wenzhuang
 * @date 2019-10-03 03:17
 */
/**
 * 求组合数
 * dfs，回溯
 **/
public class T77Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> item = new ArrayList<>();
        dfs(n, k, 1, list, item);
        return list;
    }

    private void dfs(int n, int k, int index, List<List<Integer>> list, List<Integer> item){
        if(k == 0){
            list.add(new ArrayList<Integer>(item));
        }
        for(int i = index; i <= n; i++){
            item.add(i);
            k--;
            dfs(n, k, ++index, list, item);
            item.remove(item.size() - 1);
            k++;
        }
    }
}
