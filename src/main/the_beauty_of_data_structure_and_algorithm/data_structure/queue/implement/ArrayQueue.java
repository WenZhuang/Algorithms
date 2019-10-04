package main.the_beauty_of_data_structure_and_algorithm.data_structure.queue.implement;

/**
 * 普通的循环队列，尾指针到数组尾部再入队时，会触发一次数据搬移
 * @author wenzhuang
 * @date 2019-10-04 15:46
 */
public class ArrayQueue {
    private int[] items;
    private int tail = 0;
    private int head = 0;

    private final static int DEFAULT_QUEUE_SIZE = 10;

    public ArrayQueue(){
        items = new int[DEFAULT_QUEUE_SIZE];
    }
    public ArrayQueue(int capacity){
        items = new int[capacity];
    }

    public boolean enqueue(int x){
        if (head == 0 && tail == items.length){
            return false;
        }
        if (tail == items.length){
            move();
        }
        items[tail++] = x;
        return true;
    }

    public int dequeue(){
        if (isEmpty()){
            throw new RuntimeException();
        }
        return items[head++];
    }

    public int size(){
        return tail - head;
    }

    public boolean isEmpty(){
        return size() == 0;
    }

    /**
     * 数据搬移，把数据移到数组头部
     */
    private void move(){
        for (int i = 0; i < tail - head; i++){
            items[i] = items[i + head];
        }
        head = 0;
        tail = tail - head;
    }
}
