package ru.kpfu.itis.group408.marushkai.queue;


public class ArrayQueue<T> implements Queue<T> {
    private final int SIZE = 20;
    private Object[] queue = new Object[SIZE];
    private int startIndex  = 0, endIndex = 0, queueLength = 0;

    public void offer(T t){
        queue[endIndex] = t;
        endIndex++;
        queueLength++;
        if (endIndex == SIZE){
            endIndex = 0;
        }
    }

    public T peek(){
        if (!isEmpty()) {
            return (T) queue[startIndex];
        } 
    }

    public T poll(){
        if (!isEmpty()) {
            T element = (T) queue[startIndex];
            startIndex++;
            queueLength--;
            if (startIndex == SIZE){
                startIndex = 0;
            }
            return element;
        } 
    }

    public boolean isEmpty(){
        return queueLength == 0;
    }

    public int size(){
        return queueLength;
    }

    public int maxSize(){
        return SIZE;
    }
}
