// 485. Max Consecutive Ones

class Solution {
public:
    int findMaxConsecutiveOnes(vector<int>& nums) {
        int left = 0, res = 0;
        for(int i=0; i<nums.size(); i++) {
            if(nums[i] == 0) {
                left = i+1;
            }
            res = max(res, i-left+1);
        }
        return res;
    }
};
