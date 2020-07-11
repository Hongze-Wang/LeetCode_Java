// 338. Counting Bits

class Solution {
public:
    vector<int> countBits(int num) {
        vector<int> ans;
        int count=0;
        ans.push_back(0);
        for(int i=1; i<=num; i++) {
            count = i & (i-1);
            ans.push_back(ans[count]+1);
        }
        return ans;
    }
};
