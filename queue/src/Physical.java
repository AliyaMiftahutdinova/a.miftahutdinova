package ru.kpfu.itis.group408.miftahutdinova.queue;

import java.util.ArrayList;

public class Physical {
    Queue<String> queue = new ArrayQueue<String>();
    Decanat decan = new Decanat();
    public void toQueue(){

       for (int i = 0; i < dr.getSize(); i++) {
           try {
               queue.offer(dr.getStudent());
           } catch (Exception e){
               System.out.println(e.getMessage());
           }
           try {
               if (queue.size() == queue.maxSize() - 1) {
                   while (!queue.isEmpty()) {
                       System.out.print(queue.poll() + " ");
                   }
                   System.out.println();
               }
           } catch (Exception e) {
               System.out.println(e.getMessage());
           }
       }
        try {
            while (!queue.isEmpty()) {
                System.out.print(queue.poll() + " ");
            }
            System.out.println();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
