package data_structure.stack_ex;

import java.util.ArrayList;

public class Make_Stack <T>{
    private ArrayList<T> stack = new ArrayList<>();

    public void push(T item) {
        stack.add(item);
    }

    public T pop(){
        if (stack.isEmpty()) {
            return null;
        }

        return stack.remove(stack.size()-1);
    }

    public boolean isEmpty(){
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Make_Stack<String> stack = new Make_Stack<>();
        stack.push("test1");
        stack.push("test2");
        stack.push("test3");
        stack.push("test4");

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());

    }
}
