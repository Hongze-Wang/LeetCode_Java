// 289. Game of Life

// 双百解法
// 解法中注释了不需要更改的代码是为了辅助思考
// 在思考阶段就应该想到 只需要处理改变的情况就可以

                // // 活的细胞死去 需要更改
                // if(board[r][c] == 1 && (count < 2 || count > 3)) {
                //     board[r][c] = -1; // 别的位置仍需要考虑该位置细胞是存活的 因为改成-1 绝对值为1 和 等于1的情况等价
                // }
                // // 死的细胞活了 需要更改
                // if(board[r][c] == 0 && count == 3) {
                //     board[r][c] = 2;
                // }
                // // 活的细胞还活着 不需要更改
                // // if(board[r][c] == 1 && (count == 2 || count == 3)) {
                // //     board[r][c] = 1;
                // // }
                // // 同理 死的细胞没有活也不需要更改

class Solution {
public:
    void gameOfLife(vector<vector<int>>& board) {
        int neighbors[3] = {-1, 0, 1};
        int rows = board.size();
        int cols = board[0].size();

        for(int r=0; r<rows; r++) {
            for(int c=0; c<cols; c++) {
                int count = 0;
                for(int i=0; i<3; i++) {
                    for(int j=0; j<3; j++) {
                        if(neighbors[i] != 0 || neighbors[j] != 0) {
                            int x = r + neighbors[i];
                            int y = c + neighbors[j];
                            if(x<rows && x >= 0 && y<cols && y>=0 && abs(board[x][y]) == 1) {
                                count++;
                            }
                        }
                    }
                }
                // 活的细胞死去 需要更改
                if(board[r][c] == 1 && (count < 2 || count > 3)) {
                    board[r][c] = -1; // 别的位置仍需要考虑该位置细胞是活的 因此改成-1 绝对值为1 和 等于1的情况等价
                }
                // 死的细胞活了 需要更改
                if(board[r][c] == 0 && count == 3) {
                    board[r][c] = 2;  // 别的位置仍需要考虑该位置细胞是死的 因此改成2  绝对值为2 和 等于1的情况区分
                }
            }
        }

        for(int r=0; r<rows; r++) {
            for(int c=0; c<cols; c++) {
                if(board[r][c] > 0) {
                    board[r][c] = 1;
                } else {
                    board[r][c] = 0;
                }
            }
        }
    }
};