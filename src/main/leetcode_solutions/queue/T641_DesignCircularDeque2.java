package main.leetcode_solutions.queue;

/**
 * @author wenzhuang
 * @date 2019-10-04 20:14
 */
/**
 * 双向循环链表实现
 */
public class T641_DesignCircularDeque2 {
    private DoubleListNode head;
    private DoubleListNode tail;
    private int count;
    private int capacity;

    /** Initialize your data structure here. Set the size of the deque to be k. */
    public T641_DesignCircularDeque2(int k) {
        this.capacity = k;
    }

    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if (isFull()){
            return false;
        }
        DoubleListNode nNode = new DoubleListNode(value);
        if (isEmpty()){
            head = nNode;
            tail = nNode;
        } else{
            head.pre = nNode;
            nNode.next = tail;
            tail.next = nNode;
            nNode.pre = tail;
            head = nNode;
        }
        count++;
        return true;
    }

    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if (isFull()){
            return false;
        }
        DoubleListNode nNode = new DoubleListNode(value);
        if (isEmpty()){
            head = nNode;
            tail = nNode;
        } else{
            tail.next = nNode;
            nNode.pre = tail;
            nNode.next = head;
            head.pre = nNode;
            tail = nNode;
        }
        count++;
        return true;
    }

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if (isEmpty()){
            return false;
        }
        if (head == tail){
            head = null;
            tail = null;
        } else {
            head = head.next;
            head.pre = tail;
            tail.next = head;
        }
        count--;
        return true;
    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if (isEmpty()){
            return false;
        }
        if (head == tail){
            head = null;
            tail = null;
        } else {
            tail = tail.pre;
            tail.next = head;
            head.pre = tail;
        }
        count--;
        return true;
    }

    /** Get the front item from the deque. */
    public int getFront() {
        if (isEmpty()){
            return -1;
        }
        return head.val;
    }

    /** Get the last item from the deque. */
    public int getRear() {
        if (isEmpty()){
            return -1;
        }
        return tail.val;
    }

    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return count == 0;
    }

    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return count == capacity;
    }

    class DoubleListNode{
        int val;
        DoubleListNode pre;
        DoubleListNode next;
        public DoubleListNode(int val){
            this.val = val;
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        if (head != null){
            DoubleListNode node = head;
            while (head != tail){
                stringBuilder.append(head.val + ",");
                head = head.next;
            }
            stringBuilder.append(tail.val);
        }
        return stringBuilder.toString();
    }
}
