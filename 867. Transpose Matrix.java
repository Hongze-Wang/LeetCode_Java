// 867. Transpose Matrix

// 转换公式 m(i, j) = m(j, i) 矩阵转置意味着行变列
class Solution {
    public int[][] transpose(int[][] A) {
        int[][] res = new int[A[0].length][A.length];
        for(int i=0; i<A.length; i++) {
            for(int j=0; j<A[0].length; j++) {
                res[j][i] = A[i][j];
            }
        }
        return res;
    }
}
