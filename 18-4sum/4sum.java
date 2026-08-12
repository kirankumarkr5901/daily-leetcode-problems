class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList();
        Set<String> set = new HashSet();
        Arrays.sort(nums);
        int n = nums.length;
        for(int i = 0;i<n-3;i++) {
            for(int j = i+1;j<n-2;j++) {
                int low = j+1;
                int high = n-1;
                while(low < high) {
                    long currentSum = (long)nums[i] + (long)nums[j] + (long)nums[low] + (long)nums[high];
                    if(currentSum == target) {
                        String hash = nums[i]+" "+nums[j]+" "+nums[low]+" "+nums[high];
                        // System.out.println(hash);
                        // System.out.println(set);
                        if(!set.contains(hash)) {
                            List<Integer> pairs = new ArrayList();
                            pairs.add(nums[i]);
                            pairs.add(nums[j]);
                            pairs.add(nums[low]);
                            pairs.add(nums[high]);
                            list.add(pairs);
                            set.add(hash);
                        }
                        low++;
                    } else if(currentSum < target) {
                        low++;
                    } else {
                        high--;
                    }
                }
            }
        }
        return list;
    }
}