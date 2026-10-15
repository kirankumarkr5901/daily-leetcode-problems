class Solution {
    public int sumCounts(List<Integer> nums) {
        int sum = 0;
        Set<Integer> arr = new HashSet<>();
        for(int i = 0; i < nums.size(); i++){
            for(int j = i; j < nums.size(); j++){
                arr.add(nums.get(j));
                sum += (arr.size()) * (arr.size());
            }
            arr.clear();
        }
        return sum;
    }
}