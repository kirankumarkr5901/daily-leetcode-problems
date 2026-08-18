class Solution {
    public int largestInteger(int[] nums, int k) {
        int n = nums.length;
        int first = nums[0];
        int last = nums[n-1];
        int max = nums[0];
        for(int num: nums) {
            max = Math.max(max, num);
        }
        if(k == n) {
            return max;
        }
        else if(k == 1) {
            int[] count = new int[max+1];
            for(int num: nums) {
                count[num]++;
            }
            for(int i = max;i>0;i--) {
                if(count[i] == 1) {
                    return i;
                }
            }
            return -1;
        }
        if(first == last) return -1;
        int firstCount = 0;
        int lastCount = 0;
        for(int num: nums) {
            if(num == first) firstCount++;
            else if(num == last) lastCount++;
        }
        if(firstCount > 1 && lastCount > 1) {
            return -1;
        } else if(firstCount > 1) {
            return last;
        } else if(lastCount > 1){
            return first;
        }
        return first > last ? first : last;
    }
}