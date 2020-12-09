// 100% faster 20.75% memory less

class Solution {
public:
    int firstMissingPositive(vector<int>& nums) {
        sort(nums.begin(), nums.end());
        int n=1, len = nums.size();
        for(int i=0; i<len; i++) {
            if(nums[i] <= 0) {
                continue;
            }
            if(nums[i] != n) {
                return n;
            } else {
                n++;
                while(i+1 < len && nums[i] == nums[i+1]) { // 去重
                    i++;
                }
            }
        }
        return n;
    }
};