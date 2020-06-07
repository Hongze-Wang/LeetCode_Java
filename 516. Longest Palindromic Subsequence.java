// 516. Longest Palindromic Subsequence

// two pointer + Dp
// DP: maxlen(i,j) = 2  + maxlen(i+1, j-1) / Max(maxlen(i+1,j), maxlen(i, j-1))
// waste half space and the len part is kind of brute force
class Solution {
    public int longestPalindromeSubseq(String s) {
        if(s == null) return 0;
        int len = s.length();
        int[][] dp = new int[len][len];
        // Each single char is a palindrome
        for(int i=0; i<len; i++) {
            dp[i][i] = 1;
        }
        for(int l=1; l<len; l++) {
            for(int left=0; left+l<len; left++) {
                int right = left + l;
                if(s.charAt(left) == s.charAt(right)) {
                    dp[left][right] = 2 + dp[left+1][right-1];
                } else {
                    dp[left][right] = Math.max(dp[left+1][right], dp[left][right-1]);
                }
            }
        }
        return dp[0][len-1];
    }
}
