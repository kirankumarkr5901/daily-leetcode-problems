class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        int len = nums.length;
        int min = nums[0];
        int max = nums[0];
        Set<Integer> set = new HashSet();
        for(int num: nums) {
            set.add(num);
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        List<Integer> answer = new ArrayList();
        for(int i = min+1;i<max;i++) {
            if(!set.contains(i)) {
                answer.add(i);
            }
        }
        return answer;

    }
}