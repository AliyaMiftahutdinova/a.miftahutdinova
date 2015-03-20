package ru.kpfu.itis.group11408.Miftahutdinova.stack;

public class Stack<T> implements SuperStak<T> {
    private final int STACK_SIZE = 20;
    private Object[] stack = new Object[STACK_SIZE];
    private int size = 0;

    public T pop() {
        if (!isEmpty()){
            size--;
            T last = (T) stack[this.size];
            stack[this.size] = null;
            return last;
        }
        return null;
    }

    public T peek() {
        if (!isEmpty()){
            return (T) stack[this.size-1];
        } 
        return null;
    }

    public void push(T t){
        stack[size] = t;
        size++;
    }

    public int size(){
        return this.size;
    }

    public boolean isEmpty(){
        return stack[0] == null;
    }
}