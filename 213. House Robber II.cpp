// 213. House Robber II

class Solution {
public:
    int rob(vector<int>& nums) {
        int n = nums.size();
        if(n == 0) return 0;
        if(n == 1) return nums[0];
        
        vector<int> dp1(n+1, 0);
        vector<int> dp2(n+1, 0);
        
        for(int i=2; i<n+1; i++) {
            dp1[i] = max(dp1[i-1], nums[i-2]+dp1[i-2]);
            dp2[i] = max(dp2[i-1], nums[i-1]+dp2[i-2]);
        }
        return max(dp1[n], dp2[n]);
    }
};
