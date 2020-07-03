// 494. Target Sum

// Complete solution refer to https://leetcode.com/problems/target-sum/solution/, it is inspiring

// Brute Force
// class Solution {
//     public int findTargetSumWays(int[] nums, int S) {
//         if(nums == null || nums.length == 0) return 0;
//         return findTargetSumWays(0, nums, 0, S);
//     }
//     private int findTargetSumWays(int index, int[] nums, int sum, int S) {
//         if(index == nums.length) return sum == S ? 1 : 0; 
//         return findTargetSumWays(index+1, nums, sum-nums[index], S) + findTargetSumWays(index+1, nums, sum+nums[index], S);
//     }
// }

// 2D DP
public class Solution {
    public int findTargetSumWays(int[] nums, int S) {
        int[][] dp = new int[nums.length][2001];
        dp[0][nums[0] + 1000] = 1;
        dp[0][-nums[0] + 1000] += 1; // num[0] == -nums[0] when nums[0] == 0
        for(int i=1; i<nums.length; i++) {
            for(int sum=-1000; sum<=1000; sum++) {
                if(dp[i-1][sum+1000] > 0) {
                    dp[i][sum+nums[i] + 1000] += dp[i-1][sum+1000];
                    dp[i][sum-nums[i] + 1000] += dp[i-1][sum+1000];
                }
            }
        }
        return S > 1000 ? 0 : dp[nums.length-1][S+1000];
    }
}

// // Optimized from 2D DP
// public class Solution {
//     public int findTargetSumWays(int[] nums, int S) {
//         int[] dp = new int[2001];
//         dp[nums[0]+1000] = 1;
//         dp[-nums[0] +1000] += 1;
//         for(int i=1; i<nums.length; i++) {
//             int[] next = new int[2001];
//             for(int sum=-1000; sum<=1000; sum++) {
//                 if(dp[sum+1000] > 0) {
//                     next[sum+nums[i]+1000] += dp[sum+1000];
//                     next[sum-nums[i]+1000] += dp[sum+1000];
//                 }
//             }
//             dp = next;
//         }
//         return S > 1000 ? 0 : dp[S+1000];
//     }
// }
