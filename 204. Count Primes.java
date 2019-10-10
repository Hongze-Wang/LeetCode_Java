// 204. Count Primes

// 更多解法参见Python解法

class Solution {
    public int countPrimes(int n) {
        if(n <= 2) {
            return 0;
        }
        int count = 1;
        boolean isNotPrime[] = new boolean[n+1];

        for(int i = 3; i*i <= n; i += 2) { // 偶数不需要判断 所以可以写+2
            if(isNotPrime[i]) {
                continue;
            }
            for(int j = i*i; j <= n; j += 2*i) {
                isNotPrime[j] = true;
            }
        }

        for(int i = 3; i < n; i += 2) {
            if(!isNotPrime[i]) {
                count++;
            }
        }
        return count;
    }
}