class Solution {
    final int MOD = 1000000000 + 7;
    long[][] pascals;
    public int numOfWays(int[] nums) {
        int n = nums.length;
        pascals = new long[n][n];
        
        for(int i = 0;i<n;i++) {
            long[] level = new long[i+1];
            Arrays.fill(level, 1);
            for(int j = 1;j<i;j++)
                level[j] = (pascals[i-1][j] + pascals[i-1][j-1]) % MOD;
            pascals[i] = level;
        }

        List<Integer> list = new ArrayList();
        for(int num: nums)
            list.add(num);

        return (int)(getWays(list) - 1) % MOD;
        
    }

    private long getWays(List<Integer> list) {
        int n = list.size();
        if(n < 3)
            return 1;

        List<Integer> left = new ArrayList();
        List<Integer> right = new ArrayList();

        int root = list.get(0);
        for(int i = 1;i<n;i++) {
            if(root > list.get(i))
                left.add(list.get(i));
            else
                right.add(list.get(i));
        }

        long curr = pascals[n-1][left.size()] % MOD;
        long leftCount = getWays(left) % MOD;
        long rightCount = getWays(right) % MOD;

        return (((leftCount * rightCount) % MOD) * curr) % MOD;

    } 
}