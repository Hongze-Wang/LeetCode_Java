// 153. Find Minimum in Rotated Sorted Array
// conditioned binary search
class Solution {
    public int findMin(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        if(nums.length == 1) return nums[0];
        int left = 0, right = nums.length - 1, mid;
        if(nums[right] > nums[0]) return nums[0]; // no ratated case
        while(right >= left) {
            mid = left + (right - left) / 2;
            if(nums[mid] > nums[mid+1]) {
                return nums[mid+1];
            }
            if(nums[mid-1] > nums[mid]) {
                return nums[mid];
            }
            if(nums[mid] > nums[0]) {
                left = mid+1;
            } else {
                right = mid-1;
            }
        }
        return -1;
    }
}
