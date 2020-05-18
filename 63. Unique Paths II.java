// 63. Unique Paths II
// set num(0,0)=1
// for frist row or column 
// if curr cell has no obstacle num(i, 0) = num(i-1, 0) or num(0, j) = num(0, j-1)
// else num(i, 0) = 0 or num(0, j) = 0
// for other cell
// if curr cell has no obstacle num(i, j) = num(i-1, j) + num(i, j-1)
// else num(i, j) = 0
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid[0][0] == 1 ||  obstacleGrid[obstacleGrid.length-1][obstacleGrid[0].length-1] == 1) return 0;
        
        int R = obstacleGrid.length, C = obstacleGrid[0].length;
        
        obstacleGrid[0][0] = 1;
        for(int i=1; i<R; i++) {
            obstacleGrid[i][0] = (obstacleGrid[i][0] == 0 && obstacleGrid[i-1][0] == 1) ? 1 : 0; //cuur cell has no obstacle and previous cell is reachable
        }
        for(int i=1; i<C; i++) {
            obstacleGrid[0][i] = (obstacleGrid[0][i] == 0 && obstacleGrid[0][i-1] == 1) ? 1 : 0;
        }
        for(int i=1; i<R; i++) {
            for(int j=1; j<C; j++) {
                if(obstacleGrid[i][j] == 0) {
                    obstacleGrid[i][j] = obstacleGrid[i-1][j] + obstacleGrid[i][j-1];
                } else {
                    obstacleGrid[i][j] = 0;
                }
            }
        }
        return obstacleGrid[R-1][C-1];
    }
}