class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stack = new Stack();
        int n = nums.length;
        for(int i = n-2;i>=0;i--)
            stack.add(nums[i]);
        
        for(int i = n-1;i>=0;i--) {
            int num = nums[i];
            while(!stack.isEmpty() && stack.peek() <= num) 
                stack.pop();
            
            nums[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.add(num);
        }
        return nums;
    }
}