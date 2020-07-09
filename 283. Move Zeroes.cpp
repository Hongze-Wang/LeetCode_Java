// 283. Move Zeroes
class Solution {
public:
    void moveZeroes(vector<int>& nums) {
        for(int lastNonZeroIndex=0, cur=0; cur < nums.size(); cur++) {
            if(nums[cur] != 0) {
                swap(nums[lastNonZeroIndex++], nums[cur]);
            }
        }
    }
};
