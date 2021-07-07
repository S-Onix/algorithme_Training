package data_structure.stack_ex;

import java.util.Stack;

/**
 * Stack : lifo(last in first out)
 *
 * java.util.Stack
 * main method : push() / pop()
 *
 */
public class Stack_ex {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
