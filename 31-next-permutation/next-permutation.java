class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int index = n-2;
        for(;index>=0;index--) {
            if(nums[index] < nums[index+1]) {
                int next = n-1;
                while(next > index) {
                    if(nums[next] > nums[index]) break;
                    next--;
                }
                int temp = nums[index];
                nums[index] = nums[next];
                nums[next] = temp;
                break;
            }
        }
        int left = index+1;
        int right = n-1;
        while(left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }
}