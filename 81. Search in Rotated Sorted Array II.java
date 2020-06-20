// 81. Search in Rotated Sorted Array II

class Solution {
    public boolean search(int[] nums, int target) {
        int low=0, high = nums.length-1, mid;
        while(low <= high) {
            mid = low + (high-low) / 2;
            if(nums[mid] == target) return true;
            if(nums[mid] == nums[high]) high--;
            else if(nums[mid] < nums[high]) {
                if(nums[mid] < target && nums[high] >= target) {
                    low = mid+1;
                } else {
                    high = mid-1;
                }
            } else {
                if(nums[mid] > target && nums[low] <= target) {
                    high = mid-1;
                } else {
                    low = mid+1;
                }
            }
        }
        return false;
    }   
}
