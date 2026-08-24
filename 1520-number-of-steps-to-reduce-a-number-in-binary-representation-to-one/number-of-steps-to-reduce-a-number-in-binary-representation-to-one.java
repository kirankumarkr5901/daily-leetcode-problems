class Solution {
    public int numSteps(String s) {
        int n = s.length();
        StringBuilder sb = new StringBuilder(s);
        int steps = 0;
        while(n > 1) {
            steps++;
            char lastBit = sb.charAt(n-1);
            if(lastBit == '0') {
                sb.deleteCharAt(n-1);
            } else {
                sb.setCharAt(n-1, '0');
                boolean inserted = false;
                for(int i = n-2;i>=0;i--) {
                    if(sb.charAt(i) == '0') {
                        sb.setCharAt(i, '1');
                        inserted = true;
                        break;
                    }
                    sb.setCharAt(i, '0');
                }
                if(!inserted) {
                    sb.insert(0, '1');
                }
            }
            n = sb.length();
        }
        return steps;
    }
}