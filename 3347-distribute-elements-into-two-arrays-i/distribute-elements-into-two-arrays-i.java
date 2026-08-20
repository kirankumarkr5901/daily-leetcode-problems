class Solution {
    public int[] resultArray(int[] nums) {
        int n = nums.length;
        int[] part1 = new int[n];
        int[] part2 = new int[n];
        int index1 = 0;
        int index2 = 0;
        int index = 0;
        part1[index1] = nums[index++];
        part2[index2] = nums[index++];
        for(;index<n;index++) {
            if(part1[index1] > part2[index2]) {
                part1[++index1] = nums[index];
            } else {
                part2[++index2] = nums[index];
            }
        }
        index = 0;
        for(int i = index1+1;i<n;i++) {
            part1[i] = part2[index++];
        }
        return part1;
    }
}