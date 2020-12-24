// 233. Number of Digit One

// brute force time limit exceeded

// class Solution {
// public:
//     int countDigitOne(int n) {
//         int count1 = 0;
//         for(int i=0; i<=n; i++) {
//             string s = to_string(i);
//             count1 += count(s.begin(), s.end(), '1');   
//         }
//         return count1;
//     }
// };

// math
#define ll long long

class Solution {
public:
    int countDigitOne(int n) {
        int cnt = 0;
        for(ll i=1; i <= n; i*=10) {
            ll divider = i * 10;
            cnt += n / divider * i + min(max(n % divider - i + 1, 0LL), i);
        }
        return cnt;
    }
};