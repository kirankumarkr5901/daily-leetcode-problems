class StockSpanner {

    Map<Integer, Integer> index;
    int day;
    Stack<Integer> stack;

    public StockSpanner() {
        index = new HashMap();
        day = 0;
        stack = new Stack();
    }
    
    public int next(int price) {
        while(!stack.isEmpty() && stack.peek() <= price) 
            stack.pop();

        day++;
        int answer = stack.isEmpty() ? day : day - index.get(stack.peek());
        index.put(price, day);
        stack.add(price);
        return answer;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */