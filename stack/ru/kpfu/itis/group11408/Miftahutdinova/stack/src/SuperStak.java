package ru.kpfu.itis.group11408.Miftahutdinova.stack;

public interface SuperStak<T> {
    T pop();

    T peek();

    void push (T t);

    int size();

    boolean isEmpty();

}