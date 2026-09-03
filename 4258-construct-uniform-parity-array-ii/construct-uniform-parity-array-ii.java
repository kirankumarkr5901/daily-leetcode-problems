class Solution {
    public boolean uniformArray(int[] nums1) {
        int evenCount = 0;
        int oddCount = 0;
        int minOdd = Integer.MAX_VALUE;
        int minEven = Integer.MAX_VALUE;
        for(int num: nums1) {
            if((num & 1) == 1) {
                oddCount++;
                minOdd = Math.min(minOdd, num);
            } else {
                evenCount++;
                minEven = Math.min(minEven, num);
            }
        }
        int n = nums1.length;
        if(oddCount == n || evenCount == n) return true;
        return minOdd < minEven;
    }
}