class Solution {

    private boolean canShip(int[] weights, int capacity, int days) {
        int totalDays = 0;
        int sum = 0;
        for(int w: weights) {
            sum += w;
            if(sum == capacity) {
                totalDays++;
                sum = 0;
            }
            else if(sum > capacity) {
                totalDays++;
                sum = w;
            }
        }
        if(sum != 0) totalDays++;

        return totalDays <= days;

    }
    public int shipWithinDays(int[] weights, int days) {
        int low = weights[0];
        int high = 0;
        for(int w: weights) {
            high += w;
            low = Math.max(low, w);
        }

        int ans = high;
        while(low <= high) {
            int k = low + (high - low) / 2;
            if(canShip(weights, k, days)) {
                ans = k;
                high = k-1;
            } else {
                low = k+1;
            }
        }
        return ans;
    }
}