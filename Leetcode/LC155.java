package com.Leetcode;

import java.util.*;

public class LC155 {

}
class MinStack {
    Stack<Integer> stack;
    PriorityQueue<Integer>queue;

    public MinStack() {
        stack=new Stack<>();
        queue=new PriorityQueue<>();
    }

    public void push(int val) {
        stack.push(val);
        queue.add(val);
    }

    public void pop() {
        int t=stack.pop();
        queue.remove(t);
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        if (queue.isEmpty()){
            return -1;
        }
        return queue.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
