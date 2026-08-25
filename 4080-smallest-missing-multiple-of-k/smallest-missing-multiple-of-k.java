class Solution {
    public int missingMultiple(int[] nums, int k) {
        Set<Integer> hash = new HashSet();
        for(int num: nums) {
            hash.add(num);
        }
        int key = 0;
        for(int i = 1;i <= 100;i++) {
            if(!hash.contains(k*i)) {
                break;
            }
            key += k;
        }
        key += k;
        return key;
    }
}