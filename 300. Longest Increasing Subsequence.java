// 300. Longest Increasing Subsequence

// dp[i] 表示以i下标位置的数字作为终点 最大连续上升子串的长度
// class Solution {
//     public int lengthOfLIS(int[] nums) {
//         if(nums.length == 0) return 0;
//         int res = 1;
//         int[] dp = new int[nums.length];
//         dp[0] = 1;
//         for(int i=1; i<nums.length; i++) {
//             int max = 0;
//             for(int j=0; j<i; j++) {
//                 if(nums[i] > nums[j]) {
//                     max = Math.max(max, dp[j]);
//                 }
//             }
//             dp[i] = max+1;
//             res = Math.max(res, dp[i]);
//         }
//         return res;
//     }
// }

// 二分法
// binarySearch 如果没有找到 返回 -(插入位置index+1)
// -(-(插入位置index+1)+1) 得到正数的插入位置
// 升序插入时 res会增长
public class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] order = new int[nums.length];
        int res = 0;
        for(int i=0; i<nums.length; i++) {
            int index = Arrays.binarySearch(order, 0, res, nums[i]);
            if(index < 0) {
                index = -(index+1);
            }
            order[index] = nums[i];
            if(index == res) {
                res++;
            }
        }
        return res;
    }
}
