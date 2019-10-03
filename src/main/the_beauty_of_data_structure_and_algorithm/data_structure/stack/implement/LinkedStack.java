package main.the_beauty_of_data_structure_and_algorithm.data_structure.stack.implement;

import main.common.ListNode;

/**
 * @author wenzhuang
 * @date 2019-10-03 16:28
 */
public class LinkedStack {
    private ListNode peek;
    private int count;

    public int push(int a){
        ListNode nNode = new ListNode(a);
        nNode.next = peek;
        peek = nNode;
        count++;
        return a;
    }

    public int pop(){
        if (count <= 0 || peek == null){
            throw new RuntimeException();
        }
        int val = peek.val;
        peek = peek.next;
        count--;
        return val;
    }

    public int top(){
        if (count <= 0 || peek == null){
            throw new RuntimeException();
        }
        return peek.val;
    }

    public int size(){
        return count;
    }

    public boolean isEmpty(){
        return size() == 0;
    }
}
