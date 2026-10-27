class Solution {
    public String[] createGrid(int m, int n) {
        String[] ans = new String[m];
        for(int i = 0;i<m;i++) {
            StringBuilder sb = new StringBuilder();
            if(i == 0) {
                for(int j = 0;j<n;j++)
                    sb.append(".");
            } else {
                for(int j = 0;j<n-1;j++)
                    sb.append("#");
                sb.append(".");
            }
            ans[i] = sb.toString();
        }
        return ans;
    }
}