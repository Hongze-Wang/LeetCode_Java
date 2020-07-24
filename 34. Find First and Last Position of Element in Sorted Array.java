// 34. Find First and Last Position of Element in Sorted Array

// I didn't know why this solution exceed time limit

// class Solution {
//     private int[] expandAroundCenter(int[] nums, int center) {
//         int start = center, end = center;
//         while(nums[start-1] == nums[center]) {
//             start--;
//         }
//         while(nums[end+1] == nums[center]) {
//             end++;
//         }
//         int[] res = {start, end};
//         return res;
//     }
    
//     public int[] searchRange(int[] nums, int target) {
//         int[] targetRange = {-1, -1};
//         if(nums == null) return targetRange;
        
//         int left = 0, right = nums.length-1; 
//         int center = -1;
//         while(left <= right) {
//             int mid = left + (right-left)/2;
//             if(nums[mid] == target) {
//                 center = mid;
//             } else if(nums[mid] < target) {
//                 left = mid + 1;
//             } else {
//                 right = mid - 1;
//             }
//         }
//         if(center == -1) return targetRange;
//         else return expandAroundCenter(nums, center);
//     }
// }

// Ascending Order - Binary Search
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] targetRange = {-1, -1};
        int leftIndex = binarySearch(nums, target, true);
        
        if(leftIndex == nums.length || nums[leftIndex] != target) return targetRange;
        
        targetRange[0] = leftIndex;
        targetRange[1] = binarySearch(nums, target, false)-1;
        
        return targetRange;
    }
    private int binarySearch(int[] nums, int target, boolean left) {
        int low = 0, high = nums.length, mid;
        while(low < high) {
            // mid = low + (high-low) / 2;
            mid = (low + high) / 2;
            if(nums[mid] > target || (left && nums[mid] == target)) {
                high = mid;
            } else {
                low = mid+1;
            }
        }
        return low;
    }
}
