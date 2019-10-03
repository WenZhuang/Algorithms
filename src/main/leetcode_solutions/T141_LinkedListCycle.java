package main.leetcode_solutions;

/**
 * @author wenzhuang
 * @date 2019-10-03 15:19
 */
public class T141_LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null){
            return false;
        }
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow){
                break;
            }
        }
        return fast == slow;
    }
}
