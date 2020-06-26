// 1143. Longest Common Subsequence

// Simple DP Solution
// dp(i,j) = dp(i-1,j-1) + 1 if str(i) == str(j)
// dp(i,j) = max(dp(i-1,j), dp(i, j-1)) if str(i) != str(j)

// class Solution {
//     public int longestCommonSubsequence(String text1, String text2) {
//         int dp[][] = new int[text1.length()+1][text2.length()+1];
//         // for(int i=0; i<=text1.length(); i++) {
//         //     dp[i][0] = 0;
//         // }
//         // for(int i=0; i<=text2.length(); i++) {
//         //     dp[0][i] = 0;
//         // }
//         for(int i=1; i<=text1.length(); i++) {
//             for(int j=1; j<=text2.length(); j++) {
//                 if(text1.charAt(i-1) == text2.charAt(j-1)) {
//                     dp[i][j] = dp[i-1][j-1] + 1;
//                 } else {
//                     dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
//                 }
//             }
//         }
//         return dp[text1.length()][text2.length()];
//     }
// }

class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int len1 = text1.length(), len2 = text2.length();
        int dp[][] = new int[len1+1][len2+1];

        for(int i=1; i<=len1; i++) {
            for(int j=1; j<=len2; j++) {
                if(text1.charAt(i-1) == text2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[len1][len2];
    }
}

class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        char[] c1=text1.toCharArray();
        char[] c2=text2.toCharArray();
        int[][] dp=new int[c1.length+1][c2.length+1];
        for(int i=1;i<=c1.length;i++){
            for(int j=1;j<=c2.length;j++){
                if(c1[i-1]==c2[j-1])
                    dp[i][j]=dp[i-1][j-1]+1;
                else
                    dp[i][j]=Math.max(dp[i][j-1],dp[i-1][j]);
            }
        }
        return dp[c1.length][c2.length];
    }
}
