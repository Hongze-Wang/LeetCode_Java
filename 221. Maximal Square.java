// 221. Maximal Square

// dp

class Solution {
    public int maximalSquare(char[][] matrix) {
        if(matrix.length == 0 || matrix[0].length == 0) return 0;
        
        int rows = matrix.length, cols = matrix[0].length;
        int[][] dp = new int[rows+1][cols+1];
        int maxlen = 0;
        for(int i=1; i<=rows; i++) {
            for(int j=1; j<=cols; j++) {
                if(matrix[i-1][j-1] == '1') {
                    dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]) + 1;
                    maxlen = Math.max(dp[i][j], maxlen);
                }
            }
        }
        return maxlen * maxlen;
    }
}

// for a real interview, the above solution is sufficient

public class Solution {
    public int maximalSquare(char[][] matrix) {
        int rows = matrix.length, cols = rows>0 ? matrix[0].length : 0;
        int[] dp = new int[cols+1];
        int maxlen=0, prev=0, temp=0;
        for(int i=1; i<=rows; i++) {
            for(int j=1; j<=cols; j++) {
                temp = dp[j];
                if(matrix[i-1][j-1] == '1') {
                    dp[j] = Math.min(Math.min(dp[j-1], prev), dp[j])+1;
                    maxlen = Math.max(maxlen, dp[j]);
                } else {
                    dp[j] = 0;
                }
                prev=temp;
            }
        }
        return maxlen * maxlen;
    }
}
