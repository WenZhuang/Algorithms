package test.the_beauty_of_data_structure_and_algorithm.data_structure.linkedlist.implement;

/**
 * @author wenzhuang
 * @date 2019-10-02 21:13
 */
public class SinglyLinkedList {
    private ListNode head;
    private ListNode tail;

    public SinglyLinkedList(){

    }

    public ListNode add(ListNode listNode){
        if (head == null){
            head = listNode;
            tail = listNode;
        }
        tail.next = listNode;
        return head;
    }

    public ListNode addAfter(ListNode listNode, ListNode nListNode){
        ListNode target = head;
        while (target != listNode){
            target = target.next;
        }
        nListNode.next = target.next;
        target.next = nListNode;
        return head;
    }

    public ListNode remove(ListNode listNode){
        if (listNode == head){
            head = head.next;
            return head;
        }
        ListNode target = head.next, pre = head;
        while (target != listNode){
            target = target.next;
            pre = pre.next;
        }
        pre.next = pre.next.next;
        return head;
    }
}
