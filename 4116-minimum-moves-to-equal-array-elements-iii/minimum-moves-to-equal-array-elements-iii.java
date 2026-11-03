class Solution {
    public int minMoves(int[] nums) {
        int ele = nums[0];
        for(int num: nums)
            ele = Math.max(ele, num);
        int moves = 0;
        for(int num: nums)
            moves += (ele - num);
        return moves;
    }
}