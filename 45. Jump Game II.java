// 45. Jump Game II
// greedy: take the highest step as you can in every jump

class Solution {
    public int jump(int[] nums) {
        if(nums.length == 1) return 0;
        
        int pos = 0, reachable = 0, count = 0;
        for(int i=0; i<nums.length-1; i++) { // last elem do not need consider
            reachable = Math.max(reachable, i+nums[i]);
            if(i == pos) {
                pos = reachable;
                count++;
            }
        }
        return count;
    }
}

// reachable store the current highest position it can reach
// pos store the last hight postion it can reach
// if i == pos means that i can be reach
// update pos = reachable (currennt highest postion it can rech) greedy policy
// count increase by one
