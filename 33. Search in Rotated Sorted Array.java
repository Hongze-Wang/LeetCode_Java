// 33. Search in Rotated Sorted Array

// O(logn) means that you must use log(n) search algorithm
// Still use binary search, but only judge when there is less or equal than two elem
class Solution {
    private int index = -1;

    public int search(int[] nums, int target) {
        if(nums.length == 1) {
            if(nums[0] == target) return 0;
            else return -1;
        }
        int mid = nums.length / 2;
        search(nums, 0, mid, target);
        search(nums, mid, nums.length, target);
        return index;
    }

    private void search(int[] nums, int left, int right, int target) {
        int len = right - left;
        if(index != -1) {
            return;
        }
        if(len <= 2) {
            for(int i=0; i<len; i++) {
                if(nums[left + i] == target) {
                    index = left+i;
                }
            }
            return;
        }
        int mid = (left + right) / 2;
        search(nums, left, mid, target);
        search(nums, mid, right, target);
    }
}

// 33. Search in Rotated Sorted Array
// Same solution as 81. Search in Rotated Sorted Array II.java

class Solution {
    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0) return -1;
        if(nums.length == 0 && nums[0] == target) return 0;
        
        int low=0, high=nums.length-1, mid;
        while(low <= high) {
            mid = low + (high-low) / 2;
            if(nums[mid] == target) return mid;
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
        return -1;
    }
}
