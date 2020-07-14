class Solution {
public:
    vector<int> grayCode(int n) {
        vector<int> res;
        res.push_back(0)
        if(n == 0) return res;
        for(int i=1; i<n; i++) {
            int add= 1<<i;
            int end = res.size()-1;
            while(end >= 0) {
                res.push_back(res[end--] + add);
            }
        }
        return res;
    }
};
