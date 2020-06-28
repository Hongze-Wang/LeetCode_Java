// 72. Edit Distance
// https://leetcode.com/problems/edit-distance/discuss/701728/JAVA-Detailed-Explanation-w-code

// Bottom up DP

class Solution {
    public int minDistance(String word1, String word2) {
        int len1 = word1.length(), len2 = word2.length();
        int[][] dp = new int[len1+1][len2+1];
        for(int i=len1; i>=0; i--) {
            for(int j=len2; j>=0; j--) {
                if(i==len1 || j==len2) {
                    dp[i][j] = i==len1 ? len2-j : len1-i;
                } else if(word1.charAt(i) == word2.charAt(j)) {
                    dp[i][j] = dp[i+1][j+1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i+1][j+1], Math.min(dp[i+1][j], dp[i][j+1]));
                }
            }
        }
        return dp[0][0];
    }
}
