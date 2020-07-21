// 60. Permutation Sequence
// https://leetcode.com/problems/permutation-sequence/discuss/696910/C%2B%2B-or-100-time-space-efficient-or-Iterative-Solution-or-Detailed-Explanation-with-Example

class Solution {
public:
    vector<int> fact;
    void findfact(int n) {
        fact = vector<int>(n);
        fact[0] = 1;
        if(n == 1) return;
        fact[1] = 1;
        for(int i=2; i<n; i++) {
            fact[i] = i*fact[i-1];
        }
    }
    string getPermutation(int N, int K) {
        int n=N-1, k=K-1, nt;
        findfact(N);
        vector<int> nums(N);
        for(int i=0; i<N; i++) {
            nums[i] = i+1;
        }

        string res = "";
        while(n >= 0) {
            nt = k/fact[n];
            k = k%fact[n]; // k %= fact[n];
            res += (nums[nt]+'0');
            nums.erase(nums.begin() + nt);
            n--;
        }
        return res;
    }
};
