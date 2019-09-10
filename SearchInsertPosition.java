package LeetCode;
// 35. Search Insert Position
public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        int j=0;
        for(int i=0; i<nums.length; i++) {
            if(nums[i]<target) {
                j++;
            } else{
                break;
            }
        }
        return j;
    }
}
