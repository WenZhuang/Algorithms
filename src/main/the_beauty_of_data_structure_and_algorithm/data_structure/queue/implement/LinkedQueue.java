package main.the_beauty_of_data_structure_and_algorithm.data_structure.queue.implement;

import main.common.ListNode;

/**
 * 链式队列
 * @author wenzhuang
 * @date 2019-10-04 15:47
 */
public class LinkedQueue {
    private int count = 0;
    private ListNode head;
    private ListNode tail;

    public boolean enqueue(int x){
        if (tail == null){
            head = new ListNode(x);
            tail = head;
        }
        tail.next = new ListNode(x);
        tail = tail.next;
        count++;
        return true;
    }

    public int dequeue(int x){
        if (head == null){
            throw new RuntimeException();
        }
        int val = head.val;
        if (head == tail){
            head = null;
            tail = null;
        } else {
            head = head.next;
        }
        count--;
        return val;
    }

    public int size(){
        return count;
    }

    public boolean isEmpty(){
        return size() == 0;
    }

}
