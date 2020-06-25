// 54. Spiral Matrix

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList();
        if(matrix.length == 0) return res;
        int left=0, right=matrix[0].length-1, up=0, down=matrix.length-1;
        int dir=0;
        while(left <= right && up <= down) {
            if(dir == 0) {
                for(int i=left; i<=right; i++) res.add(matrix[up][i]);
                up++;
            } else if(dir == 1) {
                for(int i=up; i<=down; i++) res.add(matrix[i][right]);
                right--;
            } else if(dir == 2) {
                for(int i=right; i>=left; i--) res.add(matrix[down][i]);
                down--;
            } else {
                for(int i=down; i>=up; i--) res.add(matrix[i][left]);
                left++;
            }
            dir = (dir+1) % 4;
        }
        return res;
    }
}

// standard solution
// class Solution {
//     public List < Integer > spiralOrder(int[][] matrix) {
//         List ans = new ArrayList();
//         if (matrix.length == 0)
//             return ans;
//         int r1 = 0, r2 = matrix.length - 1;
//         int c1 = 0, c2 = matrix[0].length - 1;
//         while (r1 <= r2 && c1 <= c2) {
//             for (int c = c1; c <= c2; c++) ans.add(matrix[r1][c]);
//             for (int r = r1 + 1; r <= r2; r++) ans.add(matrix[r][c2]);
//             if (r1 < r2 && c1 < c2) {
//                 for (int c = c2 - 1; c > c1; c--) ans.add(matrix[r2][c]);
//                 for (int r = r2; r > r1; r--) ans.add(matrix[r][c1]);
//             }
//             r1++;
//             r2--;
//             c1++;
//             c2--;
//         }
//         return ans;
//     }
// }
