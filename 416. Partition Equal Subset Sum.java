// 416. Partition Equal Subset Sum
// Brute Force - dfs: Time Limit Exceeded

// class Solution {
//     public boolean canPartition(int[] nums) {
//         int total = 0;
//         for(int i=0; i<nums.length; i++) {
//             total += nums[i];
//         }
//         if((total & 1) == 1) {
//             return false;
//         }
        
//         int target = total/2;
//         return dfs(nums, nums.length-1, target);
//     }
//     private boolean dfs(int[] nums, int n, int target) {
//         if(target == 0) return true;
//         if(n == 0 || target < 0) return false;
//         return dfs(nums, n-1, target-nums[n-1]) || dfs(nums, n-1, target);
//     }
// }

// bottom up dp
//
// dp(i, j) | i denote the ith elem in nums | j denote the current sum
// dp(i, j) represent after traversing former ith elem, can we reach sum j or not
// dp(i, j) = dp(i-1, j) if nums[i] > target -> cannot pick nums[i] to partition
// dp(i, j) = dp(i-1, j) || dp(i-1, j-nums[i]) if nums[i] <= target -> can pick nums[i] t0 partition partitionon result equal to dp(i-1, j-nums[i]) or dp(i-1, j)
// dp(i-1, j) can pick but still not pick nums[i] | dp(i-1, j-nums[i]) pick nums[i] to partition.
 
// 01背包变形题 不是求和 而是求结果的或
// 优化方法也完全等同于01背包

// class Solution {
//     public boolean canPartition(int[] nums) {
//         int total = 0, maxNum = 0;
//         for(int i=0; i<nums.length; i++) {
//             maxNum = Math.max(maxNum, nums[i]);
//             total += nums[i];
//         }
//         if((total & 1) == 1) { // 剪枝
//             return false;
//         }
//         int target = total / 2;
//         if(maxNum > target) {  // 剪枝
//             return false;
//         }
//         boolean[][] dp = new boolean[nums.length+1][target+1];
//         dp[0][0] = true;
//         for(int i=1; i<=nums.length; i++) {
//             for(int j=0; j<=target; j++) {
//                 if(j < nums[i-1]) {
//                     dp[i][j] = dp[i-1][j];
//                 } else {
//                     dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i-1]];
//                 }
//             }
//         }
//         return dp[nums.length][target];
//     }
// }

class Solution {
    public boolean canPartition(int[] nums) {
        int total = 0, max = 0;
        for(int i=0; i<nums.length; i++) {
            max = Math.max(max, nums[i]);
            total += nums[i];
        }
        if((total & 1) == 1) {
            return false;
        }
        int target = total / 2;
        if(max > total) {
            return false;
        }
        boolean[] dp = new boolean[target+1];
        dp[0] = true;
        for(int i=0; i<nums.length; i++) {
            for(int j=target; j >= nums[i]; j--) {
                dp[j] = dp[j] || dp[j-nums[i]];
            }
        }
        return dp[target];
    }
}
