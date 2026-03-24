package src.practrice.week3;

import java.util.ArrayList;
import java.util.List;

public class Stack {

    List<Integer> stack = new ArrayList<>();

    /**
     * push
     * pop
     * peek
     * isEmpty
     * */

    public void push(int value) {
        stack.add(value);
    }

    public int pop() {
        int popValue = -1;


        if(!stack.isEmpty()) {
            popValue = stack.remove(stack.size() - 1);
        }

        return popValue;

    }

    public int peek(){
        return stack.get(stack.size()-1);
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

}
