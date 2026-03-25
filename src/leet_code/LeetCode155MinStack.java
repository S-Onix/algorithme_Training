package src.leet_code;

import java.util.ArrayDeque;
import java.util.Deque;

public class LeetCode155MinStack {
    Deque<Integer> stack = new ArrayDeque<>();
    Deque<Integer> minStack;


    public LeetCode155MinStack() {
        // 초기화
        stack = new ArrayDeque<>();
        minStack = new ArrayDeque<>();
    }

    public void push(int val) {
        // val을 stack에 추가
        stack.push(val);
        if(minStack.isEmpty()){
            minStack.push(val);
        }else {
            minStack.push(Math.min(val, minStack.peek()));
        }


    }

    public void pop() {
        // 가장 위의 값 제거
        stack.pop();
        minStack.pop();

    }

    public int top() {
        // 가장 위의 값 반환
        return !stack.isEmpty() ? stack.peek() : null;
    }

    public int getMin() {
        // 현재 stack의 최솟값 반환 (O(1) 이어야 해요!)
        return !minStack.isEmpty() ?minStack.peek() : null;
    }
}
