package test.the_beauty_of_data_structure_and_algorithm.data_structure.linkedlist.implement;

/**
 * @author wenzhuang
 * @date 2019-10-02 21:27
 */
public class LinkedListUtils {

    /**
     * 翻转链表
     * @param head
     * @return
     */
    public static ListNode reverse(ListNode head){
        ListNode pre = null;
        while (head != null){
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    /**
     * 合并有序链表：非递归实现
     * @param head1
     * @param head2
     * @return
     */
    public static ListNode mergeTwoSortedLinkedList(ListNode head1, ListNode head2){
        if (head1 == null){
            return head2;
        }
        if (head2 == null){
            return head1;
        }
        ListNode dummy = new ListNode(0);
        ListNode node = dummy;
        while (head1 != null && head2 != null){
            int val1 = head1.val;
            int val2 = head2.val;
            if (val1 <= val2){
                node.next = head1;
                head1 = head1.next;
            } else {
                node.next = head2;
                head2 = head2.next;
            }
            node = node.next;
        }
        if (head1 != null){
            node.next = head1;
        }
        if (head2 != null){
            node.next = head2;
        }
        return dummy.next;
    }

    /**
     * 合并有序链表：递归实现
     * @param head1
     * @param head2
     * @return
     */
    public static ListNode mergeTwoSortedLinkedListRecursion(ListNode head1, ListNode head2){
        if (head1 == null){
            return head2;
        }
        if (head2 == null){
            return head1;
        }
        int val1 = head1.val, val2 = head2.val;
        if (val1 <= val2){
            head1.next = mergeTwoSortedLinkedListRecursion(head1.next, head2);
            return head1;
        } else {
            head2.next = mergeTwoSortedLinkedListRecursion(head1, head2.next);
            return head2;
        }
    }

    /**
     * 取链表中间节点
     * @param head
     * @return
     */
    public static ListNode getMidNode(ListNode head){
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }


}
