// 62. Unique Paths
// DP的关键在于递推式
// num(i, j) = num(i-1, j) + num(i, j-1)
// 直观理解即为 到达某格子的单一路径数 = 到达上方格子的路径数 + 到达左方格子的路径数
// 因为之能向左 或 向下移动

// 100% faster
class Solution {
    public int uniquePaths(int m, int n) {
        int [][] array = new int[m][n];
        for(int i=0; i<m; i++) {
            array[i][0] = 1;
        }
        for(int i=0; i<n; i++) {
            array[0][i] = 1;
        }
        for(int i=1; i<m; i++){
            for(int j=1; j<n; j++) {
                array[i][j] = array[i-1][j] + array[i][j-1];
            }
        }
        return array[m-1][n-1];
    }
}