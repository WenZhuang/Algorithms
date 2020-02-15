package main.interview.tencent.weixin;

import java.util.*;

/**
 * 题目：
 * 500万个门店，求出访问次数最多的前100个门店
 * @author wenzhuang
 * @date 2020/2/15 10:50 PM
 */
public class PoiHitCountTop100 {

    private Map<Integer, Integer> poiHitCount = new HashMap<>();

    //读时更新top100
    public List<Integer> getTop100PoiIds(){
        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>((x, y) -> (x.getValue() - y.getValue()));
        for (Map.Entry<Integer, Integer> entry : poiHitCount.entrySet()) {
            if (queue.size() < 100) {
                queue.offer(entry);
            } else {
                if (entry.getValue() > queue.peek().getValue()){
                    queue.poll();
                    queue.offer(entry);
                }
            }
        }
        List<Integer> top100PoiIds = new ArrayList<>();
        while (!queue.isEmpty()){
            top100PoiIds.add(queue.poll().getKey());
        }
        Collections.reverse(top100PoiIds);
        return top100PoiIds;
    }

    public void hit(Integer poiId){
        poiHitCount.put(poiId, poiHitCount.getOrDefault(poiId, 0) + 1);
    }
}
