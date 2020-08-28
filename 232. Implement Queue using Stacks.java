// 232. Implement Queue using Stacks

// O(n) push() O(1) pop()
class MyQueue {
    private Stack<Integer> s1;
    private Stack<Integer> s2;
    private int front;
    /** Initialize your data structure here. */
    public MyQueue() {
        s1 = new Stack();
        s2 = new Stack();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        if(s1.empty()) {
            front = x;
        }
        while(!s1.empty()) {
            s2.push(s1.pop());
        }
        s2.push(x);
        while(!s2.empty()) {
            s1.push(s2.pop());
        }
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        int ret = s1.pop();
        if(s1.empty()) {
            front = 0;
        } else {
            front = s1.peek();
        }
        return ret;
    }
    
    /** Get the front element. */
    public int peek() {
        return front;
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return s1.empty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */

// O(1) push() amortized O(1) pop()
class MyQueue {
    private Stack<Integer> s1;
    private Stack<Integer> s2;
    private int front;
    /** Initialize your data structure here. */
    public MyQueue() {
        s1 = new Stack();
        s2 = new Stack();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        if(s1.isEmpty()) {
            front = x;
        }
        s1.push(x);
        
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(s2.isEmpty()) {
            while(!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }
        return s2.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        if(!s2.isEmpty()) {
            return s2.peek();
        }
        return front;
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return s1.empty() && s2.empty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
