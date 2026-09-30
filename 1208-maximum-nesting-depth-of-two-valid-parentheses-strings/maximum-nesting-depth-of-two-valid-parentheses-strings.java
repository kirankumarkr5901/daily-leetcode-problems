class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        int n = seq.length();
        int[] ans = new int[n];
        
        int bal = 0;
        for(int i = 0;i<n;i++) {
            char c = seq.charAt(i);
            if(c == '(') {
                bal++;
                if((bal & 1) == 1) {
                    ans[i] = 0;
                } else {
                    ans[i] = 1;
                }
            } else {
                if((bal & 1) == 1) {
                    ans[i] = 0;
                } else {
                    ans[i] = 1;
                }
                bal--;
            }
        }
        return ans;
    }
}