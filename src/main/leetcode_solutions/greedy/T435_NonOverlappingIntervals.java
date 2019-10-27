package main.leetcode_solutions.greedy;

import java.util.*;

/**
 * 区间覆盖问题
 */
public class T435_NonOverlappingIntervals {
    /**
     * 求去除的最少区间，其实就是求组成不覆盖区间的最大值
     * 贪心解法：按区间右界从小到大排序，去除覆盖区间
     * @param intervals
     * @return
     */
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }
        Arrays.sort(intervals, (x, y) -> (x[1] - y[1]));
        int count = 1;
        int end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= end) {
                end = intervals[i][1];
                count++;
            }
        }
        return intervals.length - count;
    }
}
