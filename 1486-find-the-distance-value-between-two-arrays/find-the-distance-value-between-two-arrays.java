class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int ans = 0;
        for(int num1: arr1) {
            boolean found = false;
            for(int num2: arr2) {
                int diff = Math.abs(num1 - num2);
                if(diff <= d) {
                    found = true;
                    break;
                }
            }
            if(!found)
                ans++;
        }
        return ans;
    }
}