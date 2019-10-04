package main.the_beauty_of_data_structure_and_algorithm.data_structure.queue.implement;

/**
 * 循环队列
 * 关键点：1)队空head==tail 2)队满head=(tail+1)%capacity
 * @author wenzhuang
 * @date 2019-10-04 15:47
 */
public class CyclicQueue {
    private int[] items;
    private int head = 0;
    private int tail = 0;

    private final static int DEFAULT_QUEUE_SIZE = 10;

    public CyclicQueue(){
        items = new int[DEFAULT_QUEUE_SIZE];
    }

    public CyclicQueue(int capacity){
        items = new int[capacity];
    }

    public boolean enqueue(int x){
        if ((tail + 1) % items.length == head){
            return false;
        }
        items[tail] = x;
        tail = (tail + 1) % items.length;
        return true;
    }

    public int dequeue(){
        if (head == tail){
            throw new RuntimeException();
        }
        int val = items[head];
        head = (head + 1) % items.length;
        return val;
    }

    public int size(){
        return tail < head ? tail + items.length - head : tail - head;
    }

    public boolean isEmpty(){
        return size() == 0;
    }
}
