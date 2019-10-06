package main.the_beauty_of_data_structure_and_algorithm.data_structure.hash_table;

import java.util.*;
import java.util.HashMap;

/**
 * LRU缓存淘汰算法
 * @author wenzhuang
 * @date 2019-10-06 17:58
 */
public class LRUCache {
    private Map<Integer, Node> cache = new HashMap<>();
    private Node head;
    private Node tail;

    private int capacity;

    public LRUCache(int capacity){
        this.capacity = capacity;
    }

    public int get(int key){
        Node node = cache.get(key);
        if (node == null){
            return -1;
        }
        moveToTail(node);
        return node.value;
    }

    public boolean put(int key, int value){
        Node node = cache.get(key);
        if (node == null){
            if (cache.size() == capacity){
                removeHead();
            }
            Node nNode = new Node(key, value);
            addToTail(nNode);
        } else {
            node.value = value;
            moveToTail(node);
        }
        return true;
    }

    private void removeHead(){
        if (head == null){
            return;
        }
        if (head == tail){
            head = null;
            tail = null;
            return;
        }
        head = head.next;
        head.pre = null;
    }

    private void moveToTail(Node node){
        if (node == null || node == tail){
            return;
        }
        if (node == head){
            head = head.next;
            head.pre = null;
        } else {
            node.pre.next = node.next;
            node.next.pre = node.pre;
        }
        tail.next = node;
        node.pre = tail;
        node.next = null;
    }

    private void addToTail(Node node){
        if (node == null){
            return;
        }
        if (head == null){
            head = node;
            tail = node;
            return;
        }
        tail.next = node;
        node.pre = tail;
    }

    class Node {
        int key;
        int value;
        Node pre;
        Node next;
        public Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }
}
