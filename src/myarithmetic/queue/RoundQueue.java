package myarithmetic.queue;

/**
 * @author chengzhzh@datangmobile.com
 * @create 2019-10-16 13:18
 */
public class RoundQueue {
    private long[] a;
    private int size;
    private int nItems;// 实际的存储数量
    private int front;//头
    private int rear;// 尾

    public RoundQueue(int maxSize){
        this.size = maxSize;
        a = new long[size];
        front = 0;
        nItems = 0;
        rear = -1;
    }

    public void insert(long value){
        if (isFull()) {
            System.out.println("队列已满");
            return;
        }

        rear = ++rear%size;
        a[rear] = value;
        nItems++;
    }

    public long remove(long value){
        if (isEmpty()) {
            System.out.println("队列为空");
            return 0;
        }
        nItems --;
        front = front%size;
        return a[front++];
    }

    public boolean isEmpty() {
        return nItems == 0;
    }

    public boolean isFull() {
        return nItems == size;
    }
}
