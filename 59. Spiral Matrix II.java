// 59. Spiral Matrix II
// same solution as 54. Spiral Matrix.java
class Solution {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int left=0, right=n-1, up=0, down=n-1;
        int num=1, mode=0;
        while(left <= right && up <= down) {
            if(mode == 0) {
                for(int i=left; i<=right; i++) {
                    res[up][i] = num++;
                }
                up++;
            } else if(mode == 1) {
                for(int i=up; i <= down; i++) {
                    res[i][right] = num++;
                }
                right--;
            } else if(mode == 2) {
                for(int i=right; i>= left; i--) {
                    res[down][i] = num++;
                }
                down--;
            } else {
                for(int i=down; i>=up; i--) {
                    res[i][left] = num++;
                }
                left++;
            }
            mode = (mode+1) % 4;
        }
        return res;
    }
}
