class Solution {
    public int reverseDegree(String s) {
        int answer = 0;
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            int rev = 26 - (c-'a');
            answer += (rev * (i+1));
        }
        return answer;
    }
}