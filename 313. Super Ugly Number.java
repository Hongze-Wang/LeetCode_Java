// 313. Super Ugly Number
// expanded from Ugly Number II solution

public class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        if(n <= 0 || primes == null || primes.length == 0) {
            return 0;
        }
 
        int[] ugly = new int[n];
        ugly[0] = 1;
        int length = primes.length;
        int indices[] = new int[length];
        int factors[] = new int[length];
        
        for(int i=0; i<length; i++) {
            factors[i] = primes[i];
        }
        int curMin = 1;
        for(int i=1; i<n; i++) {
            curMin = factors[0];
            for(int j=1; j<length; j++) {
                curMin = Math.min(curMin, factors[j]);
            }
            ugly[i] = curMin;
            for(int j=0; j<length; j++) {
                if(curMin == factors[j]) {
                    factors[j] = primes[j] * ugly[++indices[j]];
                }
            }
        }
        return ugly[n-1];
    }
}
