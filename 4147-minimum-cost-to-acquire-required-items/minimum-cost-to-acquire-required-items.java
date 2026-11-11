class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
        int minCost = Math.min(cost1 + cost2, costBoth);
        int minNeed = Math.min(need1, need2);
        long answer = (long)minCost * (long)minNeed;
        if(minNeed < need1) {
            int rem = need1 - minNeed;
            answer += (long)rem * (long)Math.min(costBoth, cost1);
        }
        if(minNeed < need2) {
            int rem = need2 - minNeed;
            answer += (long)rem * (long)Math.min(costBoth, cost2);
        }
        return answer;
    }
}