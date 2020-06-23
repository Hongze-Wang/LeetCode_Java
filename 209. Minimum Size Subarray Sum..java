// 209. Minimum Size Subarray Sum
// two pointers

class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int left = 0, sum = 0, ans = Integer.MAX_VALUE;
        for(int i=0; i<nums.length; i++) {
            sum += nums[i];
            while(sum >= s) {
                ans = Math.min(ans, i+1-left);
                sum -= nums[left++];
            }
        }
        return (ans == Integer.MAX_VALUE) ? 0 : ans;
    }
}
