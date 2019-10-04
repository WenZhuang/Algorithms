package main.leetcode_solutions.queue;

import java.util.*;

/**
 * 经典的滑动窗口最大值
 * 两种解法：1）使用双端单调队列 2）双向扫描数组
 * @author wenzhuang
 * @date 2019-10-04 18:28
 */
public class T239_SlidingWindowMaximum {
    /**
     * 双端单调队列解法：从队首到队尾单调递减
     * 关键点：队列中实际存储的是数组下标，根据下标判断何时队首该出队
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k == 0){
            return new int[0];
        }
        Deque<Integer> deque = new LinkedList<Integer>();
        int[] res = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++){
            if (!deque.isEmpty() && deque.getFirst() + k == i){
                deque.removeFirst();
            }
            while (!deque.isEmpty() && nums[deque.getLast()] < nums[i]){
                deque.removeLast();
            }
            deque.addLast(i);
            if (i >= k - 1){
                res[i + 1 - k] = nums[deque.getFirst()];
            }
        }
        return res;
    }

    /**
     * 双向扫描解法
     * @param nums
     * @param k
     * @return
     */
    //TODO
    public int[] maxSlidingWindow2(int[] nums, int k) {
        return new int[0];
    }
}
