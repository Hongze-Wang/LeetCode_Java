package LeetCode;
// 27. Remove Element
// class Solution {
//     public int removeElement(int[] nums, int val) {
//         int i = 0;
//         int len = nums.length;

//         while(i < len) {
//             if(nums[i] == val) {
//                 nums[i] = nums[len-1];
//                 len--;
//             } else {
//                 i++;
//             }
//         }
//         return len;
//     }
// }
public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int i=0;
        for(int j=0; j<nums.length; j++) {
            if(nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }
}
