package main.the_beauty_of_data_structure_and_algorithm.data_structure.stack.implement;

/**
 * @author wenzhuang
 * @date 2019-10-03 16:28
 */
public class ArrayStack {
    private int[] stack;
    private int count;

    private final static int DEFAULT_CAPACITY = 10;

    public ArrayStack(){
        stack = new int[DEFAULT_CAPACITY];
    }

    public ArrayStack(int capacity){
        stack = new int[capacity];
    }

    public int size(){
        return count;
    }

    public boolean isEmpty(){
        return count == 0;
    }

    public int push(int a){
        if (count == stack.length){
            resize();
        }
        stack[count++] = a;
        return a;
    }

    public int pop(){
        if (count <= 0){
            throw new RuntimeException();
        }
        return stack[--count];
    }

    public int top(){
        if (count <= 0){
            throw new RuntimeException();
        }
        return stack[count - 1];
    }

    private void resize(){
        int capacity = stack.length;
        int[] nStack = new int[2 * capacity];
        for (int i = 0; i < capacity; i++){
            nStack[i] = stack[i];
        }
        stack = nStack;
    }
}
