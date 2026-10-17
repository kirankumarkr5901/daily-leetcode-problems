class CustomStack {

    Stack<Integer> stack;
    Stack<Integer> helper;
    private int size;

    public CustomStack(int maxSize) {
        stack = new Stack();
        helper = new Stack();
        size = maxSize;
    }
    
    public void push(int x) {
        if(size == stack.size()) return;
        stack.push(x);
    }
    
    public int pop() {
        return stack.isEmpty() ? -1 : stack.pop();
    }
    
    public void increment(int k, int val) {
        while(!stack.isEmpty())
            helper.push(stack.pop());
        while(!helper.isEmpty() && k > 0) {
            stack.push(helper.pop() + val);
            k--;
        }
        while(!helper.isEmpty())
            stack.push(helper.pop());
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */