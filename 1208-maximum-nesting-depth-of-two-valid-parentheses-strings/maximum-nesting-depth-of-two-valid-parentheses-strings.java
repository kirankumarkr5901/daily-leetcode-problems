class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        int n = seq.length();
        int[] ans = new int[n];
        
        int bal = 1;
        for(int i = 0;i<n;i++) {
            char c = seq.charAt(i);
            if(c == '(') {
                bal++;
                ans[i] = bal % 2;
            } else {
                ans[i] = bal % 2;
                bal--;
            }
        }
        return ans;
    }
}