package LeetCode;
// 26. Remove Duplicates from Sorted Array
public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        if(nums.length == 0) return 0;

        int i=0;
        for(int j=1; j<nums.length; j++) {
            if(nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j]; // nums[i] always store the value that does not duplicates
            }
        }
        return i+1;
    }
}
