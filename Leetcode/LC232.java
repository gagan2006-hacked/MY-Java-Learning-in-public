package com.Leetcode;

import java.util.EmptyStackException;
import java.util.Stack;

public class LC232 {
    public static void main(String[] args) throws Exception {
        MyQueue obj = new MyQueue();
        obj.push(10);
        int param_2 = obj.pop();
        int param_3 = obj.peek();
        boolean param_4 = obj.empty();
        System.out.println(obj);
    }

}
class MyQueue {
    private Stack<Integer> queue;
    private Stack<Integer> helper;

    int size=0;

    public MyQueue() {
        this.queue=new Stack<>();
        this.helper=new Stack<>();
        this.size=queue.size();
    }

    public void push(int x) {
        this.queue.push(x);
        this.size=this.queue.size();
    }

    public int pop()  {
        if (this.queue.isEmpty()){
            return -1;
        }
        while (!this.queue.isEmpty()){
            this.helper.push(this.queue.pop());
        }
        int val=this.helper.pop();
        while (!this.helper.isEmpty()){
            this.queue.push(this.helper.pop());
        }
        return val;
    }

    public int peek() {
        if (this.queue.isEmpty()){
            return -1;
        }
        while  (!this.queue.isEmpty()){
            this.helper.push(this.queue.pop());
        }
        int val=this.helper.peek();
        while (!this.helper.isEmpty()){
            this.queue.push(this.helper.pop());
        }
        return val;
    }

    public boolean empty() {
        if (this.queue.isEmpty()) return true;
        return false;
    }
}

/*
 * Your MyQueue object will be instantiated and called as such:
 MyQueue obj = new MyQueue();
 obj.push(x);
 int param_2 = obj.pop();
 int param_3 = obj.peek();
 boolean param_4 = obj.empty();
 */
