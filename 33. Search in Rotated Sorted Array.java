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
