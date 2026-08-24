class Solution {
    public void sortColors(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int index = 0;
        while(index <= right) {
            if(nums[index] == 0) {
                int temp = nums[left];
                nums[left] = nums[index];
                nums[index] = temp;
                left++;
                index++;
            } else if (nums[index] == 1) {
                index++;
            }else if(nums[index] == 2) {
                int temp = nums[right];
                nums[right] = nums[index];
                nums[index] = temp;
                right--;
            }
        }
    }
}