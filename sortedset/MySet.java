package ru.kpfu.itis.group408.Miftahutdinova.Set;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;


public class MySet<T extends Comparable> implements SortedSet<T> {

    private LinkedList<T> setList = new LinkedList<>();
    private static int i = 0;

    @Override
    public void add(T element) {
        int ins = 0;
        for (int i = 0; i < setList.size(); i++){
            if (setList.get(i).equals(element))
                ins++;
        }
        if (ins == 0) {
            setList.add(element);
            Object[] service = new Object[setList.size()];
            for (int i = 0; i < service.length; i++){
                service[i] = setList.get(i);
            }
            Arrays.sort(service);
            for (int i = 0; i < service.length; i++){
                setList.set(i, (T) service[i]);
            }
        }
    }

    public void clear() {
        setList.clear();
    }

    public boolean contains(Object o) {
        return (setList.contains(o));
    }

    public boolean isEmpty() {
        return setList.isEmpty();
    }

    public void remove(Object o) {
        setList.remove(o);
    }

    public int size() {
        return setList.size();
    }

    public Object[] toArray() {
        return setList.toArray();
    }

    public class MyIterator<T> implements Iterator<T>{
        public boolean hasNext() {
            try {
                if (setList.get(i) == null) {
                    return false;
                } else return true;
            } catch (IndexOutOfBoundsException e){
                return false;
            }
        }

        public T next() {
            T th;
            if (hasNext()){
                th = (T) setList.get(i);
                i++;
                return th;
            } else
                return null;
        }
    }

    public MyIterator<T> iterator() {
        return new MyIterator();
    }
}
