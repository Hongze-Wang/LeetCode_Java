// 162. Find Peak Element

// Mind the question condition
// nums[-1] and nums[lenght] are all -infinity
// and nums[i] != nums[i+1]
// the answer can be any peaks not the largest one
// we have three suituations the first two can be regarded as border case
// 1. the peak is the first element (border case)
// 2. the peak is the last element (border case)
// 3. the peak is in the middle of the array (normal case)
// for all the three cases, we can return the first element that larger than next element (for case 1 and 3)
// other we return the last index (for case 2)

class Solution {
    public int findPeakElement(int[] nums) {
        int i = 0;
        while(i < nums.length-1) {
            if(nums[i] > nums[i+1]) {
                return i;
            }
            i++;
        }
        return i;
    }
}