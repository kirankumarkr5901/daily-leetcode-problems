class Solution {
    public boolean uniformArray(int[] nums1) {
        int evenCount = 0;
        int oddCount = 0;
        int min = Integer.MAX_VALUE;
        for(int num: nums1) {
            if((num & 1) == 1) {
                oddCount++;
            } else {
                evenCount++;
            }
            min = Math.min(min, num);
        }
        int n = nums1.length;
        if(oddCount == n || evenCount == n) return true;
        return (min & 1) == 1;
    }
}