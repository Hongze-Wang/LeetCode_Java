package LeetCode;
// 137.Single Number II

// class Solution {
//     public int singleNumber(int[] nums) {
//         // Initialize a array that represent a number in 32-bit
//         int[] bits = new int[32];
//         for(int i = 0; i < 32; i++) {
//             bits[i] = 0;
//         }
//         // Transfer every elem in nums in 32-bit form and add all of them
//         for(int num: nums) {
//             for(int i = 0; i < 32; i++) {
//                 if(((num >> i) & 1) == 1) {
//                     bits[i]++;
//                 }
//             }
//         }
//         int res = 0;
//         for(int i = 0; i < 32; i++) {
//             // Every bit that not 0 and can't be divided belong to the single number
//             if(bits[i] != 0 && ((bits[i] % 3) != 0)) {
//                 // restore the single number from 32-bit form
//                 res |= 1 << i;
//             }
//         }
//         return res;
//     }
// }
public class SingleNumberII {
    public int singleNumber(int[] nums) {
        int ones = 0, twos = 0, threes;
        for(int i = 0; i < nums.length; i++) {
            int t = nums[i];
            twos |= ones & t;
            ones ^= t;
            threes = ones & twos;

            ones &= ~threes;
            twos &= ~threes;
        }
        return ones;
    }
}
// Because we will use the former ones
// We compute the twos first
// The number both appear in ones and twos is the number appear three times
// delete them from ones and twos
