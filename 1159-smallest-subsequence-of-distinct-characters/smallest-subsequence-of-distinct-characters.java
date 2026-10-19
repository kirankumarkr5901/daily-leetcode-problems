class Solution {
    public String smallestSubsequence(String s) {
        int[] lastIndex = new int[26];
        int n = s.length();
        for(int i = 0;i < n;i++)
            lastIndex[s.charAt(i) - 'a'] = i;

        boolean[] used = new boolean[26];
        Stack<Character> stack = new Stack();

        for(int i = 0;i < n;i++) {
            char c = s.charAt(i);
            int cIndex = c - 'a';

            if(used[cIndex]) continue;

            while(!stack.isEmpty() && stack.peek() > c && lastIndex[stack.peek() - 'a'] > i)
                used[stack.pop() - 'a'] = false;
            
            stack.push(c);
            used[c - 'a'] = true;
        }

        StringBuilder ans = new StringBuilder();
        while(!stack.isEmpty())
            ans.insert(0, stack.pop());
        
        return ans.toString();
    }
}