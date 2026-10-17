class MyStack {

    Queue<Integer> queue;
    Queue<Integer> helper;

    public MyStack() {
        queue = new LinkedList();
        helper = new LinkedList();
    }
    
    public void push(int x) {
        while(!queue.isEmpty())
            helper.offer(queue.poll());
        queue.offer(x);
        while(!helper.isEmpty())
            queue.offer(helper.poll());
    }
    
    public int pop() {
        return queue.poll();
    }
    
    public int top() {
        return queue.peek();
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