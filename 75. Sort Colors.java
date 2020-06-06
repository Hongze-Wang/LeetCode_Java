// 75. Sort Colors

/*
A rather straight forward solution is a two-pass algorithm using counting sort.
First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.
*/

class Solution {
    public void sortColors(int[] nums) {
        if(nums == null || nums.length < 2) return;
        
        int low = 0, i = 0, temp = 0, high = nums.length - 1;
        while(i <= high) {
            if(nums[i] == 0) {
                temp = nums[low];
                nums[low] = nums[i];
                nums[i] = temp;
                low++;
                i++;
            } else if(nums[i] == 1) {
                i++;
            } else {
                temp = nums[high];
                nums[high] = nums[i];
                nums[i] = temp;
                high--;
            }
        }
    }
