class Solution {
    public int missingInteger(int[] nums) {
        int n = nums.length;
        int answer = nums[0];
        for(int k = 1;k<n;k++) {
            if((nums[k-1]+1) != nums[k]) {
                break;
            }
            answer += nums[k];
        }
        while(true) {
            boolean found = false;
            for(int i = 0;i<n;i++) {
                if(nums[i] == answer) {
                    found = true;
                    break;
                }
            }
            if(!found) {
                return answer;
            }
            answer++;
        }
    }
}