class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] < nums[right]) right = mid;
            else left = mid+1;
        }

        int small = right;
        left = 0;
        right = nums.length-1;
        if(nums[right] < target) right = small-1;
        else left = small;

        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] == target) return mid;
            if(nums[mid] < target) left = mid+1;
            else right = mid-1;
        }
        return -1;
    }
}