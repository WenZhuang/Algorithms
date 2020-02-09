package main.interview.alibaba;

/*
题目二：有一个嵌入式设备需要记录设备的数据变更记录，每当有用户操作造成数据变更时，
        就记录一条变更信息。因为是嵌入式设备，设备上的日志缓冲区大小是受限制的，最多只能存储1000条记录，
        当记录的日志超过1000条时，新增的日志需要覆盖旧的记录，也就是说这个日志记录只保留最近写入的1000条记录。
        请设计一个满足该需求的日志记录器。
*/

/**
 * @author wenzhuang
 * @date 2020/1/21 8:11 PM
 */
public class LogRecord {

    private final int N = 1000;
    private int[] queue = new int[N + 1];
    private int front = 0;
    private int rear = 0;
    private int size = 0;

    public LogRecord(){
        this.front = 0;
        this.rear = 0;
        this.size = 0;
    }

     public boolean write(int log) {
        if (isFull()){
            front = (front + 1) % N;
            size--;
        }
        queue[rear] = log;
        rear = (rear + 1) % N;
        size++;
        return true;
    }


    public boolean isFull() {
        return front == rear && size == N;
    }

}
