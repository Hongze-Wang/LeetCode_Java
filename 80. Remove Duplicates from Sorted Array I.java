// 80. Remove Duplicates from Sorted Array II

// two pointers
class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length < 3) return nums.length;
        
        int slow=1, count=1, fast=1;
        while(fast < nums.length) {
            if(count <= 2 &&  nums[fast] == nums[fast-1]) {
                count++;
                if(count <= 2) nums[slow++] = nums[fast];
            } else if(nums[fast] != nums[fast-1]) {
                count = 1;
                nums[slow++] = nums[fast];
            }
            slow++;
        }
    return slow;
    }
}
