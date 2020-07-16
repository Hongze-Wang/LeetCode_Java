// 4. Median of Two Sorted Arrays

// Sort (O(len1+len2))
// https://leetcode.com/problems/median-of-two-sorted-arrays/solution/

// class Solution {
//     public double findMedianSortedArrays(int[] nums1, int[] nums2) {
//         int[] nums = new int[nums1.length+nums2.length];
//         int i=0, j=0, index = 0;
//         while(i<nums1.length && j<nums2.length) {
//             if(nums1[i] < nums2[j]) {
//                 nums[index++] = nums1[i++];
//             } else {
//                 nums[index++] = nums2[j++];
//             }
//         }
//         while(i<nums1.length) {
//             nums[index++] = nums1[i++];
//         }
//         while(j<nums2.length) {
//             nums[index++] = nums2[j++];
//         }
//         int mid = nums.length / 2;
//         if((nums.length & 1) == 0) {
//             return (nums[mid] + nums[mid-1]) / 2.0;
//         } else {
//             return (double) nums[mid];
//         }
//     }
// }

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1 == null || nums2 == null) return 0.0;
        int m = nums1.length, n = nums2.length;
        if(m > n) {
            int[] temp = nums1; nums1 = nums2; nums2 = temp;
            int tmp = m; m = n; n = tmp;
        }
        int iMin = 0, iMax = m, half = (m+n+1) / 2;
        while(iMin <= iMax) {
            int i = (iMin + iMax) / 2;
            int j = half - i;
            if(i < iMax && nums2[j-1] > nums1[i]) {
                iMin = i+1;
            } else if(i > iMin && nums1[i-1] > nums2[j]) {
                iMax = i-1;
            } else {
                int maxLeft = 0;
                if(i == 0) maxLeft = nums2[j-1];
                else if(j==0) maxLeft = nums1[i-1];
                else maxLeft = Math.max(nums1[i-1], nums2[j-1]);
                if(((m+n) & 1) == 1) return maxLeft;
                
                int minRight = 0;
                if(i==m) minRight = nums2[j];
                else if(j==n) minRight = nums1[i];
                else minRight = Math.min(nums2[j], nums1[i]);
                
                return (maxLeft + minRight) / 2.0;
            }
        }
        return 0.0;
    }
}
