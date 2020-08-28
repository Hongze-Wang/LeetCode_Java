// 225. Implement Stack using Queues

// two queue
// using top to store stack top
// return top as pop() and use anther queue to store the elem except for the top elem
// using temp reference to swap two queue

class MyStack {
    private Queue<Integer> q1;
    private Queue<Integer> q2;
    private int top;

    /** Initialize your data structure here. */
    public MyStack() {
        q1 = new LinkedList();
        q2 = new LinkedList();
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        q1.offer(x);
        top = x;
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        int ret = top;
        while(q1.size() > 1) {
            top = q1.poll();
            q2.offer(top);
        }
        q1.poll();
        Queue<Integer> t = q1;
        q1 = q2;
        q2 = t;
        
        return ret;
    }
    
    /** Get the top element. */
    public int top() {
        return top;
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return q1.isEmpty();
    }
}


// every push or pop do not forget to update the top pointer

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */

 class MyStack {
    private Queue<Integer> q;
    private int top;

    /** Initialize your data structure here. */
    public MyStack() {
        q = new LinkedList();
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        top = x;
        q.offer(x);
        int len = q.size();
        while(len > 1) {
            q.offer(q.poll());
            len--;
        }
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        int ret = q.poll();
        if(q.isEmpty()) {
            top = 0;
        } else {
            top = q.peek();
        }
        return ret;
    }
    
    /** Get the top element. */
    public int top() {
        return top;
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return q.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
