class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        int small = 0;
        int targetCount = 0;
        for(int num: nums) {
            if(num == target)
                targetCount++;
            else if(num < target)
                small++;
        }
        int index = small;
        List<Integer> ans = new ArrayList();
        while(index < (small + targetCount)){
            ans.add(index);
            index++;
        }
        return ans;
    }
}