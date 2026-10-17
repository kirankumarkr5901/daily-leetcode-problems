class Solution {

    class DigitSum {
        private int digitSum;
        private int number;

        DigitSum(int digitSum, int number) {
            this.digitSum = digitSum;
            this.number = number;
        }

        int getDigitSum() {
            return this.digitSum;
        }

        int getNumber() {
            return this.number;
        }

        public String toString() {
            return "[ "+this.digitSum+" : "+this.number+" ]";
        }
    }

    public int minSwaps(int[] nums) {
        List<DigitSum> list = new ArrayList();
        for(int num: nums) {
            int sum = 0;
            int curr = num;;
            while(curr > 0) {
                sum = sum + curr%10;
                curr /= 10;
            }
            list.add(new DigitSum(sum, num));
        }
        Collections.sort(list, Comparator.comparingInt(DigitSum::getDigitSum).thenComparingInt(DigitSum::getNumber));

        Map<Integer, Integer> map = new HashMap();
        int n = nums.length;
        for(int i = 0;i<nums.length;i++) {
            map.put(nums[i], i);
        }
        int swaps = 0;
        for(int i = 0;i<n;i++) {
            int expected = list.get(i).getNumber();

            if(nums[i] == expected) continue;

            int swapIndex = map.get(expected);

            map.put(expected, i);
            map.put(nums[i], swapIndex);

            int temp = nums[i];
            nums[i] = nums[swapIndex];
            nums[swapIndex] = temp;

            swaps++;
        }
        return swaps;
    }
}