class Solution {

    private boolean canReach(int[] dist, int k, double hour) {
        double timeTaken = 0.0;
        for(int d: dist) {
            timeTaken = Math.ceil(timeTaken);
            timeTaken += d / (double)k;
        }
        return timeTaken <= hour;
    }
    public int minSpeedOnTime(int[] dist, double hour) {
        int low = 1;
        int high = 10_000_000;
        for(int d: dist) high = Math.max(high, d);

        int ans = -1;
        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(canReach(dist, mid, hour)) {
                ans = mid;
                high = mid-1;
            } else low = mid+1;
        }
        return ans;
    }
}