package data_structure.queue_ex;

import java.util.ArrayList;

public class Make_Queue<T> {
    private ArrayList<T> queue = new ArrayList<T>();

    public Make_Queue(){

    }

    public void enQueue(T value){
        queue.add(value);
    }

    public T deQueue() {
        if(queue.isEmpty()) {
            return null;
        }
        return queue.remove(0);
    }

    public boolean isEmpty(){
        return queue.isEmpty();
    }

    public static void main(String[] args) {
        Make_Queue queue = new Make_Queue();
        queue.enQueue(1);
        queue.enQueue(2);
        queue.enQueue(3);
        queue.enQueue(4);

        System.out.println(queue.deQueue());
        System.out.println(queue.deQueue());
        System.out.println(queue.deQueue());
        System.out.println(queue.deQueue());
        System.out.println(queue.deQueue());

    }

}
