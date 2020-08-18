// 45. Jump Game II

class Solution {
public:
    int jump(vector<int>& nums) {
        int n = nums.size();
        int pos = 0, reachable = 0, count = 0;
        for(int i=0; i<n-1; i++) {
            reachable = max(reachable, i+nums[i]);
            if(i == pos) {
                pos = reachable;
                count++;
            }
        }
        return count;
    }
};
