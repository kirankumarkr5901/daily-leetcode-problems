class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        int start = 0, end = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] < target){
                start++;
            }
            else if(nums[i] == target){
                end++;
            }
        }
        List<Integer> op = new ArrayList<>();
        end = end+start-1;
        for(int i =start; i <= end; i++){
            op.add(i);
        }

        return op;
    }
}