// 52. N-Queens II

// class Solution {
    
//     public int res = 0;
    
//     public void solveNQueens(int n) {
//         char[][] board = new char[n][n];
//         boolean[] col = new boolean[n];
//         boolean[] diag1 = new boolean[n+n];
//         boolean[] diag2 = new boolean[n+n];
        
//         for(int i=0; i<n; i++) {
//             for(int j=0; j<n; j++) {
//                 board[i][j] = '.';
//             }
//         }
        
//         solveNQueens(0, n, board, col, diag1, diag2);
        
//     }
    
    
//     public void solveNQueens(int i, int n, char[][] board, boolean[] col, boolean[] diag1, boolean[] diag2) {
//         if(i == n) {
//             res++;
//         }
        
//         for(int j=0; j<n; j++) {
//             if(!col[j] && !diag1[n-i+j] && !diag2[i+j]) {
//                 board[i][j] = 'Q';
//                 col[j] = diag1[n-i+j] = diag2[i+j] = true;
//                 solveNQueens(i+1, n, board, col, diag1, diag2);
//                 col[j] = diag1[n-i+j] = diag2[i+j] = false;
//                 board[i][j] = '.';
//             }
//         }
//     }
    
//     public int totalNQueens(int n) {
//         solveNQueens(n);
//         return res;
//     }
// }

// 使用整型的二进制表示做标志位
// 用n个十进制数 即可表示棋盘 0 表示可以放Q 1表示不能放Q

// 一旦某一行被放置了Q 则该位置变为1 整行整列都不能放Q了 因而整行整列都变成1 对应for循环操作a
// 反对角线 不能放Q 对应循环操作b
// 对角线   不能放Q 对应循环操作c

// 以n = 3为例
// 000b = 0
// 000b = 0
// 000b = 0
 
// 我们在第一行第一列放置Q Q存的是1 我这里为了区别因为本列本行或者对角线放了Q而不能放的位置 写成了Q
// Q00b = 4
// 000  = 0
// 000  = 0

// for循环a操作 使得
// Q11  = 7
// 100  = 4
// 100  = 4

// for循环b操作 使得
// Q11  = 7
// 110  = 6
// 100  = 4

// for循环c操作 使得
// Q11  = 7
// 110  = 6
// 101  = 5

// 最终得到
// Q11  = 7
// 11Q  = 7
// 1Q1  = 7
// 只有这一种解


class Solution {
    
    public int total = 0;

    public int totalNQueens(int[] queens, int len) {
        int total = 0;
        for(int i=0; i<queens.length; i++) {
            if((queens[len-1] & (1 << i)) == 0) {
                if(len == queens.length) {
                    total += 1;
                } else {
                    int[] rem = new int[queens.length-len];
                    for(int j=len; j<queens.length; j++) {
                        rem[j-len] = queens[j];            // 储存操作前状态 为了回溯
                        queens[j] |= 1 << i;               // 操作a
                        queens[j] |= 1 << (i+j - len + 1); // 操作b 对角线规律 行列坐标和相等 -len+1 防止溢出n
                        queens[j] |= 1 << (i-j + len - 1); // 操作c 对角线规律 行列坐标差相等 +len-1 防止小于0
                    }
                    total += totalNQueens(queens, len+1);
                    for(int j=len; j<queens.length; j++) {
                        queens[j] = rem[j-len];            // 回溯操作 同时撤销了操作a、b、c
                    }
                }
            }
        }
        return total;
    }

    public int totalNQueens(int n) {
        int[] queens = new int[n];
        return totalNQueens(queens, 1);
    }
}
