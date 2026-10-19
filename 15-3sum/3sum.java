class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList();
        for(int i = 0;i<n-2;i++) {

            if(i > 0 && nums[i] == nums[i-1])
                continue;
            
            if(nums[i] > 0)
                break;
            
            int start = i+1;
            int end = n-1;
            while(start < end) {
                int sum = nums[i] + nums[start] + nums[end];
                if(sum == 0) {
                    List<Integer> list = new ArrayList();
                    list.add(nums[i]);
                    list.add(nums[start]);
                    list.add(nums[end]);
                    ans.add(list);
                    start++;
                    while(nums[start] == nums[start-1] && start < end)
                        start++;
                }
                else if(sum < 0) start++;
                else end--;
            }
        }
        return ans;
    }
}