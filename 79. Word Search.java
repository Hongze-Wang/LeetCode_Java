// 79. Word Search

// Time Limit Exceeded

// class Solution {
//     boolean res = false;
    
//     private void exist(char[][] board, String word, int i, int j, int index, boolean[][] visit) {
//         if(i<0 || i>=board.length || j<0 || j>=board[0].length) return;
//         if(visit[i][j] == true) return;
//         if(index >= word.length()) return;
        
//         visit[i][j] = true;
//         if(board[i][j] == word.charAt(index)) {
//             if(index == word.length()-1) {
//                 res = true;
//             } else {
//                 exist(board, word, i+1, j, index+1, visit);
//                 exist(board, word, i-1, j, index+1, visit);
//                 exist(board, word, i, j+1, index+1, visit);
//                 exist(board, word, i, j-1, index+1, visit);
//                 visit[i][j] = false;
//             }
//         } else {
//             visit[i][j] = false;
//             return;
//         }
//     }
            
//     public boolean exist(char[][] board, String word) {
//         if(word == null) return false;
//         if(board.length == 0 || board[0].length == 0) return false;

//         boolean[][] visit = new boolean[board.length][board[0].length];
        
//         for(int i=0; i<board.length; i++) {
//             for(int j=0; j<board[0].length; j++) {
//                 if(board[i][j] == word.charAt(0)) {
//                     exist(board, word, i, j, 0, visit);
//                 }
//             }
//         }
//         return res;
//     }
// }

class Solution {
    public boolean exist(char[][] board, String word) {
        if(board.length == 0 || board[0].length == 0) return false;
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[0].length; j++) {
                if(search(board, word, 0, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }
    private boolean search(char[][] board, String word, int index, int i, int j) {
        if(i<0 || i==board.length || j<0 || j==board[0].length || word.charAt(index) != board[i][j]) {
            return false;
        }
        if(index == word.length()-1) return true;
        char cur = board[i][j];
        board[i][j] = 0;
        boolean found = search(board, word, index+1, i+1, j) ||
                        search(board, word, index+1, i, j+1) ||
                        search(board, word, index+1, i-1, j) ||
                        search(board, word, index+1, i, j-1);
        board[i][j] = cur;
        return found;
    }
}
