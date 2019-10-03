package main.lintcode_solutions;


/**
 * @author wenzhuang
 * @date 2019-10-03 12:45
 */
public class T452_RemoveLinkedListElements {
    /**
     * @param head a ListNode
     * @param val an integer
     * @return a ListNode
     */
    public ListNode removeElements(ListNode head, int val) {
        // Write your code here
        if(head == null){
            return null;
        }
        while(head != null && head.val == val){
            head = head.next;
        }

        ListNode pre = head;
        while(pre != null && pre.next != null){
            if(pre.next.val == val){
                pre.next = pre.next.next;
            }else{
                pre = pre.next;
            }
        }
        return head;
    }
}
