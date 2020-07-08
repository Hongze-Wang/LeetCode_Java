// 154. Find Minimum in Rotated Sorted Array II

class Solution {
    public int findMin(int[] nums) {
        if(nums == null || nums.length == 0) return -1;
        if(nums.length == 1) return nums[0];
        int left=0, right=nums.length-1, mid;
        while(left < right) { // loop end condition left == right
            while(nums[left] == nums[right] && left < right) left++;
            mid = left + (right-left) / 2;
            if(nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return nums[left];
    }
}
