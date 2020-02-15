package test.common;


import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class CommonTest {

    public static void main(String[] args){
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(1, 1);
        map.put(2, 2);
        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>((x, y) -> (x.getValue() - y.getValue()));
        for (Map.Entry<Integer, Integer> entry : map.entrySet()){
            queue.offer(entry);
        }
        System.out.println(queue.peek().getKey());
        map.put(1, 3);
        System.out.println(queue.peek().getKey());
    }
}
