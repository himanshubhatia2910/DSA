class MyStack {

        private int[] stack;
    private int pointer;

    public MyStack() {
        this.stack   = new int[100];
        this.pointer = 0;
    }

    public void push(int x) {
        this.pointer++;
        this.stack[pointer] = x;
    }

    public int pop() {
        this.pointer--;
        return this.stack[pointer+1];
    }

    public int top() {
        return this.stack[pointer];
    }

    public boolean empty() {
        return this.pointer == 0;
    }
}

class MyStackEasy {

    private Deque<Integer> queue;

    public MyStackEasy() {
        this.queue = new ArrayDeque<>(100);
    }
    
    public void push(int x) {
        queue.offer(x);
    }
    
    public int pop() {
        return queue.removeLast();
    }
    
    public int top() {
        return queue.peekLast();
    }
    
    public boolean empty() {
        return queue.isEmpty();
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