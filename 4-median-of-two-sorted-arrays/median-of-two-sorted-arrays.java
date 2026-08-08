class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        // ------- O(log(n+m))
        int n = nums1.length;
        int m = nums2.length;
        
        // [2, 5]. [3, 6, 10]

        // make sure the nums1 is smaller
        if(n > m) {
            return findMedianSortedArrays(nums2, nums1);
        }
        int low = 0;
        int high = n;
        int needed = (n + m + 1) / 2;
        while(low <= high) {
            int mid1 = (low + high)/ 2;
            int mid2 = needed - mid1;
            int left1 = Integer.MIN_VALUE;
            int left2 = Integer.MIN_VALUE;
            int right1 = Integer.MAX_VALUE;
            int right2 = Integer.MAX_VALUE;
            if(mid1 < n) {
                right1 = nums1[mid1];
            }
            if(mid2 < m) {
                right2 = nums2[mid2];
            }
            if((mid1 - 1) >= 0) {
                left1 = nums1[mid1-1];
            }
            if((mid2 - 1) >= 0) {
                left2 = nums2[mid2-1];
            }
            if(left1 <= right2 && left2 <= right1) {
                int leftPart = Math.max(left1, left2);
                int rightPart = Math.min(right1, right2);
                return (n+m) % 2 == 0 ? (leftPart + rightPart)/2.0 : leftPart;
            } else if(left1 > right2) {
                high = mid1-1;
            } else {
                low = mid1+1;
            }
        }
        return 0;




        // -------- (n+m) / 2 ---------
        // int n = nums1.length;
        // int m = nums2.length;
        // int index1 = 0;
        // int index2 = 0;
        // int middle = (n + m - 1) / 2;
        // int count = 0;
        // while(index1 < n && index2 < m && count < middle) {
        //     if(nums1[index1] < nums2[index2]) {
        //         index1++;
        //     } else {
        //         index2++;
        //     }
        //     count++;
        // }
        // while(index1 < n && count < middle) {
        //     index1++;
        //     count++;
        // }
        // while(index2 < m && count < middle) {
        //     index2++;
        //     count++;
        // }
        // double first = 0;
        // double second = 0;
        // if(count == middle) {
        //     if(index1 < n && index2 < m) {
        //         if(nums1[index1] < nums2[index2]) {
        //             first = nums1[index1++];
        //         } else {
        //             first = nums2[index2++];
        //         }
        //     } else if(index1 < n) {
        //         first = nums1[index1++];
        //     } else if(index2 < m){
        //         first = nums2[index2++];
        //     }
        //     if(index1 < n && index2 < m) {
        //         if(nums1[index1] < nums2[index2]) {
        //             second = nums1[index1++];
        //         } else {
        //             second = nums2[index2++];
        //         }
        //     } else if(index1 < n) {
        //         second = nums1[index1++];
        //     } else if(index2 < m){
        //         second = nums2[index2++];
        //     }
        // }
        // System.out.println("First: "+first);
        // System.out.println("Second: "+second);
        // double answer = (first + second) / 2;
        // System.out.println("Answer : "+answer);
        // return (n+m) % 2 == 0 ? (double)((first+second) / 2) : first;
    }
}