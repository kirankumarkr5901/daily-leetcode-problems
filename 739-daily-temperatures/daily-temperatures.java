class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack();
        int n = temperatures.length;
        int[] answer = new int[n];

        for(int i = n-1;i>=0;i--) {
            int num = temperatures[i];
            while(!stack.isEmpty() && num >= temperatures[stack.peek()])
                stack.pop();
            
            answer[i] = stack.isEmpty() ? 0 : stack.peek() - i;
            stack.add(i);
        }
        return answer;
    }
}