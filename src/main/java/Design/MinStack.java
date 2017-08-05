package Design;

import java.util.Stack;

/**
 Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

 push(x) -- Push element x onto stack.
 pop() -- Removes the element on top of the stack.
 top() -- Get the top element.
 getMin() -- Retrieve the minimum element in the stack.
 */
public class MinStack {
    Stack<Integer> s;
    int min;
    /** initialize your data structure here. */
    public MinStack() {
        this.min = Integer.MAX_VALUE;
        this.s = new Stack<>();
    }

    public void push(int x) {
        if (x <= min) {
            this.s.push(this.min);
            this.min = x;
        }
        this.s.push(x);
    }

    public void pop() {
        if (this.s.pop() == this.min)
            this.min = s.pop();
    }

    public int top() {
        return this.s.peek();
    }

    public int getMin() {
        return this.min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */