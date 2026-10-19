class Solution {
    public void sortColors(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        for(int curr = 0;curr <= end; curr++) {
            if (nums[curr] == 1 || start > curr) continue;
            else if (nums[curr] == 0) {
                int temp = nums[curr];
                nums[curr] = nums[start];
                nums[start] = temp;
                start++;
            } else {
                int temp = nums[curr];
                nums[curr] = nums[end];
                nums[end] = temp;
                end--;
            }
            curr--;
        }
    }
}