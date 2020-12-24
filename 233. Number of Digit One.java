// # 233. Number of Digit One
// # brute force time limit exceeded

// class Solution:
//     def countDigitOne(self, n: int) -> int:
//         count = 0
//         for i in range(1, n+1):
//             s = str(i)
//             count += s.count("1")
//         return count

// 233. Number of Digit One

class Solution {
    public int countDigitOne(int n) {
        int cnt = 0;
        for (long m = 1; m <= n; m *= 10) {
            long a = n / m, b = n % m;
            cnt += (a + 8) / 10 * m + (a % 10 == 1 ? b + 1 : 0);
        }
        return cnt;
    }
}