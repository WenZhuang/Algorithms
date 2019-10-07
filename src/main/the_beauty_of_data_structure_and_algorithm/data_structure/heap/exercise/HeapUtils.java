package main.the_beauty_of_data_structure_and_algorithm.data_structure.heap.exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author wenzhuang
 * @date 2019-10-07 22:10
 */
public class HeapUtils {
    public int[] mergeKSortedArray(int[][] arrays){
        if (arrays == null || arrays.length == 0){
            return new int[0];
        }
        int k = 0, size = 0;
        for (int[] arr : arrays){
            if (arr == null || arr.length == 0){
                continue;
            }
            k++;
            size += arr.length;
        }
        int[] res = new int[size];
        Queue<NewInteger> queue = new PriorityQueue<>((x, y) -> (x.val - y.val));
        for (int i = 0; i < arrays.length; i++){
            if (arrays[i] == null || arrays.length == 0){
                continue;
            }
            queue.offer(new NewInteger(i, 0, arrays[i][0]));
        }
        int index = 0;
        while (!queue.isEmpty()){
            NewInteger cur = queue.poll();
            res[index++] = cur.val;
            if (cur.col + 1 < arrays[cur.row].length){
                queue.offer(new NewInteger(cur.row, cur.col + 1, arrays[cur.row][cur.col + 1]));
            }
        }
        return res;
    }

    public List<Integer> topK(List<Integer> list, int k){
        if (list.size() <= k){
            return list;
        }
        Queue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < list.size(); i++){
            if (i < k) {
                queue.offer(list.get(i));
            }else {
                if (list.get(i) > queue.peek()){
                    queue.poll();
                    queue.offer(list.get(i));
                }
            }
        }
        List<Integer> res = new ArrayList<>(k);
        res.addAll(queue);
        return res;
    }
}

class NewInteger{
    int row;
    int col;
    int val;
    public NewInteger(int row, int col, int val){
        this.row = row;
        this.col = col;
        this.val = val;
    }
}