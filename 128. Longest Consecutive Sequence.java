// 128. Longest Consecutive Sequence

class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length < 2) return nums.length;
        
        Arrays.sort(nums);
        int len = 1, res = 0;
        for(int i=0; i<nums.length-1; i++) {
            if(nums[i] == nums[i+1]-1) {
                len++;
            } else if(nums[i] == nums[i+1]){
                // do nothing
            } else {
                len = 1;
            }
            res = Math.max(res, len);
        }
        return res;
    }
}
