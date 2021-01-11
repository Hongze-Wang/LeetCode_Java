// 51. N-Queens

// 同面试题 08.12. Eight Queens LCCI.java

// 回溯法模板题 + 找规律
// 回溯法适用于枚举问题，比如全排列、组合之类的
// 这些问题往往需要在枚举的所有情况中选择满足条件的情况生成解或者是求最优解 因此需要注意if判断条件删除一些不需要考虑的情况
// 回溯法和DFS、BFS的区别在于为了枚举 有回溯过程 即为了生成所有情况而还原某些操作 比如下面的a b1 b2 b3 都是需要回溯的操作
// 千万不能忘掉回溯 否则无法生成所有解 或者漏掉最优解的过程

// i表示第i行 j表示第j列
// 规律 对角线坐标
// 斜对角线坐标 行列坐标差值永远相等 为了避免出现负值 使用i-j+n 为此 diag1的容量应为2n
// 反斜对角线左边 行列坐标和永远相等 diag1的容量为2n

class Solution {
    
    public List<List<String>> res = new ArrayList<>();
    
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        boolean[] col = new boolean[n];
        boolean[] diag1 = new boolean[n+n];
        boolean[] diag2 = new boolean[n+n];
        
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                board[i][j] = '.';
            }
        }
        
        solveNQueens(0, n, board, col, diag1, diag2);
        
        return res;
    }
    
    
    public void solveNQueens(int i, int n, char[][] board, boolean[] col, boolean[] diag1, boolean[] diag2) {
        if(i == n) {
            List<String> list = new ArrayList<>();
            for(int r=0; r<n; r++) {
                list.add(new String(board[r]));
            }
            res.add(list);
            return;
        }
        
        for(int j=0; j<n; j++) {
            if(!col[j] && !diag1[n-i+j] && !diag2[i+j]) {
                board[i][j] = 'Q';                          // 需要回溯的更改操作1
                col[j] = diag1[n-i+j] = diag2[i+j] = true;  // 需要回溯的更改操作2
                solveNQueens(i+1, n, board, col, diag1, diag2);
                col[j] = diag1[n-i+j] = diag2[i+j] = false; // 回溯2
                board[i][j] = '.';                          // 回溯1
            }
        }
    }
}