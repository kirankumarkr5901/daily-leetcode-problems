class Solution {

    private int subProblem(int left, int right, int[] leftSum, int[][] dp) {
        if(left >= right) {
            return 0;
        }
        if(dp[left][right] != -1) {
            return dp[left][right];
        }
        int score = 0;
        for(int mid = left;mid<right;mid++) {
            int leftPart = leftSum[mid] - ((left-1) >= 0 ? leftSum[left-1] : 0);
            int rightPart = leftSum[right] - leftSum[mid];
            if(leftPart < rightPart) {
                score = Math.max(score, leftPart + subProblem(left, mid, leftSum, dp));
            } else if(rightPart < leftPart) {
                score = Math.max(score, rightPart + subProblem(mid+1, right, leftSum, dp));
            } else {
                score = Math.max(score, Math.max(leftPart + subProblem(left, mid, leftSum, dp), rightPart + subProblem(mid+1, right, leftSum, dp)));
            }
        }
        return dp[left][right] = score;
    }

    public int stoneGameV(int[] stoneValue) {
        int n = stoneValue.length;
        int[] leftSum = new int[n];
        leftSum[0] = stoneValue[0];
        for(int i = 1;i<n;i++) {
            leftSum[i] = leftSum[i-1]+stoneValue[i];
        }
        int[][] dp = new int[n][n];
        for(int[] row: dp) {
            Arrays.fill(row, -1);
        }
        return subProblem(0, n-1, leftSum, dp);
    }
}