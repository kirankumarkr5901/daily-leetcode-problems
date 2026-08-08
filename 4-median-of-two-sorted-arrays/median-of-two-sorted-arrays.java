class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int index1 = 0;
        int index2 = 0;
        int middle = (n + m - 1) / 2;
        int count = 0;
        while(index1 < n && index2 < m && count < middle) {
            if(nums1[index1] < nums2[index2]) {
                index1++;
            } else {
                index2++;
            }
            count++;
        }
        while(index1 < n && count < middle) {
            index1++;
            count++;
        }
        while(index2 < m && count < middle) {
            index2++;
            count++;
        }
        double first = 0;
        double second = 0;
        if(count == middle) {
            if(index1 < n && index2 < m) {
                if(nums1[index1] < nums2[index2]) {
                    first = nums1[index1++];
                } else {
                    first = nums2[index2++];
                }
            } else if(index1 < n) {
                first = nums1[index1++];
            } else if(index2 < m){
                first = nums2[index2++];
            }
            if(index1 < n && index2 < m) {
                if(nums1[index1] < nums2[index2]) {
                    second = nums1[index1++];
                } else {
                    second = nums2[index2++];
                }
            } else if(index1 < n) {
                second = nums1[index1++];
            } else if(index2 < m){
                second = nums2[index2++];
            }
        }
        System.out.println("First: "+first);
        System.out.println("Second: "+second);
        double answer = (first + second) / 2;
        System.out.println("Answer : "+answer);
        return (n+m) % 2 == 0 ? (double)((first+second) / 2) : first;
    }
}