class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap();
        int n = nums.length;
        int left = 0;
        int right = 0;
        int answer = -1;
        while(right < n) {
            int key = nums[right];
            map.put(key, map.getOrDefault(key, 0)+1);
            while(map.get(key) > k) {
                int stale = nums[left];
                map.put(stale, map.get(stale)-1);
                if(map.get(stale) == 0) {
                    map.remove(stale);
                }
                left++;
            }
            right++;
            answer = Math.max(answer, right - left);
        }
        return answer;
    }
}