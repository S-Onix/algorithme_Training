package data_structure.queue_ex;

import java.util.LinkedList;
import java.util.Queue;

/**
 *  queue : fifo(first in first out)
 *  what's exist method for queue?
 *  goal : know about useful method for queue
 *
 *  concept : enqueue, dequeue
 *
 *  java.util.Queue
 *  Enqueue : add(value) , offer(value)
 *  Dequeue : poll(), remove()
 *
 *  when we use Queue class, we use with LinkedList class.
 */

public class Queue_ex {


    public static void main(String[] args) {
        Queue<Integer> queueInt = new LinkedList<>();
        Queue<String> queueString = new LinkedList<>();

        queueInt.add(1);
        queueInt.offer(1);

        queueString.add("String1");
        queueString.offer("String2");

        int result = queueInt.poll();
        System.out.println(result);

        String result2 = queueString.remove();
        System.out.println(result2);



    }

}
