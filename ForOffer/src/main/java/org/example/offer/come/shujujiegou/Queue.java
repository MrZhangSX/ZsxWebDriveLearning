package org.example.offer.come.shujujiegou;

//队列
public class Queue<E> {
    private Object[] data;
    private int maxSize;
    private int front;
    private int rear;
    public Queue() {
        this(10);
    }

    public Queue(int initialSize) {
        if (initialSize >= 0) {
            this.maxSize = initialSize;
            data = new Object[initialSize];
            front = rear = 0;
        } else {
            throw new RuntimeException("初始化大小不能小于0： " + initialSize);
        }
    }

    public boolean add(E e) {
        if (rear == maxSize) {
            throw new RuntimeException("队列已满");
        } else {
            data[rear++] = e;
            return true;
        }
    }

    public E pop() {
        if (rear == front) {
            throw new RuntimeException("队列为空");
        } else {
            E value = (E) data[front];
            data[front++] = null;
            return value;
        }
    }

    public E peek() {
        if (rear == front) {
            throw new RuntimeException("队列为空");
        } else {
            return  (E) data[front];
        }
    }
}
