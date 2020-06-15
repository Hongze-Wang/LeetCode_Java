// 34. Find First and Last Position of Element in Sorted Array

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
