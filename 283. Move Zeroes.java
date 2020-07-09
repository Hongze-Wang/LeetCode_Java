// 283. Move Zeroes
class Solution {
    public void moveZeroes(int[] nums) {
        int temp;
        for(int index=0,i=0; i<nums.length; i++) {
            if(nums[i] != 0) {
                temp = nums[index];
                nums[index] = nums[i];
                nums[i] = temp;
                index++;
            } 
        } 
    }
}

// swap condition there must be zero
// or the relative order can't be retained
// class Solution {
//     public void moveZeroes(int[] nums) {
//         for(int index=0,i=0; i<nums.length; i++) {
//             if(index == i) continue;
//             if(nums[i] != 0) {
//                 nums[index] = nums[index] + nums[i];
//                 nums[i] = nums[index] - nums[i];
//                 nums[index] = nums[index] - nums[i];
//                 index++;
//             }
//         }
//     }
// }

// swap condition no zero
// class Solution {
//     public void moveZeroes(int[] nums) {
//         for(int index=0, i=0; i<nums.length; i++) {
//             if(nums[i] != 0) {
//                 nums[index] = nums[index] ^ nums[i];
//                 nums[i] = nums[index] ^ nums[i];
//                 nums[index] = nums[index] ^ nums[i];
//             }
//             index++;
//         }
//     }
// }
