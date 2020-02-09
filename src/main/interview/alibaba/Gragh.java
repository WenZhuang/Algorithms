package main.interview.alibaba;

import java.util.*;

/**
 * @author wenzhuang
 * @date 2020/1/6 9:00 PM
 */
public class Gragh {

    boolean hasCycle = false;
    public static void main(String[] args){
        //[1-2],[2-3],[3-4,5,6],[4-],[5-8],[6-7],[7-],[8-2]
        Map<Integer, List<Integer>> map = new HashMap<>();
        map.put(1, Arrays.asList(2));
        map.put(2, Arrays.asList(3));
        map.put(3, Arrays.asList(4,5,6));
        map.put(5, Arrays.asList(8));
        map.put(6, Arrays.asList(7));
        map.put(8, Arrays.asList(2));
        Gragh gragh = new Gragh();
        System.out.println(gragh.hasCycle(map));
    }

    private boolean hasCycle(Map<Integer, List<Integer>> map) {
        //统计有入度的节点
        Set<Integer> inDegree = new HashSet<>();
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            if (entry.getValue() != null) {
                inDegree.addAll(entry.getValue());
            }
        }
        //找到根节点（无入度节点）
        Set<Integer> roots = new HashSet<>();
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            if (!inDegree.contains(entry.getKey())) {
                roots.add(entry.getKey());
            }
        }
        if (roots.isEmpty()) {
            hasCycle = true;
            return true;
        }
        List<List<Integer>> res = new ArrayList<>();
        //开始进行深度优先搜索
        for (Integer root : roots) {
            List<Integer> path = new ArrayList<>();
            Set<Integer> visited = new HashSet<>();
            path.add(root);
            visited.add(root);
            dfs(root, map, path, res, visited);
            if (hasCycle){
                return true;
            }
        }
        print(res);
        return false;
    }

    private void dfs(int root, Map<Integer, List<Integer>> map, List<Integer> path, List<List<Integer>> res, Set<Integer> visited) {
        if (hasCycle){
            return;
        }
        if (map.get(root) == null || map.get(root).isEmpty()) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (Integer child : map.get(root)){
            //已经访问过说明存在环
            if (visited.contains(child)){
                hasCycle = true;
                return;
            }
            path.add(child);
            visited.add(child);
            dfs(child, map, path, res, visited);
            path.remove(path.size() - 1);
            visited.remove(child);
        }
    }

    private void print(List<List<Integer>> res){
        for (List<Integer> path : res) {
            for (Integer i : path){
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
