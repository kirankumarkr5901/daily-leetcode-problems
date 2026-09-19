class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap();
        map.put(0, 1);
        int answer = 0;
        int sum = 0;

        // Make all positive
        for(int i = 0;i<nums.length;i++) {
            nums[i] = nums[i] % k;
            if(nums[i] < 0) {
                nums[i] = k+nums[i];
            }
        }
        System.out.println();
        for(int i = 0;i<nums.length;i++) {
            sum += nums[i];
            int key = sum % k;
            if(map.containsKey(key)) {
                answer += map.get(key);
                map.put(key, map.get(key)+1);
            } else {
                map.put(key, 1);
            }
        }
        return answer;
    }
}