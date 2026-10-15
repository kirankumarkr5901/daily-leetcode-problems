class Solution {
    public int sumCounts(List<Integer> nums) {
        int n = nums.size();
        Set<Integer> set = new HashSet();
        int ans = 0;
        for(int i = 0;i<n;i++) {
            set.clear();
            for(int j = i;j<n;j++) {
                set.add(nums.get(j));
                ans += (set.size() * set.size());
            }
        }
        return ans;
    }
}