class Solution {
    public int missingInteger(int[] nums) {
        int n = nums.length;
        if(n == 1) {
            return nums[0]+1;
        }
        int answer = nums[0];
        int j = 1;
        for(j=1;j<n;j++) {
            if((nums[j-1]+1) != nums[j]) {
                break;
            }
            answer += nums[j];
        }
        if(j == n) {
            return answer;
        }
        Set<Integer> set = new HashSet();
        for(int k = 0;k<n;k++) {
            set.add(nums[k]);
        }

        while(set.contains(answer)) {
            answer++;
        }
        return answer;
    }
}