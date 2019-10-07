package main.the_beauty_of_data_structure_and_algorithm.data_structure.heap.implement;

import java.util.Comparator;

/**
 * 优先级队列
 * @author wenzhuang
 * @date 2019-10-07 15:24
 */
public class PriorityQueue {
    private int[] items;
    private int capacity;
    private int size;
    //默认从小到大排序，即小顶堆
    private Comparator<Integer> comparator = (x, y) -> (x - y);

    private final static int DEFAULT_CAPACITY = 10;

    public PriorityQueue(){
        this.items = new int[DEFAULT_CAPACITY];
        this.capacity = DEFAULT_CAPACITY;
    }

    public PriorityQueue(int capacity){
        this.capacity = capacity;
        this.items = new int[capacity];
    }

    public PriorityQueue(int capacity, Comparator<Integer> comparator){
        this.capacity = capacity;
        this.items = new int[capacity];
        this.comparator = comparator;
    }

    public PriorityQueue(Comparator<Integer> comparator){
        this.items = new int[DEFAULT_CAPACITY];
        this.capacity = DEFAULT_CAPACITY;
        this.comparator = comparator;
    }

    public boolean offer(int x){
        if (size == capacity){
            rezise();
        }
        if (size == 0){
            items[0] = x;
        } else {
            swim(size - 1);
        }
        size++;
        return true;
    }

    public int poll(){
        if (size == 0){
            throw new RuntimeException();
        }
        int val = items[0];
        exch(0, --size);
        sink(0);
        return val;
    }

    private void rezise(){
        int[] nItems = new int[2 * capacity];
        for (int i = 0; i < items.length; i++){
            nItems[i] = items[i];
        }
        items = nItems;
    }

    private void swim(int i){
        while (i > 0){
            if (comparator.compare(items[i], items[(i - 1) / 2]) < 0){
                exch(i, (i - 1) / 2);
                i = (i - 1) / 2;
            }
        }
    }

    private void sink(int i){
        while (2 * i + 1 < size) {
            int j = 2 * i + 1;
            if (j + 1 < size && comparator.compare(items[j + 1], items[j]) < 0) {
                j++;
            }
            if (comparator.compare(items[i], items[j]) < 0) {
                break;
            }
            exch(i, j);
            i = j;
        }
    }

    private void exch(int i, int j){
        int tmp = items[i];
        items[i] = items[j];
        items[j] = tmp;
    }
}
