// 36. Valid Sudoku

/*
Determine if a 9x9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:

Each row must contain the digits 1-9 without repetition.
Each column must contain the digits 1-9 without repetition.
Each of the 9 3x3 sub-boxes of the grid must contain the digits 1-9 without repetition.
*/

// Brute Force 0(n^3)
// Note: Other method maybe smart but you may not come across in a real interview
class Solution {
    
    private boolean isRowValid(char[] rows) {
        HashSet<Character> set = new HashSet();
        for(int i=0; i<rows.length; i++) {
            char cur = rows[i];
            if(cur != '.' && !set.add(cur)) {
                return false;
            }
        }
        return true;
    }

    private boolean isColValid(char[][] board, int col) {
        HashSet<Character> set = new HashSet();
        for(int i=0; i<board[0].length; i++) {
            char cur = board[i][col];
            if(cur != '.' && !set.add(cur)) {
                return false;
            }
        }
        return true;
    }

    private boolean isGridValid(char[][] board, int row, int col) {
        HashSet<Character> set = new HashSet();
        for(int i=row; i<row+3; i++) {
            for(int j=col; j<col+3; j++) {
                char cur = board[i][j];
                if(cur != '.' && !set.add(cur)) {
                    return false;
                }
            }
        }
        return true;
    }


    public boolean isValidSudoku(char[][] board) {
        for(int r=0; r<board.length; r++) {
            if(!isRowValid(board[r])) return false;
        }
        for(int c=0; c<board[0].length; c++) {
            if(!isColValid(board, c)) return false;
        }
        for(int r=0; r<board.length; r+=3) {
            for(int c=0; c<board.length; c+=3) {
                if(!isGridValid(board, r, c)) {
                    return false;
                }
            }
        }
        return true;
    }
}
