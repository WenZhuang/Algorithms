package main.leetcode_solutions;

import java.util.*;

/**
 * @author wenzhuang
 * @date 2019-10-03 15:38
 */
public class T23_MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0){
            return null;
        }
        Queue<ListNode> queue = new PriorityQueue<>((x, y) -> (x.val - y.val));
        ListNode dummy = new ListNode(0);
        for (ListNode head : lists){
            if (head == null){
                continue;
            }
            queue.offer(head);
        }

        ListNode node = dummy;
        while (!queue.isEmpty()){
            ListNode nNode = queue.poll();
            node.next = nNode;
            if (nNode.next != null){
                queue.offer(nNode.next);
            }
            node = node.next;
        }
        return dummy.next;
    }

}
