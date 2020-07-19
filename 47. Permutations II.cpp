// 47. Permutations II

class Solution {
public:
    vector<vector<int>> permuteUnique(vector<int>& nums) {
        sort(nums.begin(), nums.end());
        vector<vector<int>> res = {nums};
        // if(nums.size() == 0) return res;
        while(next_permutation(nums.begin(),nums.end())) {
            res.push_back(nums);
        }
        return res;
    }
};
