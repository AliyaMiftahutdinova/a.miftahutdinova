package ru.kpfu.itis.group408.marushkai.queue;


public interface Queue<T> {
    void offer(T t);
    T peek();
    T poll();
    boolean isEmpty();
    int size();
    int maxSize();
}
