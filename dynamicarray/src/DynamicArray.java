package ru.kpfu.itis.group11408.Miftahutdinova.dynamicarray;

public class DynamicArray {

    private Object m[] = new Object[10];
    private int count = 0;

    public DynamicArray(){
        for (int i = 0; i < m.length; i++) {
            m[i] = null;
        }
    }

    void addElement(Object obj){ //добавляет элемент в список
        try {
            if (m[count] == null) {
                m[count] = obj;
                count++;
            } else {
                count++;
                addElement(obj);
            }
        } catch (Exception e) {
            int newLength = m.length + 5;
            m = new Integer[newLength];
            addElement(obj);
        }
    }

    void insertElement(Object obj, int index){ //добавляет элемент в список с нужным индексом
        try {
            m[index] = obj;
        } catch (Exception e) {
            int newLength = m.length + 5;
            m = new Object[newLength];
            insertElement(obj, index);
        }
    }

    public void removeElement(Object obj){
        for (int i = 0; i < m.length; i++) {  //удаляет элемент из списка
            if(m[i].equals(obj)){
                m[i] = null;
            }
        }
    }

    public Object getElement(int index){ //возвращает элемент с данным индексом
        try {
            return m[index];
        }catch (Exception e){
            return null;
        }
    }

    public int getSize(){ //возвращает размер списка
        int size = 0;
        for (int i = 0; i < m.length; i++) {
            if(m[i] != null){
                size++;
            }
        }
        return size;
    }

}
