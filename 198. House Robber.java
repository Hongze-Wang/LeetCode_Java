// 198. House Robber

// 本质是动态规划 从小到大的动态规划
// 不断延长比较的序列 边延长边原地存储i位置的最大值
// Note: 在每个可以相加的位置储存相加的值 用于后面的比较
// DP[i] = max{DP[i-1], nums[i]} (i >= 3)
// nums[i] = max{nums[i] + nums[i-3], nums[i] + nums[i-2]} (i >= 3)

public class Solution {
    public int rob(int[] nums) {
        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        if(nums.length == 2) return Math.max(nums[0], nums[1]);
        if(nums.length == 3) return Math.max(nums[0] + nums[2], nums[1]);

        int max = Math.max(nums[0] + nums[2], nums[1]);
        nums[2] = nums[0] + nums[2];
        for(int i = 3; i < nums.length; i++) {
            nums[i] = Math.max(nums[i] + nums[i-3], nums[i] + nums[i-2]);
            max = Math.max(max, nums[i]);
        }
        return max;
    }
}