class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = piles[0];
        for(int pile: piles) {
            high = Math.max(high, pile);
        }
        int ans = high;

        while(low <= high) {
            int k = low + (high - low) / 2;
            long timeTaken = 0;
            for(int pile: piles) {
                timeTaken += Math.ceilDiv(pile, k);
            }
            if(timeTaken <= h) {
                ans = k;
                high = k-1;
            } else {
                low = k+1;
            }
        }
        return ans;
    }
}