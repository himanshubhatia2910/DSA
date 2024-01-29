class MyQueue {

    Stack<Integer> st1;
    Stack<Integer> st2;

    public MyQueue() {
        st1 = new Stack<>();
        st2 = new Stack<>();
    }
    
    public void push(int x) {
        st1.push(x);
    }
    
    public int pop() {
        while (!st1.isEmpty()) {
            st2.push(st1.pop());
        }
        int val = st2.pop();
        while (!st2.isEmpty()) {
            st1.push(st2.pop());
        }
        return val;
    }
    
    public int peek() {
        if (!st1.isEmpty()) {
            return st1.get(0);
        }
        return -1; 
    }
    
    public boolean empty() {
        return st1.isEmpty();
    }
}
