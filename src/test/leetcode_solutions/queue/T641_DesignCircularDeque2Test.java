package test.leetcode_solutions.queue;

import main.leetcode_solutions.queue.T641_DesignCircularDeque2;

/**
 * @author wenzhuang
 * @date 2019-10-04 20:17
 */
public class T641_DesignCircularDeque2Test {
    public static void main(String[] args){
        T641_DesignCircularDeque2 queue = new T641_DesignCircularDeque2(77);
        queue.insertFront(77);
        queue.deleteLast();
        queue.insertFront(19);
        queue.insertFront(23);
        queue.insertFront(23);
        queue.insertFront(82);
        queue.insertFront(45);
        queue.deleteLast();
        System.out.print(queue);
    }
}
